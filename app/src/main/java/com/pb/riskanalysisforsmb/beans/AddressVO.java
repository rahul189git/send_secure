package com.pb.riskanalysisforsmb.beans;

public class AddressVO {
    private final String name;
    private final String address1;
    private final String address2;
    private final String address3;
    private final String city;
    private final String state;
    private final String country;
    private final String zipCode;

    public AddressVO(String name, String address1, String address2, String address3, String city, String state, String country, String zipCode) {
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;

    }

    //6087 Cordelia Plaza,84 Bunker Hill Avenue,08 Eliot Court,Longview,Texas,United States,75605
    public AddressVO(String name, String completeAddress) {
        this.name = name;

        String[] splitAddresses = completeAddress.split(",");

        this.address1 = splitAddresses[0];
        this.address2 = splitAddresses[1];
        this.address3 = splitAddresses[2];
        this.city = splitAddresses[3];
        this.state = splitAddresses[4];
        this.country = splitAddresses[5];
        this.zipCode = splitAddresses[6];

    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddress3() {
        return address3;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address1 + "," + address2 + "," + address3 + "," + city + ',' + state + ',' + country + "," + zipCode;
    }


}
