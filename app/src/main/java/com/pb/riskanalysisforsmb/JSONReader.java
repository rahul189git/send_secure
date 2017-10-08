package com.pb.riskanalysisforsmb;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pb.riskanalysisforsmb.georisk.json.crime.CrimeIndexTheme;
import com.pb.riskanalysisforsmb.georisk.json.crime.IndexVariable;
import com.pb.riskanalysisforsmb.georisk.json.crime.JSONResponseObject;
import com.pb.riskanalysisforsmb.georisk.json.crime.Themes;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public final class JSONReader {
    private static final String TAG = "JSONReader";


    public static IndexVariable[] parseCrimeJson(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }

        Map<String, Double> crimeScoreMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JSONResponseObject responseObject = mapper.readValue(jsonStr, JSONResponseObject.class);
            Themes[] themes = responseObject.getThemes();

            if (themes == null || themes.length == 0) {
                return null;
            }

            CrimeIndexTheme crimeIndexTheme = themes[0].getCrimeIndexTheme();

            return crimeIndexTheme.getIndexVariable();

           /* for (IndexVariable indexVariable : indexVariables) {
                crimeScoreMap.put(indexVariable.getAddress(), Double.parseDouble(indexVariable.getScore()));
            }*/


        } catch (IOException e) {
            Log.e(TAG, "Json parsing error: " + e.getMessage());
        }
        return null;
    }


}
