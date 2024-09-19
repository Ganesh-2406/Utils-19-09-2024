package in.edu.kristujayanti.util;

import org.bson.Document;
import org.bson.types.ObjectId;

public class HelperMethodsUtil {
    /**
     * Convert the ObjectId to a string representation.
     *
     * @param doc the document containing the _id field
     */
    public static void convertObjectIdToString(Document doc) {
        doc.computeIfPresent("_id", (key, val) -> {
            ObjectId objectId = doc.getObjectId("_id");
            return objectId.toHexString();
        });
    }
}
