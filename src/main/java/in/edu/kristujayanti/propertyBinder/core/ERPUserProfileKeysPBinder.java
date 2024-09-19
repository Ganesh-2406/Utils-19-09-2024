package in.edu.kristujayanti.propertyBinder.core;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;

public enum ERPUserProfileKeysPBinder implements KJUSYSPropertyBinder {
    // Personal Details
    EMPLOYEE_SALUTATION("employeeSalutation_ERPUserProfile_Text", "Employee Salutation", String.class),
    EMPLOYEE_FULL_NAME("employeeFullName_ERPUserProfile_Text", "Employee Full Name", String.class),
    EMPLOYEE_FATHER_NAME("employeeFatherName_ERPUserProfile_Text", "Employee Father Name", String.class),
    EMPLOYEE_MOTHER_NAME("employeeMotherName_ERPUserProfile_Text", "Employee Mother Name", String.class),
    EMPLOYEE_SPOUSE_NAME("employeeSpouseName_ERPUserProfile_Text", "Employee Spouse Name", String.class),
    EMPLOYEE_DOB("employeeDob_ERPUserProfile_Date", "Employee DOB", Long.class),
    EMPLOYEE_PERSONAL_EMAIL("employeePersonalEmail_ERPUserProfile_Text", "Employee Personal Email", String.class),
    EMPLOYEE_MARITAL_STATUS("employeeMaritalStatus_ERPUserProfile_Text", "Employee Marital Status", String.class),
    EMPLOYEE_GENDER("employeeGender_ERPUserProfile_Text", "Employee Gender", String.class),
    EMPLOYEE_MOBILE_NUMBER("employeeMobileNumber_ERPUserProfile_Text", "Employee Mobile Number", String.class),
    EMPLOYEE_WHATSAPP_NUMBER("employeeWhatsappNumber_ERPUserProfile_Text", "Employee Whatsapp Number", String.class),
    EMPLOYEE_EMERGENCY_CONTACT_NAME("employeeEmergencyContactName_ERPUserProfile_Text", "Employee Emergency Contact Name", String.class),
    EMPLOYEE_EMERGENCY_CONTACT_NUMBER("employeeEmergencyContactNumber_ERPUserProfile_Text", "Employee Emergency Contact Number", String.class),

    // Additional Details
    EMPLOYEE_AADHAR_NUMBER("employeeAadharNumber_ERPUserProfile_Text", "Employee Aadhar Number", String.class),
    EMPLOYEE_PAN_NUMBER("employeePanNumber_ERPUserProfile_Text", "Employee Pan Number", String.class),
    EMPLOYEE_NATIONALITY("employeeNationality_ERPUserProfile_Text", "Employee Nationality", String.class),
    EMPLOYEE_MOTHER_TONGUE("employeeMotherTongue_ERPUserProfile_Text", "Employee Mother Tongue", String.class),
    EMPLOYEE_RELIGION("employeeReligion_ERPUserProfile_Text", "Employee Religion", String.class),
    EMPLOYEE_SOCIAL_CATEGORY("employeeSocialCategory_ERPUserProfile_Text", "Employee Social Category", String.class),
    EMPLOYEE_BLOOD_GROUP("employeeBloodGroup_ERPUserProfile_Text", "Employee Blood Group", String.class),
    EMPLOYEE_IS_DIFFERENTLY_ABLED("employeeIsDifferentlyAbled_ERPUserProfile_Bool", "Employee Has Disability", Boolean.class),

