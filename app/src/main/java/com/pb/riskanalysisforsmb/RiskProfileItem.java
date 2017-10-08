package com.pb.riskanalysisforsmb;

public class RiskProfileItem {
    private String address;
    private String riskDetails;
    private boolean checked;

    public RiskProfileItem(String address, String riskDetails) {
        this.address = address;
        this.riskDetails = riskDetails;
    }


    public String getRiskDetails() {
        return riskDetails;
    }

    public void setRiskDetails(String riskDetails) {
        this.riskDetails = riskDetails;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return riskDetails;
    }
}
