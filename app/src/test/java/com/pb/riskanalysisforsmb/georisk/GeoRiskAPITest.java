package com.pb.riskanalysisforsmb.georisk;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RA016KU on 9/28/2017.
 */
public class GeoRiskAPITest {
    @Test
    public void getUserInput() throws Exception {

    }

    @Test
    public void getRiskCriteriaTest() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("Murder", "Moderate");
        map.put("Burglary", "High");
        map.put("Robbery", "Low");
        map.put("Overall", "Moderate");
        //Map<RiskName, RiskCategory> riskCriteria = GeoRiskAPI.getRiskCriteria(map);

    }

    @Test
    public void testVerifyAddressByCrime() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("Murder", "Moderate");
        map.put("Burglary", "High");
        map.put("Robbery", "Low");
        map.put("Overall", "Moderate");
       // Map<RiskName, RiskCategory> riskCriteria = GeoRiskAPI.getRiskCriteria(map);
        String address = "15590 Bent Creek Rd,Wellington,null,33414,FL";
       // boolean isVerified = GeoRiskAPI.getCrimeResponseJson(address, riskCriteria);

    }


}