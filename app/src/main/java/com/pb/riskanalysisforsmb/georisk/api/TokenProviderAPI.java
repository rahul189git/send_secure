package com.pb.riskanalysisforsmb.georisk.api;

import android.util.Log;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pb.riskanalysisforsmb.APIConstants;
import com.pb.riskanalysisforsmb.RestRequest;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public final class TokenProviderAPI {
    private static final String TAG = "TokenProviderAPI";
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static String AUTH_TOKEN;

    public static String getBearerAuthToken() {
        if (AUTH_TOKEN != null) {
            return AUTH_TOKEN;
        }

        String tokenUrlBody = "grant_type=client_credentials";

        try {
            String content = RestRequest.executePostRequest(APIConstants.TOKEN_URL, getBasicAuthToken(), tokenUrlBody, "application/x-www-form-urlencoded");
            JsonNode jsonNode = OBJECT_MAPPER.readTree(content);
            String access_token = jsonNode.get("access_token").asText();
            AUTH_TOKEN = "Bearer " + access_token;

            return AUTH_TOKEN;
        } catch (IllegalStateException | IOException e) {
            Log.i(TAG, "Exception in getBearerAuthToken " + e);
            throw new RuntimeException(e);
        }
    }

    private static String getBasicAuthToken() {
        String authString = APIConstants.API_KEY + ':' + APIConstants.SECRET;
        byte[] byteArray = Base64.encodeBase64(authString.getBytes());
        String basicToken = "";
        try {
            basicToken = new String(byteArray, "ASCII");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "Basic " + basicToken;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String basicAuthToken = getBasicAuthToken();
        System.out.println("Basic 64 endoded token  " + basicAuthToken);
        System.out.println("bearer token  " + getBearerAuthToken());

        String address = "62 San Jose usa";

        String encodedAddress = URLEncoder.encode(address, "UTF-8");
        String addressURI = "address=" + encodedAddress;

        String url = APIConstants.CRIME_RISK_REST_URL + addressURI + "&type=all&includeGeometry=N";

        String bearerAuthToken = getBearerAuthToken();
        String jsonResponse = RestRequest.executeGetRequest(url, bearerAuthToken);
        System.out.println("Response " + jsonResponse);

    }
}