    // Professional Details
    EMPLOYEE_CODE("employeeCode_ERPUserProfile_Text", "Employee Code", String.class),
    EMPLOYEE_APPOINTMENT_ORDER_NUMBER("employeeAppointmentOrderNumber_ERPUserProfile_Text", "Employee Appointment Order Number", String.class),
    EMPLOYEE_JOINING_DATE("employeeJoiningDate_ERPUserProfile_Date", "Employee Joining Date", Long.class),
    EMPLOYEE_TYPE("employeeType_ERPUserProfile_Text", "Employee Type", String.class),
    EMPLOYEE_JOB_TYPE("employeeJobType_ERPUserProfile_Text", "Employee Job Type", String.class),
    EMPLOYEE_OFFICIAL_EMAIL("employeeOfficialEmail_ERPUserProfile_Text", "Employee Official Email", String.class),
    EMPLOYEE_PROBATION_START_DATE("employeeProbationStartDate_ERPUserProfile_Date", "Employee Probation Start Date", Long.class),
    EMPLOYEE_PROBATION_END_DATE("employeeProbationEndDate_ERPUserProfile_Date", "Employee Probation End Date", Long.class),
    EMPLOYEE_CATEGORY("employeeCategory_ERPUserProfile_Text", "Employee Category", String.class),
    EMPLOYEE_PF_NUMBER("employeePFNumber_ERPUserProfile_Text", "Employee PF Number", String.class),
    EMPLOYEE_CURRENT_CAMPUS("employeeCurrentCampus_ERPUserProfile_Text", "Employee Current Campus", String.class),
    EMPLOYEE_DEPARTMENT("employeeDepartment_ERPUserProfile_Text", "Employee Department", String.class),
    EMPLOYEE_SUB_DEPARTMENT("employeeSubDepartment_ERPUserProfile_Text", "Employee Sub Department", String.class),

    // Other
    EMPLOYEE_BANK_BRANCH_NAME("employeeBankBranchName_ERPUserProfile_Text", "Employee Bank Branch Name", String.class),
    EMPLOYEE_BANK_IFSC_CODE("employeeBankIFSCCode_ERPUserProfile_Text", "Employee Bank IFSC Code", String.class),
    EMPLOYEE_BANK_ACCOUNT_NUMBER("employeeBankAccountNumber_ERPUserProfile_Text", "Employee Bank Account Number", String.class),
    EMPLOYEE_BANK_ACCOUNT_HOLDER_NAME("employeeBankAccountHolderName_ERPUserProfile_Text", "Employee Bank Account Holder Name", String.class),

    EMPLOYEE_PRESENT_ADDRESS("employeePresentAddress_ERPUserProfile_Text", "Employee Present Address", String.class),
    EMPLOYEE_PRESENT_STATE("employeePresentState_ERPUserProfile_Text", "Employee Present State", String.class),
    EMPLOYEE_PRESENT_DISTRICT("employeePresentDistrict_ERPUserProfile_Text", "Employee Present District", String.class),
    EMPLOYEE_PRESENT_PINCODE("employeePresentPincode_ERPUserProfile_Text", "Employee Present Pincode", String.class),

    EMPLOYEE_PERMANENT_ADDRESS("employeePermanentAddress_ERPUserProfile_Text", "Employee Permanent Address", String.class),
    EMPLOYEE_PERMANENT_STATE("employeePermanentState_ERPUserProfile_Text", "Employee Permanent State", String.class),
    EMPLOYEE_PERMANENT_DISTRICT("employeePermanentDistrict_ERPUserProfile_Text", "Employee Permanent District", String.class),
    EMPLOYEE_PERMANENT_PINCODE("employeePermanentPincode_ERPUserProfile_Text", "Employee Permanent Pincode", String.class),

