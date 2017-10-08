package com.pb.riskanalysisforsmb.georisk.api;

import android.util.Log;

import com.pb.riskanalysisforsmb.APIConstants;
import com.pb.riskanalysisforsmb.JSONReader;
import com.pb.riskanalysisforsmb.RestRequest;
import com.pb.riskanalysisforsmb.beans.AddressVO;
import com.pb.riskanalysisforsmb.georisk.json.crime.IndexVariable;
import com.pb.riskanalysisforsmb.risk.type.CrimeRisk;

import java.io.IOException;
import java.net.URLEncoder;


public class GeoRiskAPI {
    private static final String TAG = "GeoRiskAPI";


    public static String fireRestQueryForCrime(String address) {

        String jsonResponse = "";
        try {
            String encodedAddress = URLEncoder.encode(address, "UTF-8");
            String addressURI = "address=" + encodedAddress;
            String url = APIConstants.CRIME_RISK_REST_URL + addressURI + "&type=all&includeGeometry=N";

            String bearerAuthToken = TokenProviderAPI.getBearerAuthToken();
            jsonResponse = RestRequest.executeGetRequest(url, bearerAuthToken);
        } catch (IOException e) {
            Log.e(TAG, "Exception occurred :" + Log.getStackTraceString(e));
        }

        return jsonResponse;
    }

    public static String getFloodRiskResponse(String address) {
        try {
            String encodedAddress = URLEncoder.encode(address, "UTF-8");
            String addressURI = "address=" + encodedAddress;
            String url = APIConstants.FLLOD_RISK_REST_URL + addressURI + "&type=all&includeGeometry=N";
            return RestRequest.executeGetRequest(url, TokenProviderAPI.getBearerAuthToken());
        } catch (IOException e) {
            Log.e(TAG, "Exception occurred :" + Log.getStackTraceString(e));
        }
        return "";
    }

    public static CrimeRisk getAddressWithCrimeRisk(AddressVO address) {
        String jsonResponse = GeoRiskAPI.fireRestQueryForCrime(address.getAddress());

        IndexVariable[] indexVariables = JSONReader.parseCrimeJson(jsonResponse);

        if (indexVariables == null) {
            return null;
        }

        for (IndexVariable indexVariable : indexVariables) {
            if ("overall".equalsIgnoreCase(indexVariable.getName())) {
                String category = indexVariable.getCategory();

                return new CrimeRisk(address, indexVariable.getScore(), GeoRiskAPI.convertRiskIntensity(category));

            }
        }
        return null;

    }




    public static CrimeRisk getAddressWithCrimeRisk(String address) {
        String jsonResponse = GeoRiskAPI.fireRestQueryForCrime(address);

        IndexVariable[] indexVariables = JSONReader.parseCrimeJson(jsonResponse);


        for (IndexVariable indexVariable : indexVariables) {
            if ("overall".equalsIgnoreCase(indexVariable.getName())) {
                String category = indexVariable.getCategory();

                return new CrimeRisk(address, indexVariable.getScore(), GeoRiskAPI.convertRiskIntensity(category));

            }
        }
        return null;

    }

    public static String convertRiskIntensity(String category) {

        if ("Low".equalsIgnoreCase(category) || "Lowest".equalsIgnoreCase(category)) {
            return "Lowest";
        }
        if ("Below Average".equalsIgnoreCase(category)
                || "Above Average".equalsIgnoreCase(category)) {
            return "Moderate";
        }
        if ("High".equalsIgnoreCase(category)
                || "Highest".equalsIgnoreCase(category)) {
            return "High";
        }

        return category;

    }


}
