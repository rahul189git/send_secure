package com.pb.riskanalysisforsmb.risk.type;

import com.pb.riskanalysisforsmb.beans.AddressVO;

import java.text.NumberFormat;

public class CrimeRisk {

    private String address;
    private AddressVO addressVO;
    private final String riskScore;
    private final String riskSeverity;

    public CrimeRisk(String address, String riskScore, String riskSeverity) {
        this.address = address;
        this.riskScore = riskScore;
        this.riskSeverity = riskSeverity;
    }

    public CrimeRisk(AddressVO address, String riskScore, String riskSeverity) {
        this.addressVO = address;
        this.address = address.getName() + ',' + address.getAddress();
        this.riskScore = riskScore;
        this.riskSeverity = riskSeverity;
    }

    public String getRiskScore() {
        return riskScore == null ? null : String.valueOf(Float.valueOf(riskScore).intValue());
    }

    public String getRiskSeverity() {
        return riskSeverity;
    }

    public String getAddress() {
        return address;
    }

    public AddressVO getAddressVO() {

        return addressVO;
    }
}
