package com.pb.riskanalysisforsmb.georisk.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pb.riskanalysisforsmb.APIConstants;
import com.pb.riskanalysisforsmb.RestRequest;
import com.pb.riskanalysisforsmb.beans.AddressVO;
import com.pb.riskanalysisforsmb.identity.IdentifyRiskResponse;
import com.pb.riskanalysisforsmb.identity.input.IdentifyRiskInputBody;
import com.pb.riskanalysisforsmb.identity.input.Input;
import com.pb.riskanalysisforsmb.identity.input.Row;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FraudRiskAPI {

    public static void main(String[] args) {
        IdentifyRiskResponse response = getFraudRiskResponse(null);
        System.out.println(response);

    }

    //6087 Cordelia Plaza,84 Bunker Hill Avenue,08 Eliot Court,Longview,Texas,United States,75605
    public static IdentifyRiskInputBody getIdentifyRiskInputBody(AddressVO addressVO) {

        String name = addressVO.getName();
        String addressLine1 = addressVO.getAddress1();
        String addressLine2 = addressVO.getAddress2();
        String addressLine3 = addressVO.getAddress3() + ',' + addressVO.getCity() + ',' +addressVO.getState();

        String country = addressVO.getCountry();
        String idNumber = "";
        String placeOfBirth = "";
        String dob = "";
        String citizenship = "";
        String nationality = "";
        Row row = new Row(name, "", "", addressLine1, addressLine2, addressLine3, country, idNumber, placeOfBirth, dob, citizenship, nationality);
        List<Row> rows = new ArrayList<>();
        rows.add(row);
        Input input = new Input(rows);
        IdentifyRiskInputBody identifyRiskInputBody = new IdentifyRiskInputBody();
        identifyRiskInputBody.withInput(input);

        return identifyRiskInputBody;
    }

    private static IdentifyRiskResponse getFraudRiskResponse(AddressVO addressVO) {
        String url = APIConstants.FRAUDRISK_API;
        ObjectMapper mapper = new ObjectMapper();
        IdentifyRiskInputBody identifyRiskInputBody = getIdentifyRiskInputBody(addressVO);
        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(identifyRiskInputBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String jsonResponse = RestRequest.executePostRequest(url, TokenProviderAPI.getBearerAuthToken(), jsonInString, "application/json");

        IdentifyRiskResponse responseObject = null;
        try {
            responseObject = mapper.readValue(jsonResponse, IdentifyRiskResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseObject;
    }
}
