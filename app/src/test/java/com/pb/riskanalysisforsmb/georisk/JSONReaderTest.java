package com.pb.riskanalysisforsmb.georisk;

import com.pb.riskanalysisforsmb.JSONReader;
import com.pb.riskanalysisforsmb.georisk.json.crime.IndexVariable;

import org.junit.Assert;
import org.junit.Test;

public class JSONReaderTest {

    private static final String crimeJson = "{" +
            "    \"themes\": [" +
            "        {" +
            "            \"crimeIndexTheme\": {" +
            "                \"source\": \"default\"," +
            "                \"boundaryRef\": \"b1\"," +
            "                \"indexVariable\": [" +
            "                    {" +
            "                        \"name\": \"overall\"," +
            "                        \"score\": \"97.0\"," +
            "                        \"category\": \"Above Average\"," +
            "                        \"percentile\": \"50 to 75\"" +
            "                    }," +
            "                    {" +
            "                        \"name\": \"violent\"," +
            "                        \"score\": \"128.0\"," +
            "                        \"category\": \"Above Average\"," +
            "                        \"percentile\": \"50 to 75\"" +
            "                    }," +
            "                    {" +
            "                        \"name\": \"murder\"," +
            "                        \"score\": \"103.0\"," +
            "                        \"category\": \"Above Average\"," +
            "                        \"percentile\": \"50 to 75\"" +
            "                    }," +
            "                    {" +
            "                        \"name\": \"rape\"," +
            "                        \"score\": \"95.0\"," +
            "                        \"category\": \"Above Average\"," +
            "                        \"percentile\": \"50 to 75\"" +
            "                    }," +
            "                    {" +
            "                        \"name\": \"robbery\"," +
            "                        \"score\": \"130.0\"," +
            "                        \"category\": \"Above Average\"," +
            "                        \"percentile\": \"50 to 75\"" +
            "                    }," +
            "                    {" +
            "                        \"name\": \"assault\"," +
            "                        \"score\": \"130.0\"," +
            "                        \"category\": \"Above Average\"," +
            "                        \"percentile\": \"50 to 75\"" +
            "                    }," +
            "                    {" +
            "                        \"name\": \"property\"," +
            "                        \"score\": \"109.0\"," +
            "                        \"category\": \"Above Average\"," +
            "                        \"percentile\": \"50 to 75\"" +
            "                    }," +
            "                    {" +
            "                        \"name\": \"burglary\"," +
            "                        \"score\": \"108.0\"," +
            "                        \"category\": \"Above Average\"," +
            "                        \"percentile\": \"50 to 75\"" +
            "                    }," +
            "                    {" +
            "                        \"name\": \"larceny\"," +
            "                        \"score\": \"111.0\"," +
            "                        \"category\": \"Above Average\"," +
            "                        \"percentile\": \"50 to 75\"" +
            "                    }," +
            "                    {" +
            "                        \"name\": \"motorvehicletheft\"," +
            "                        \"score\": \"70.0\"," +
            "                        \"category\": \"Below Average\"," +
            "                        \"percentile\": \"25 to 50\"" +
            "                    }," +
            "                    {" +
            "                        \"name\": \"arson\"," +
            "                        \"score\": \"62.0\"," +
            "                        \"category\": \"Below Average\"," +
            "                        \"percentile\": \"25 to 50\"" +
            "                    }" +
            "                ]" +
            "            }" +
            "        }" +
            "    ]," +
            "    \"boundaries\": {" +
            "        \"boundary\": [" +
            "            {" +
            "                \"id\": \"120810020111\"," +
            "                \"type\": \"USA_BLOCKGROUP\"," +
            "                \"ref\": \"b1\"" +
            "            }" +
            "        ]" +
            "    }," +
            "    \"matchedAddress\": {" +
            "        \"formattedAddress\": \"4843 9TH AVE E, BRADENTON, FL  34208-5807\"," +
            "        \"mainAddressLine\": \"4843 9TH AVE E\"," +
            "        \"addressLastLine\": \"BRADENTON, FL  34208-5807\"," +
            "        \"placeName\": \"\"," +
            "        \"areaName1\": \"FL\"," +
            "        \"areaName2\": \"MANATEE COUNTY\"," +
            "        \"areaName3\": \"BRADENTON\"," +
            "        \"areaName4\": \"\"," +
            "        \"postCode\": \"34208\"," +
            "        \"postCodeExt\": \"5807\"," +
            "        \"country\": \"USA\"," +
            "        \"addressNumber\": \"4843\"," +
            "        \"streetName\": \"9TH\"," +
            "        \"unitType\": \"\"," +
            "        \"unitValue\": \"\"" +
            "    }" +
            "}";


    private static final String floodJson = "{\n" +
            "    \"state\": {\n" +
            "        \"fips\": \"40\",\n" +
            "        \"code\": \"OK\"\n" +
            "    },\n" +
            "    \"floodZone\": {\n" +
            "        \"code\": \"X\",\n" +
            "        \"areaType\": \"Moderate to Minimal Risk Area\",\n" +
            "        \"riskLevel\": \"Moderate to Minimal\",\n" +
            "        \"primaryZone\": {\n" +
            "            \"code\": \"X\",\n" +
            "            \"description\": \"X(shaded) is the moderate risk area within the 0.2% annual chance flood plain while X (unshaded) is an area outside the 1% and 0.2% annual chance flood plains. BFEs have not been determined.\"\n" +
            "        },\n" +
            "        \"baseFloodElevation\": {\n" +
            "            \"unit\": \"feet\",\n" +
            "            \"value\": \"\"\n" +
            "        },\n" +
            "        \"additionalInfo\": \"\"\n" +
            "    },\n" +
            "    \"community\": {\n" +
            "        \"number\": \"400460\",\n" +
            "        \"status\": {\n" +
            "            \"code\": \"R\",\n" +
            "            \"description\": \"Regular\"\n" +
            "        }\n" +
            "    },\n" +
            "    \"boundary\": {\n" +
            "        \"id\": \"3609398\"\n" +
            "    },\n" +
            "    \"matchedAddress\": {\n" +
            "        \"formattedAddress\": \"121 W MAIN ST, DURANT, OK  74701-5007\",\n" +
            "        \"mainAddressLine\": \"121 W MAIN ST\",\n" +
            "        \"addressLastLine\": \"DURANT, OK  74701-5007\",\n" +
            "        \"placeName\": \"\",\n" +
            "        \"areaName1\": \"OK\",\n" +
            "        \"areaName2\": \"BRYAN COUNTY\",\n" +
            "        \"areaName3\": \"DURANT\",\n" +
            "        \"areaName4\": \"\",\n" +
            "        \"postCode\": \"74701\",\n" +
            "        \"postCodeExt\": \"5007\",\n" +
            "        \"country\": \"USA\",\n" +
            "        \"addressNumber\": \"121\",\n" +
            "        \"streetName\": \"MAIN\",\n" +
            "        \"unitType\": \"\",\n" +
            "        \"unitValue\": \"\"\n" +
            "    }}";

    @Test
    public void findRisk() throws Exception {
        IndexVariable[] indexVariables = JSONReader.parseCrimeJson(crimeJson);
        String overall = "";
        for (IndexVariable indexVariable : indexVariables) {
            if ("overall".equalsIgnoreCase(indexVariable.getName())) {
                String category = indexVariable.getCategory();
                overall = indexVariable.getScore();
            }
        }
        Assert.assertEquals(overall, "97");
    }

}