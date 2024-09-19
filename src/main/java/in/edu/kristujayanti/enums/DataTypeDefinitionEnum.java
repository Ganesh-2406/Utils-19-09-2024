package in.edu.kristujayanti.enums;

import javax.swing.text.Document;
import java.util.Currency;
import java.util.List;

public enum DataTypeDefinitionEnum {
    BOOL("_Bool", Boolean.class),
    DATE("_Date", Long.class),
    TEXT("_Text", String.class),
    EMAIL("_Email", String.class),
    INT("_Int", Integer.class),
    LONG("_Long", Long.class),
    PERCENTAGE("_Percentage", Double.class),
    DOUBLE("_Double", Double.class),
    DATETIME("_DateTime", Long.class),
    ARRAY("_Array", List.class),
    FILE("_File", String.class),
    IMAGE("_Image", String.class),
    CURRENCY("_Currency", Double.class),
    DOCUMENT("_Document", Document.class),
    TEXTARRAY("_TextArray", String.class),
    DOCUMENTARRAY("_DocumentArray", Document.class);


    private final String appendedString;
    private final Class dataTypeDefinitionClass;

    DataTypeDefinitionEnum(String appendedString, Class dataTypeDefinitionClass) {
        this.appendedString = appendedString;
        this.dataTypeDefinitionClass = dataTypeDefinitionClass;
    }

    public String getAppendedString() {
        return appendedString;
    }

    public Class getDataTypeDefinitionClass() {
        return dataTypeDefinitionClass;
    }

    public static DataTypeDefinitionEnum getEnumByProperty(String propertyName, String enumValue) {
        try {
            return valueOf(enumValue.toUpperCase());
        } catch (Exception var3) {
            throw new IllegalArgumentException("Property " + propertyName + " is invalid");
        }
    }

    // $FF: synthetic method
    private static DataTypeDefinitionEnum[] $values() {
        return new DataTypeDefinitionEnum[]{BOOL,DATE, DOUBLE, INT, LONG, PERCENTAGE, TEXT, ARRAY, DOCUMENT, IMAGE, FILE, CURRENCY, TEXTARRAY,EMAIL, DOCUMENTARRAY};
    }
}
