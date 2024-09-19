package in.edu.kristujayanti.util;


import java.util.HashMap;
import java.util.Map;

public class UppercasePolicyManager {

    public enum UppercasePolicy {
        UPPERCASE,
        PRESERVE_CASE
    }

    private static final Map<String, UppercasePolicy> policyMap = new HashMap<>();

    static {
        // Initialize the map with default policies
        policyMap.put("applicantPassword", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("applicantOldPassword", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("password", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("oldPassword", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("newPassword", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("confirmPassword", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("userPassword", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("uploadedFilePath", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programmePreference2", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programmePreference3", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programName", UppercasePolicy.PRESERVE_CASE);
        policyMap.put("programDisplayName", UppercasePolicy.PRESERVE_CASE);
    }

    /**
     * Get the uppercase policy for a given property name.
     *
     * @param propertyName The name of the property to check.
     * @return The UppercasePolicy for the given property. If no specific policy is set, returns UPPERCASE.
     */
    public static UppercasePolicy getPolicy(String propertyName) {
        return policyMap.getOrDefault(propertyName, UppercasePolicy.UPPERCASE);
    }

    /**
     * Set a specific uppercase policy for a property.
     *
     * @param propertyName The name of the property.
     * @param policy The UppercasePolicy to set for this property.
     */
    public static void setPolicy(String propertyName, UppercasePolicy policy) {
        policyMap.put(propertyName, policy);
    }

    /**
     * Remove the specific policy for a property, reverting it to the default (UPPERCASE).
     *
     * @param propertyName The name of the property to remove the specific policy for.
     */
    public static void removePolicy(String propertyName) {
        policyMap.remove(propertyName);
    }

    /**
     * Clear all specific policies, reverting all properties to the default (UPPERCASE).
     */
    public static void clearAllPolicies() {
        policyMap.clear();
    }
}