package in.edu.kristujayanti.util;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import in.edu.kristujayanti.propertyBinder.PropertyBinderUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;
import java.util.*;

import static in.edu.kristujayanti.propertyBinder.KJUSYSCommonKeysPBinder.OID;

public class ExcelDownloadUtil {

    private final MongoDatabase mongoDatabase;

    public ExcelDownloadUtil(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    public Workbook createExcelWorkbook(List<String> fields, String collectionName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(collectionName != null ? collectionName : "Sheet1");

        // Add "_id" to fields if collection name is specified
        if (collectionName != null && !collectionName.isEmpty() && !fields.contains(OID.getPropertyName())) {
            fields.add(0, OID.getPropertyName());
        }

        // Create header row with provided fields
        addHeaderRow(sheet, fields);

        // Fill in rows with values if collection name is provided
        if (collectionName != null && !collectionName.isEmpty()) {
            fillRowsWithValues(sheet, collectionName, fields);
        }

        return workbook;
    }

    public static Workbook createExcelWorkbook(List<String> fields) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        // Create header row with provided fields
        addHeaderRow(sheet, fields);

        return workbook;
    }

    private static void addHeaderRow(Sheet sheet, List<String> fields) {
        Row headerRow = sheet.createRow(0);
        int columnIndex = 0;
        Iterator var5 = fields.iterator();

        while(var5.hasNext()) {
            String propertyName = (String)var5.next();
            String label = PropertyBinderUtils.getDisplayNameByPropertyName(propertyName);
            headerRow.createCell(columnIndex++).setCellValue(label != null ? label : propertyName);
        }

    }

    private void fillRowsWithValues(Sheet sheet, String collectionName, List<String> fields) {
        MongoCollection<Document> collection = this.mongoDatabase.getCollection(collectionName);
        int rowNum = 1;
        MongoCursor var6 = collection.find().iterator();

        while(var6.hasNext()) {
            Document document = (Document)var6.next();
            Row row = sheet.createRow(rowNum++);
            int columnIndex = 0;
            Iterator var10 = fields.iterator();

            while(var10.hasNext()) {
                String key = (String)var10.next();
                Object value;
                if (key.equals(OID.getPropertyName())) {
                    value = document.getObjectId("_id").toHexString();
                } else {
                    value = document.get(key);
                }

                Cell cell = row.createCell(columnIndex++);
                this.setCellValue(cell, value, key);
            }
        }

    }

    private void setCellValue(Cell cell, Object value, String key) {
        if (value instanceof Integer) {
            cell.setCellValue((double)(Integer)value);
        } else if (value instanceof Long) {
            if (key.endsWith("_Date")) {
                cell.setCellValue(DateUtils.convertMillisToDateString((Long)value));
            } else {
                cell.setCellValue((double)(Long)value);
            }
        } else if (value instanceof Double) {
            cell.setCellValue((Double)value);
        } else if (value instanceof String) {
            cell.setCellValue((String)value);
        } else {
            cell.setCellValue(value != null ? value.toString() : "");
        }

    }
}