package in.edu.kristujayanti.util;

import com.auth0.jwt.JWT;
import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpHeaders;

import static in.edu.kristujayanti.propertyBinder.KJUSYSCommonKeysPBinder.JWT_USER_GROUP_CLAIM;
import static in.edu.kristujayanti.propertyBinder.KJUSYSCommonKeysPBinder.JWT_USER_ID_CLAIM;

public class UserInfoUtil {

    // Private constructor to prevent instantiation
    private UserInfoUtil() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }

    /**
     * Retrieves the logged-in user's information from the authorization header.
     *
     * @param headers the HTTP headers containing the authorization token
     * @return the user ID extracted from the JWT token, or an empty string if not found
     */
    public static String getLoggedInUserInfo(MultiMap headers) {
        // Check if the Authorization header is present
        if (headers.get(HttpHeaders.AUTHORIZATION) != null) {
            // Extract the access token by removing the "Bearer " prefix
            String accessToken = headers.get(HttpHeaders.AUTHORIZATION).replaceFirst("^Bearer ", "");
            // Decode the JWT token and extract the user ID claim
            return JWT.decode(accessToken).getClaim(JWT_USER_ID_CLAIM.getPropertyName()).asString();
        }
        // Return an empty string if the Authorization header is not present
        return null;
    }

    public static String getLoggedInUserGroup(MultiMap headers) {
        // Check if the Authorization header is present
        if (headers.get(HttpHeaders.AUTHORIZATION) != null) {
            // Extract the access token by removing the "Bearer " prefix
            String accessToken = headers.get(HttpHeaders.AUTHORIZATION).replaceFirst("^Bearer ", "");
            // Decode the JWT token and extract the user ID claim
            return JWT.decode(accessToken).getClaim(JWT_USER_GROUP_CLAIM.getPropertyName()).asString();
        }
        // Return an empty string if the Authorization header is not present
        return null;
    }


}
