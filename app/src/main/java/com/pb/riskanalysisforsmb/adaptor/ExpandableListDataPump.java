package com.pb.riskanalysisforsmb.adaptor;

import android.os.Parcelable;

import com.pb.riskanalysisforsmb.AddressWithRisk;
import com.pb.riskanalysisforsmb.RiskProfileItem;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static LinkedHashMap<RiskProfileItem, List<RiskProfileItem>> getData(ArrayList<AddressWithRisk> addressWithRisks) {
        LinkedHashMap<RiskProfileItem, List<RiskProfileItem>> expandableListDetail = new LinkedHashMap<>();

        List<RiskProfileItem> high = new ArrayList<>();
        List<RiskProfileItem> moderate = new ArrayList<>();
        List<RiskProfileItem> low = new ArrayList<>();
        List<RiskProfileItem> weather = new ArrayList<>();

        int count = addressWithRisks.size();

        for (AddressWithRisk addressWithRisk : addressWithRisks) {
            if (addressWithRisk.getAddress() != null) {
                if ("High".equalsIgnoreCase(addressWithRisk.getCrimeRiskSeverity())) {
                    high.add(new RiskProfileItem(addressWithRisk.getAddress(), "High risk with score " + addressWithRisk.getCrimeRiskScore()));
                } else if ("Moderate".equalsIgnoreCase(addressWithRisk.getCrimeRiskSeverity())) {
                    high.add(new RiskProfileItem(addressWithRisk.getAddress(), "Moderate risk with score " + addressWithRisk.getCrimeRiskScore()));
                } else if ("Low".equalsIgnoreCase(addressWithRisk.getCrimeRiskSeverity())) {
                    high.add(new RiskProfileItem(addressWithRisk.getAddress(), "Low risk with score " + addressWithRisk.getCrimeRiskScore()));
                }

                if (addressWithRisk.getWeatherRiskDescription() != null) {
                    weather.add(new RiskProfileItem(addressWithRisk.getAddress(), addressWithRisk.getWeatherRiskDescription()));
                }
            }
        }

        if (high.size() > 0) {
            expandableListDetail.put(new RiskProfileItem("High Crime (" + high.size() + " out of " + count + " selected, " + Math.round(((float)high.size()/count)*100) + "%)", ""), high);
        }

        if (moderate.size() > 0) {
            expandableListDetail.put(new RiskProfileItem("Moderate Crime (" + moderate.size() + " out of " + count + " selected, " + Math.round(((float)moderate.size()/count)*100) + "%)", ""), moderate);
        }

        if (low.size() > 0) {
            expandableListDetail.put(new RiskProfileItem("Low Crime (" + low.size() + " out of " + count + " selected, " + Math.round(((float)low.size()/count)*100) + "%)", ""), low);
        }

        if (weather.size() > 0) {
            expandableListDetail.put(new RiskProfileItem("Weather Risk(" + weather.size() + " out of " + count + " selected, " + Math.round(((float)weather.size()/count)*100) + "%)", ""), weather);
        }

        return expandableListDetail;
    }


}

