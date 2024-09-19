package in.edu.kristujayanti.util;

import in.edu.kristujayanti.enums.ResponseCode;
import in.edu.kristujayanti.enums.ResponseType;
import in.edu.kristujayanti.enums.StatusCode;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import software.amazon.awssdk.services.ses.endpoints.internal.Value;

public final class ResponseUtil {
    private ResponseUtil() {
    }

    public static void createResponse(HttpServerResponse httpServerResponse, ResponseType responseType, StatusCode statusCode, JsonArray data, JsonArray message) {
        JsonObject response = new JsonObject();
        response.put(ResponseCode.STATUS_CODE.getProperty(), statusCode.getStatusCode());
        response.put(ResponseCode.TYPE.getProperty(), responseType);
        JsonObject responseDataJsonObject = new JsonObject();
        responseDataJsonObject.put(ResponseCode.DATA.getProperty(), data);
        responseDataJsonObject.put(ResponseCode.MESSAGE.getProperty(), message);
        response.put(ResponseCode.RESPONSE_DATA.getProperty(), responseDataJsonObject);
        httpServerResponse
                .putHeader("content-type", "application/json")
                .end(response.encodePrettily());
    }


    public static void createResponse(HttpServerResponse httpServerResponse, ResponseType responseType, Integer statusCode, JsonArray data, JsonArray message) {
        JsonObject response = new JsonObject();
        response.put(ResponseCode.STATUS_CODE.getProperty(), StatusCode.validateStatusCode(statusCode));
        response.put(ResponseCode.TYPE.getProperty(), responseType);
        JsonObject responseDataJsonObject = new JsonObject();
        responseDataJsonObject.put(ResponseCode.DATA.getProperty(), data);
        responseDataJsonObject.put(ResponseCode.MESSAGE.getProperty(), message);
        response.put(ResponseCode.RESPONSE_DATA.getProperty(), responseDataJsonObject);
        httpServerResponse
                .putHeader("content-type", "application/json")
                .end(response.encodePrettily());
    }
}