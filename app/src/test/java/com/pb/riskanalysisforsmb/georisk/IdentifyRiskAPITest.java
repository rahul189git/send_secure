package com.pb.riskanalysisforsmb.georisk;


import com.pb.riskanalysisforsmb.beans.AddressVO;
import com.pb.riskanalysisforsmb.georisk.api.FraudRiskAPI;
import com.pb.riskanalysisforsmb.identity.input.IdentifyRiskInputBody;

import org.junit.Test;

public class IdentifyRiskAPITest {

    @Test
    public void checkWeatherAPIforDate() throws Exception {
       AddressVO address = new AddressVO("92 Blackbird Center", "199 Stoughton Trail", "86 Grim Parkway", "", "", "", "33141", "");
        IdentifyRiskInputBody response =  FraudRiskAPI.getIdentifyRiskInputBody(address);
    }


}