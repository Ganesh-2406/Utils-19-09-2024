package in.edu.kristujayanti.propertyBinder;

import in.edu.kristujayanti.propertyBinder.Eform.Applicant.ApplicantFormsKeysPBinder;
import in.edu.kristujayanti.propertyBinder.Eform.EformCommonKeysPBinder;
import in.edu.kristujayanti.propertyBinder.Library.LibraryCheckInAndOutKeysPBinder;
import in.edu.kristujayanti.propertyBinder.Library.LibraryBookKeysPBInder;
import in.edu.kristujayanti.propertyBinder.Library.LibraryCommonKeysPBinder;
import in.edu.kristujayanti.propertyBinder.RazorpayPayment.RazorpayKeysPBinder;
import in.edu.kristujayanti.propertyBinder.core.ERPUserProfileKeysPBinder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class PropertyEnumRegistry {
    private static final Map<String, Class> KJUSYS_ENUM_REGISTRY = new ConcurrentHashMap();

    public static Class getEnumClass(String key) {
        if (KJUSYS_ENUM_REGISTRY.containsKey(key)) {
            return KJUSYS_ENUM_REGISTRY.get(key);
        } else {
            throw new IllegalStateException("Registry key " + key + " is invalid");
        }
    }

    static {
        KJUSYS_ENUM_REGISTRY.put("EformCommon", EformCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("AuthCommon" , AuthCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("ApplicantForms", ApplicantFormsKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("KJUSYSCommon", KJUSYSCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("ERPUserProfile", ERPUserProfileKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("RazorpayKeys", RazorpayKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("LibraryCheckInAndOut", LibraryCheckInAndOutKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("LibraryCommon", LibraryCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("LibraryBook", LibraryBookKeysPBInder.class);
        //KJUSYS_ENUM_REGISTRY.put("AuthCommon", LibraryCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("ERPStaffUserProfile", LibraryCommonKeysPBinder.class);
        KJUSYS_ENUM_REGISTRY.put("ERPStudentUserProfile", LibraryCommonKeysPBinder.class);
    }
}