package in.edu.kristujayanti.util;

import in.edu.kristujayanti.propertyBinder.KJUSYSCommonKeysPBinder.*;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.FileUpload;
import io.vertx.ext.web.RoutingContext;

import java.nio.file.*;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;


public final class FileUploadUtil {
    private static final Integer pdfUploadMaximumSize = 500;
    private static final String PDF_EXTENSION = ".pdf";

    public static void deleteFile(String filePath) throws Exception {
        try {
            Path target = Paths.get(filePath);
            Files.delete(target);
        } catch (Exception e) {
            throw e;
        }
    }

    public static JsonObject uploadFile(List<String> propertyNames, String uploadPath, RoutingContext routingContext, String fileName) throws Exception {
        JsonObject uploadType = new JsonObject();
        Path directory = Path.of(uploadPath);
        if (!Files.exists(directory, LinkOption.NOFOLLOW_LINKS)) {
            Files.createDirectories(directory);
        }

        for (FileUpload fileUpload : routingContext.fileUploads()) {
            for (String uploadProperty : propertyNames) {
                if (fileUpload.name().equals(uploadProperty)) {
                    String uploadedFile = fileUpload.uploadedFileName();
                    Path source = Paths.get(uploadedFile);

                    // Get the file extension from the original filename
                    String originalFileName = fileUpload.fileName();
                    String fileExtension = "";
                    int lastDotIndex = originalFileName.lastIndexOf('.');
                    if (lastDotIndex > 0) {
                        fileExtension = originalFileName.substring(lastDotIndex);
                    }

                    // Construct the new filename using the provided fileName parameter and the original extension
                    String newFileName = fileName + fileExtension;
                    String uploadedFileName = Paths.get(uploadPath, newFileName).toString();
                    Path target = Paths.get(uploadedFileName);

                    try {
                        if (Files.exists(target, LinkOption.NOFOLLOW_LINKS)) {
                            Files.delete(target);
                        }
                        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
                        uploadType.put(uploadProperty, uploadedFileName);
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
        }
        return uploadType;
    }

    public static JsonObject uploadFile(String fileBufferName, String originalFileName, String uploadPath, String fileName) throws Exception {
        JsonObject uploadType = new JsonObject();
        Path directory = Path.of(uploadPath);

        // Check if the directory exists; if not, create it
        if (!Files.exists(directory, LinkOption.NOFOLLOW_LINKS)) {
            Files.createDirectories(directory);
        }

        // Extract the file extension from the original file name
        String fileExtension = "";
        int lastDotIndex = originalFileName.lastIndexOf('.');
        if (lastDotIndex > 0) {
            fileExtension = originalFileName.substring(lastDotIndex);
        }

        Path source = Paths.get(fileBufferName);
        String newFileName = fileName + fileExtension;
        String uploadedFileName = Paths.get(uploadPath, newFileName).toString();
        Path target = Paths.get(uploadedFileName);

        try {
            if (Files.exists(target, LinkOption.NOFOLLOW_LINKS)) {
                Files.delete(target);
            }

            // Write the file data to the target location
            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);

            uploadType.put(fileName, uploadedFileName);
        } catch (Exception e) {
            throw e;
        }

        return uploadType;
    }

    private static boolean isValidFileExtension(String fileName) {
        return fileName.toLowerCase().endsWith(PDF_EXTENSION);
    }

    public static String validateFileSizeAndExtension(String fileName, long fileSize) {
        if (!isValidFileExtension(fileName)) {
            return "File extension must be .pdf";
        }
        double fileSizeInKB = fileSize / 1024.0;
        if (fileSizeInKB > pdfUploadMaximumSize) {
            return "Uploaded PDF exceeds maximum file size limit of " + pdfUploadMaximumSize + " KB";
        }
        return null;
    }
}