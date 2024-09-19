package in.edu.kristujayanti.util;

import in.edu.kristujayanti.dbaccess.MongoDataAccess;
import in.edu.kristujayanti.propertyBinder.PropertyBinderUtils;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

public class ExcelUploadUtil extends MongoDataAccess {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUploadUtil.class);

    // Private constructor to prevent instantiation
    private ExcelUploadUtil() {
    }

    /**
     * Retrieves the indices of the header fields in the Excel sheet.
     *
     * @param sheet          The Excel sheet.
     * @param expectedFields The list of expected fields.
     * @return A map of field names to their column indices.
     */
    private static Map<String, Integer> getHeaderIndices(Sheet sheet, List<String> expectedFields) {
        Map<String, Integer> headerIndices = new HashMap<>(); // Map to store field names and their column indices
        Row headerRow = sheet.getRow(0); // Get the header row (first row)

        for (Cell cell : headerRow) { // Iterate through each cell in the header row
            String label = cell.getStringCellValue().trim(); // Get the cell value and trim whitespace
            String propertyName = PropertyBinderUtils.getPropertyNameByDisplayName(label); // Get the property name by display name

            // Check if the property name is expected and add it to the map
            if (propertyName != null && expectedFields.contains(propertyName)) {
                headerIndices.put(propertyName, cell.getColumnIndex());
            } else if (expectedFields.contains(label)) { // If the label itself is an expected field, add it to the map
                headerIndices.put(label, cell.getColumnIndex());
            }
        }
        return headerIndices; // Return the map of field names and their column indices
    }

    /**
     * Retrieves the value of a cell as an Object.
     *
     * @param cell The cell.
     * @return The value of the cell.
     */
    private static Object getCellValue(Cell cell) {
        String cellValue = getCellStringValue(cell); // Get the cell value as a string
        return (cellValue == null || cellValue.isEmpty()) ? null : cellValue; // Return null if the value is empty, otherwise return the value
    }

    /**
     * Retrieves the string value of a cell.
     *
     * @param cell The cell.
     * @return The string value of the cell.
     */
    private static String getCellStringValue(Cell cell) {
        if (cell == null) { // Check if the cell is null
            return null; // Return null if the cell is null
        }

        // Switch case to handle different cell types
        return switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC ->
                    DateUtil.isCellDateFormatted(cell) ? String.valueOf(cell.getDateCellValue().getTime()) : BigDecimal.valueOf(cell.getNumericCellValue()).stripTrailingZeros().toPlainString();
            // If the cell is numeric, check if it is a date and return the appropriate value
            case Cell.CELL_TYPE_BOOLEAN ->
                    String.valueOf(cell.getBooleanCellValue()); // If the cell is boolean, return the boolean value as a string
            case Cell.CELL_TYPE_FORMULA -> cell.getCellFormula(); // If the cell is a formula, return the formula
            default -> cell.getStringCellValue().trim(); // Default case, return the cell value as a trimmed string
        };
    }

    /**
     * Parses an Excel file and returns a list of documents.
     *
     * @param fileData       The buffer containing the Excel file data.
     * @param requiredFields The list of required fields.
     * @param expectedFields The list of expected fields.
     * @return A list of documents parsed from the Excel file.
     * @throws IOException              If an I/O error occurs during reading the Excel file.
     * @throws IllegalArgumentException If the Excel file is missing required fields or contains invalid data.
     */
    public static List<Document> parseExcelFile(Buffer fileData, List<String> requiredFields, List<String> expectedFields) throws IOException, IllegalArgumentException {
        List<Document> documents = new ArrayList<>(); // List to store the parsed documents

        try (InputStream inputStream = new ByteArrayInputStream(fileData.getBytes())) {

            Workbook workbook = new XSSFWorkbook(inputStream);

            LOGGER.info("Starting to parse the Excel file."); // Log the start of file parsing
            Sheet sheet = workbook.getSheetAt(0); // Get the first sheet from the workbook
            Map<String, Integer> headerIndices = getHeaderIndices(sheet, expectedFields); // Get the header indices

            // Validate that all required fields are present in the header
            for (String requiredField : requiredFields) {
                if (!headerIndices.containsKey(requiredField)) {
                    String errorMessage = "Required field missing in file: " + requiredField;
                    LOGGER.error(errorMessage); // Log the missing required field
                    throw new IllegalArgumentException(errorMessage); // Throw an exception for the missing required field
                }
            }

            // Iterate through each row starting from the second row (index 1)
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex); // Get the current row
                if (row == null) {
                    continue; // Skip empty rows
                }

                Document document = new Document(); // Create a new document for each row
                for (Map.Entry<String, Integer> entry : headerIndices.entrySet()) { // Iterate through the header indices
                    String header = entry.getKey(); // Get the header field name
                    int columnIndex = entry.getValue(); // Get the column index for the header
                    Cell cell = row.getCell(columnIndex); // Get the cell at the column index
                    Object cellValue = getCellValue(cell);
                    if (cellValue != null) {
                        document.append(header, getCellValue(cell)); // Append the cell value to the document
                    }
                }

                if (document.isEmpty()) {
                    continue;
                }

                // Validate and clean the document
                JsonArray validationResponse = DocumentParser.validateAndCleanDocument(document, requiredFields);
                if (!validationResponse.isEmpty()) {
                    String errorMessage = String.format("Error in fields: <%s> for record: <%s>.", validationResponse, document);
                    LOGGER.error(errorMessage); // Log the validation error
                    throw new IllegalArgumentException(errorMessage); // Throw an exception for the validation error
                }

                documents.add(document); // Add the document to the list
                LOGGER.info("Parsed document: {}", document); // Log the parsed document
            }

            LOGGER.info("Completed parsing the Excel file."); // Log the completion of file parsing
        }

        return documents; // Return the list of parsed documents
    }
}
