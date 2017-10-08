package com.pb.riskanalysisforsmb.georisk.json.crime;


public class MatchedAddress {
    private String unitType;

    private String areaName2;

    private String postCode;

    private String areaName3;

    private String streetName;

    private String placeName;

    private String areaName1;

    private String unitValue;

    private String areaName4;

    private String country;

    private String mainAddressLine;

    private String addressNumber;

    private String postCodeExt;

    private String addressLastLine;

    private String formattedAddress;

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getAreaName2() {
        return areaName2;
    }

    public void setAreaName2(String areaName2) {
        this.areaName2 = areaName2;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAreaName3() {
        return areaName3;
    }

    public void setAreaName3(String areaName3) {
        this.areaName3 = areaName3;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAreaName1() {
        return areaName1;
    }

    public void setAreaName1(String areaName1) {
        this.areaName1 = areaName1;
    }

    public String getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(String unitValue) {
        this.unitValue = unitValue;
    }

    public String getAreaName4() {
        return areaName4;
    }

    public void setAreaName4(String areaName4) {
        this.areaName4 = areaName4;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMainAddressLine() {
        return mainAddressLine;
    }

    public void setMainAddressLine(String mainAddressLine) {
        this.mainAddressLine = mainAddressLine;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getPostCodeExt() {
        return postCodeExt;
    }

    public void setPostCodeExt(String postCodeExt) {
        this.postCodeExt = postCodeExt;
    }

    public String getAddressLastLine() {
        return addressLastLine;
    }

    public void setAddressLastLine(String addressLastLine) {
        this.addressLastLine = addressLastLine;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    @Override
    public String toString() {
        return "MatchedAddress [unitType = " + unitType + ", areaName2 = " + areaName2 + ", postCode = " + postCode + ", areaName3 = " + areaName3 + ", streetName = " + streetName + ", placeName = " + placeName + ", areaName1 = " + areaName1 + ", unitValue = " + unitValue + ", areaName4 = " + areaName4 + ", country = " + country + ", mainAddressLine = " + mainAddressLine + ", addressNumber = " + addressNumber + ", postCodeExt = " + postCodeExt + ", addressLastLine = " + addressLastLine + ", formattedAddress = " + formattedAddress + "]";
    }
}