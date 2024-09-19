package in.edu.kristujayanti.propertyBinder.Library;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;

public enum LibraryBookKeysPBInder implements KJUSYSPropertyBinder {


    /*
    BOOK_ACCESSION_TYPE
    BOOK_SECTION
    BOOK_SUBJECT1
    BOOK_PUBLISHER
    BOOK_SUBJECT2
    BOOK_VENDOR
    BOOK_CURRENCY_TYPE
    BOOK_SOURCE
    BOOK_DEPARTMENT
    BOOK_CATEGORY
     */

//Accession Id or no
    ACCESSION_ID("accessionId_LibraryBook_Text", "Accession Id", String.class),
    ACCESSION_TYPE("accessionType_LibraryBook_Text", "Accession Type", String.class),
    ACCESSION_ITEM_SAME_AS_ACCESSION_ID("accessionItemSameAsAccessionId_LibraryBook_Text", "Accession Item Same As Accession Id", String.class),
    ACCESSION_TITTLE("accessionTittle_LibraryBook_Text", "Accession Tittle", String.class),
    ACCESSION_AUTHORS("accessionAuthors_LibraryBook_Text", "Accession Authors", String.class),
    ACCESSION_VOLUME("accessionVolume_LibraryBook_Text", "Accession Volume", String.class),
    ACCESSION_SERIES("accessionSeries_LibraryBook_Text", "Accession Series", String.class),
    ACCESSION_KEYWORDS("accessionKeywords_LibraryBook_Text", "Accession Keywords", String.class),
    ACCESSION_SUBJECT1("accessionSubject1_LibraryBook_Text", "Accession Subject1", String.class),
    ACCESSION_CLASS_NO("accessionClassNo_LibraryBook_Text", "Accession Class No", String.class),
    ACCESSION_CALL_NO("accessionCallNo_LibraryBook_Text", "Accession Call No", String.class),
    ACCESSION_PUBLISHER("accessionPublisher_LibraryBook_Text", "Accession Publisher", String.class),
    ACCESSION_PUBLISHER_PLACE("accessionPublisherPlace_LibraryBook_Text", "Accession Publisher Place", String.class),

    ACCESSION_SECTION("accessionSection_LibraryBook_Text", "Accession Section", String.class),
    ACCESSION_SUB_TITTLE("accessionSubTittle_LibraryBook_Text", "Accession Sub Tittle", String.class),
    ACCESSION_EDITORS("accessionEditor_LibraryBook_Text", "Accession Editor", String.class),
    ACCESSION_LANGUAGE("accessionLanguage_LibraryBook_Text", "Accession Language", String.class),
    ACCESSION_ISBN("accessionIsbn_LibraryBook_Text", "Accession Isbn", String.class),
    ACCESSION_SOFT_COPY("accessionSoftCopy_LibraryBook_Text", "Accession Soft Copy", String.class),
    ACCESSION_SUBJECT2("accessionSubject2_LibraryBook_Text", "Accession Subject2", String.class),
    ACCESSION_IMAGE("accessionImage_LibraryBook_Text", "Accession Image", String.class),
    ACCESSION_RESPONSIBILITY("accessionResponsibility_LibraryBook_Text", "Accession Responsibility", String.class),
    ACCESSION_YEAR("accessionYear_LibraryBook_Long", "Accession Year", Long.class),

    ACCESSION_VENDOR("accessionVendor_LibraryBook_Text", "Accession Vendor", String.class),
    ACCESSION_CURRENCY_TYPE("accessionCurrencyType_LibraryBook_Text", "Accession Currency Type", String.class),
    ACCESSION_RATE("accessionRate_LibraryBook_Double", "Accession Rate", Double.class),
    ACCESSION_PRICE("accessionPrice_LibraryBook_Double", "Accession Price", Double.class),
    ACCESSION_SOURCE("accessionSource_LibraryBook_Text", "Accession Source", String.class),
    ACCESSION_DEPARTMENT("accessionDepartment_LibraryBook_Text", "Accession Department", String.class),
    ACCESSION_ITEM_STATUS("accessionItemStatus_LibraryBook_Text", "Accession Item Status", String.class),
    ACCESSION_BINDING_TYPE("accessionBindingType_LibraryBook_Text", "Accession Binding Type", String.class),

    ACCESSION_BILL_NO("accessionBillNo_LibraryBook_Text", "Accession Bill No", String.class),
    ACCESSION_BILL_DATE("accessionBillDate_LibraryBook_Long", "Accession Bill Date", Long.class),
    ACCESSION_PAGES("accessionPages_LibraryBook_Int", "Accession Pages", Integer.class),
    ACCESSION_COST("accessionCost_LibraryBook_Double", "Accession Cost", Double.class),
    ACCESSION_DISCOUNT("accessionDiscount_LibraryBook_Double", "Accession Discount", Double.class),
    ACCESSION_NET_COST_INR("accessionNetCostINR_LibraryBook_Double", "Accession Net Cost INR", Double.class),
    ACCESSION_CATEGORY("accessionCategory_LibraryBook_Text", "Accession Category", String.class),
    ACCESSION_EDITION("accessionEdition_LibraryBook_Int", "Accession Edition", Integer.class),
    ACCESSION_LOCATION("accessionLocation_LibraryBook_Text", "Accession Location", String.class),
    ACCESSION_ENTRY_DATE("accessionEntryDate_LibraryBook_Long", "Accession Entry Date", long.class);

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private LibraryBookKeysPBInder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private LibraryBookKeysPBInder(String property, String label, Class<?> dataType) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = -1;
        this.maxLength = -1;
    }

    public String getPropertyName() {
        return this.property;
    }

    public String getDisplayName() {
        return this.label;
    }

    public Class getDataType() {
        return this.dataType;
    }

    public Integer getMinLength() {
        return this.minLength;
    }

    public Integer getMaxLength() {
        return this.maxLength;
    }

    // $FF: synthetic method
    private static LibraryCheckInAndOutKeysPBinder[] $values() {
        return LibraryCheckInAndOutKeysPBinder.class.getEnumConstants();
    }
}



