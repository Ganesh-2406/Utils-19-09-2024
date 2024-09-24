package in.edu.kristujayanti.propertyBinder.Library;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;

public enum LibraryCommonKeysPBinder implements KJUSYSPropertyBinder {

    //enum variables used in Library
    LIBRARY_MEMBERSHIP_ID("libraryMembershipId_LibraryCommon_Text", "Library Membership Id", String.class),
    LIBRARY_MEMBER_NAME("libraryMemberName_LibraryCommon_Text", "Library Member Name", String.class),
    LIBRARY_MEMBER_BRANCH("libraryMemberBranch_LibraryCommon_Text", "Library Member Branch", String.class),
    LIBRARY_MEMBER_COURSE("libraryMemberCourse_LibraryCommon_Text", "Library Member Course", String.class),
    LIBRARY_MEMBER_DEPARTMENT("libraryMemberDepartment_LibraryCommon_Text", "Library Member Department", String.class),
    LIBRARY_MEMBER_PROFILE_IMAGE_UPLOAD("libraryMemberProfileImageUpload_LibraryCommon_File", "Library Member Profile Image Upload", String.class),
    LIBRARY_MEMBER_PROFILE_IMAGE_PATH("libraryMemberProfileImagePath_LibraryCommon_File", "Library Member Profile Image Path", String.class),


    //Referring the columns in erp_staff_user_profile
    EMPLOYEE_ID("employeeCode_ERPStaffUserProfile_Text", "Employee Id", String.class),
    EMPLOYEE_NAME("employeeFullName_ERPStaffUserProfile_Text", "Employee Name", String.class),
    EMPLOYEE_DEPARTMENT("employeeDepartment_ERPStaffUserProfile_Text", "Employee Department", String.class),
    EMPLOYEE_EMAIL("employeeOfficialEmail_ERPStaffUserProfile_Text", "Employee Email", String.class),
    EMPLOYEE_GENDER("employeeGender_ERPStaffUserProfile_Text", "Employee Gender", String.class),
    EMPLOYEE_PROFILE_IMAGE_FILE_PATH("employeeImageFilePath_ERPStaffUserProfile_Text", "Employee Image File Path", String.class),

    //Referring the columns in erp_staff_user_profile
    STUDENT_ID("studentRollNumber_ERPStudentUserProfile_Text", "Membership Id", String.class),
    STUDENT_NAME("studentNameAsPerMarksheet_ERPStudentUserProfile_Text", "Student Name", String.class),
    STUDENT_DEPARTMENT("studentDepartment_ERPStudentUserProfile_Text", "Student Department", String.class),
    STUDENT_COURSE("studentCourse_ERPStudentUserProfile_Text", "Student Course", String.class),
    STUDENT_GENDER("studentGender_ERPStudentUserProfile_Text", "Student Gender", String.class),
    STUDENT_EMAIL("studentEmail_ERPStudentUserProfile_Text", "Student Email", String.class),
    STUDENT_PROFILE_IMAGE_FILE_PATH("studentImageFilePath_ERPStudentUserProfile_Text", "Student Image File Path", String.class),

    MEMBERSHIP_TYPE("authRoles_AuthCommon_TextArray", "MEMBERSHIP Type", String.class);



    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private LibraryCommonKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private LibraryCommonKeysPBinder(String property, String label, Class<?> dataType) {
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
    private static LibraryCommonKeysPBinder[] $values() {
        return LibraryCommonKeysPBinder.class.getEnumConstants();
    }
}