    // Academic Qualification details
    // 10th
    EMPLOYEE_TENTH_MONTH_OF_PASSING("employeeTenthMonthOfPassing_ERPUserProfile_Text","Employee 10th Month Of Passing", String.class),
    EMPLOYEE_TENTH_YEAR_OF_PASSING("employeeTenthYearOfPassing_ERPUserProfile_Int","Employee 10th Year Of Passing", Integer.class),
    EMPLOYEE_TENTH_CERTIFICATE("employeeTenthCertificate_ERPUserProfile_File","Employee 10th Certificate", String.class),
    // 12th
    EMPLOYEE_TWELFTH_MONTH_OF_PASSING("employeeTwelfthMonthOfPassing_ERPUserProfile_Text", "Employee 12th Month Of Passing", String.class),
    EMPLOYEE_TWELFTH_YEAR_OF_PASSING("employeeTwelfthYearOfPassing_ERPUserProfile_Int", "Employee 12th Year Of Passing", Integer.class),
    EMPLOYEE_TWELFTH_CERTIFICATE("employeeTwelfthCertificate_ERPUserProfile_File", "Employee 12th Certificate", String.class),
    // UG
    EMPLOYEE_UNDERGRADUATE_QUALIFICATION("employeeUndergraduateQualification_ERPUserProfile_Text","Employee UG Qualification", String.class),
    EMPLOYEE_UNDERGRADUATE_MONTH_OF_PASSING("employeeUndergraduateMonthOfPassing_ERPUserProfile_Text", "Employee Undergraduate Month Of Passing", String.class),
    EMPLOYEE_UNDERGRADUATE_YEAR_OF_PASSING("employeeUndergraduateYearOfPassing_ERPUserProfile_Int", "Employee Undergraduate Year Of Passing", Integer.class),
    EMPLOYEE_UNDERGRADUATE_CERTIFICATE("employeeUndergraduateCertificate_ERPUserProfile_File", "Employee Undergraduate Certificate", String.class),
    // pg
    EMPLOYEE_POSTGRADUATE_QUALIFICATION("employeePostgraduateQualification_ERPUserProfile_Text", "Employee PG Qualification", String.class),
    EMPLOYEE_POSTGRADUATE_MONTH_OF_PASSING("employeePostgraduateMonthOfPassing_ERPUserProfile_Text", "Employee Postgraduate Month Of Passing", String.class),
    EMPLOYEE_POSTGRADUATE_YEAR_OF_PASSING("employeePostgraduateYearOfPassing_ERPUserProfile_Int", "Employee Postgraduate Year Of Passing", Integer.class),
    EMPLOYEE_POSTGRADUATE_CERTIFICATE("employeePostgraduateCertificate_ERPUserProfile_File", "Employee Postgraduate Certificate", String.class),
    // NET
    EMPLOYEE_IS_NET_EXAM_QUALIFIED("employeeIsNetExamQualified_ERPUserProfile_Bool","Employee NET Exam Qualified", Boolean.class),
    EMPLOYEE_IS_JRF_QUALIFIED("employeeIsJrfQualified_ERPUserProfile_Bool","Employee  is JRF Qualified", Boolean.class),
    EMPLOYEE_NET_EXAM_CLEARED_MONTH("employeeNetExamClearedMonth_ERPUserProfile_Text","Employee NET Exam Qualified Month", String.class),
    EMPLOYEE_NET_EXAM_CLEARED_YEAR("employeeNetExamClearedYear_ERPUserProfile_Int","Employee NET Exam Qualified Year", Integer.class),
    EMPLOYEE_NET_QUALIFICATION_CERTIFICATE("employeeNetQualificationCertificate_ERPUserProfile_File","Employee NET Certificate", String.class),
    EMPLOYEE_JRF_CERTIFICATE("employeeJrfCertificate_ERPUserProfile_File","Employee JRF Certificate", String.class),

    // SET
    EMPLOYEE_IS_SET_EXAM_QUALIFIED("employeeIsSetExamQualified_ERPUserProfile_Bool", "Employee SET Exam Qualified", Boolean.class),
    EMPLOYEE_SET_EXAM_CLEARED_MONTH("employeeSetExamClearedMonth_ERPUserProfile_Text", "Employee SET Exam Qualified Month", String.class),
    EMPLOYEE_SET_EXAM_CLEARED_YEAR("employeeSetExamClearedYear_ERPUserProfile_Int", "Employee SET Exam Qualified Year", Integer.class),
    EMPLOYEE_SET_QUALIFICATION_CERTIFICATE("employeeSetQualificationCertificate_ERPUserProfile_File", "Employee SET Certificate", String.class),

    // MPhil
    EMPLOYEE_IS_MPHIL_QUALIFIED("employeeIsMphilQualified_ERPUserProfile_Bool", "Employee MPhil Qualified", Boolean.class),
    EMPLOYEE_MPHIL_CLEARED_MONTH("employeeMphilClearedMonth_ERPUserProfile_Text", "Employee MPhil Qualified Month", String.class),
    EMPLOYEE_MPHIL_CLEARED_YEAR("employeeMphilClearedYear_ERPUserProfile_Int", "Employee MPhil Qualified Year", Integer.class),
    EMPLOYEE_MPHIL_QUALIFICATION_CERTIFICATE("employeeMphilQualificationCertificate_ERPUserProfile_File", "Employee MPhil Certificate", String.class),

    // PHD
    EMPLOYEE_PHD_STATUS("employeePhdStatus_ERPUserProfile_Text","Employee PHD Status", String.class),
    EMPLOYEE_PHD_ENROLLED_MONTH("employeePhdEnrolledMonth_ERPUserProfile_Text", "Employee PhD Enrolled Month", String.class),
    EMPLOYEE_PHD_ENROLLED_YEAR("employeePhdEnrolledYear_ERPUserProfile_Int", "Employee PhD Enrolled Year", Integer.class),
    EMPLOYEE_PHD_ENROLLMENT_CERTIFICATE("employeePhdEnrollmentCertificate_ERPUserProfile_File", "Employee PhD Enrollment Certificate", String.class),

    EMPLOYEE_PHD_COMPLETED_MONTH("employeePhdCompletedMonth_ERPUserProfile_Text", "Employee PhD Completed Month", String.class),
    EMPLOYEE_PHD_COMPLETED_YEAR("employeePhdCompletedYear_ERPUserProfile_Int", "Employee PhD Completed Year", Integer.class),
    EMPLOYEE_PHD_COMPLETION_CERTIFICATE("employeePhdCompletionCertificate_ERPUserProfile_File", "Employee PhD Completion Certificate", String.class),

    // post doc
    EMPLOYEE_POST_DOCTORATE_STATUS("employeePostDoctorateStatus_ERPUserProfile_Bool", "Employee Post Doctorate Status", Boolean.class),
    EMPLOYEE_POST_DOCTORATE_ENROLLED_MONTH("employeePostDoctorateEnrolledMonth_ERPUserProfile_Text", "Employee Post Doctorate Enrolled Month", String.class),
    EMPLOYEE_POST_DOCTORATE_ENROLLED_YEAR("employeePostDoctorateEnrolledYear_ERPUserProfile_Int", "Employee Post Doctorate Enrolled Year", Integer.class),
    EMPLOYEE_POST_DOCTORATE_ENROLLMENT_CERTIFICATE("employeePostDoctorateEnrollmentCertificate_ERPUserProfile_File", "Employee Post Doctorate Enrollment Certificate", String.class),

    EMPLOYEE_POST_DOCTORATE_COMPLETED_MONTH("employeePostDoctorateCompletedMonth_ERPUserProfile_Text", "Employee Post Doctorate Completed Month", String.class),
    EMPLOYEE_POST_DOCTORATE_COMPLETED_YEAR("employeePostDoctorateCompletedYear_ERPUserProfile_Int", "Employee Post Doctorate Completed Year", Integer.class),
    EMPLOYEE_POST_DOCTORATE_COMPLETION_CERTIFICATE("employeePostDoctorateCompletionCertificate_ERPUserProfile_File", "Employee Post Doctorate Completion Certificate", String.class),

    // Experience
    // Teaching
    EMPLOYEE_HAS_TEACHING_EXPERIENCE("employeeHasTeachingExperience_ERPUserProfile_Bool","Employee Has Teaching experience", Boolean.class),
    EMPLOYEE_TEACHING_JOINING_DATE("employeeTeachingJoiningDate_ERPUserProfile_Date", "Employee Joining Date in Teaching", Long.class),
    EMPLOYEE_TEACHING_EXPERIENCE_JOB_PROFILE("employeeTeachingExperienceJobProfile_ERPUserProfile_Text", "Employee Teaching Experience Job Profile", String.class),
    EMPLOYEE_TEACHING_EXPERIENCE_INSTITUTION_NAME("employeeTeachingExperienceInstitutionName_ERPUserProfile_Text", "Employee Teaching Experience Institution Name", String.class),
    EMPLOYEE_TEACHING_EXPERIENCE_FROM_DATE("employeeTeachingExperienceFromDate_ERPUserProfile_Date", "Employee Teaching Experience From Date", Long.class),
    EMPLOYEE_TEACHING_EXPERIENCE_TO_DATE("employeeTeachingExperienceToDate_ERPUserProfile_Date", "Employee Teaching Experience To Date", Long.class),


    // Industry experience
    EMPLOYEE_HAS_INDUSTRY_EXPERIENCE("employeeHasIndustryExperience_ERPUserProfile_Bool","Employee Has Industry experience", Boolean.class),
    EMPLOYEE_INDUSTRY_EXPERIENCE_JOB_PROFILE("employeeIndustryExperienceJobProfile_ERPUserProfile_Text", "Employee Industry Experience Job Profile", String.class),
    EMPLOYEE_INDUSTRY_EXPERIENCE_COMPANY_NAME("employeeIndustryExperienceCompanyName_ERPUserProfile_Text", "Employee Industry Experience Company Name", String.class),
    EMPLOYEE_INDUSTRY_EXPERIENCE_FROM_DATE("employeeIndustryExperienceFromDate_ERPUserProfile_Date", "Employee Industry Experience From Date", Long.class),
    EMPLOYEE_INDUSTRY_EXPERIENCE_TO_DATE("employeeIndustryExperienceToDate_ERPUserProfile_Date", "Employee Industry Experience To Date", Long.class),

    // Research Experience
    EMPLOYEE_HAS_RESEARCH_EXPERIENCE("employeeHasResearchExperience_ERPUserProfile_Bool", "Employee Has Research Experience", Boolean.class),
    EMPLOYEE_RESEARCH_EXPERIENCE_PROFILE("employeeResearchExperienceProfile_ERPUserProfile_Text", "Employee Research Experience Profile", String.class),
    EMPLOYEE_RESEARCH_EXPERIENCE_INSTITUTION_NAME("employeeResearchExperienceInstitutionName_ERPUserProfile_Text", "Employee Research Experience Institution Name", String.class),
    EMPLOYEE_RESEARCH_EXPERIENCE_FROM_DATE("employeeResearchExperienceFromDate_ERPUserProfile_Date", "Employee Research Experience From Date", Long.class),
    EMPLOYEE_RESEARCH_EXPERIENCE_TO_DATE("employeeResearchExperienceToDate_ERPUserProfile_Date", "Employee Research Experience To Date", Long.class),

    // PHD experience
    EMPLOYEE_HAS_FULL_TIME_PHD("employeeHasFullTimePhd_ERPUserProfile_Bool","Employee Has Research experience", Boolean.class),
    EMPLOYEE_FULL_TIME_PHD_INSTITUTION_NAME("employeeFullTimePhdInstitutionName_ERPUserProfile_Text", "Employee Full-Time PhD Institution Name", String.class),
    EMPLOYEE_FULL_TIME_PHD_FROM_DATE("employeeFullTimePhdFromDate_ERPUserProfile_Date", "Employee Full-Time PhD From Date", Long.class),
    EMPLOYEE_FULL_TIME_PHD_TO_DATE("employeeFullTimePhdToDate_ERPUserProfile_Date", "Employee Full-Time PhD To Date", Long.class),

    ;

    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private ERPUserProfileKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength= maxLength;
    }

    private ERPUserProfileKeysPBinder(String property, String label, Class<?> dataType) {
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

    public Class<?> getDataType() {
        return this.dataType;
    }

    public Integer getMinLength() {
        return this.minLength;
    }

    public Integer getMaxLength() {
        return this.maxLength;
    }

    // $FF: synthetic method
    private static ERPUserProfileKeysPBinder[] $values() {
        return ERPUserProfileKeysPBinder.class.getEnumConstants();
    }
}
