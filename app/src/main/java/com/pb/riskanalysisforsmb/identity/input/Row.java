package com.pb.riskanalysisforsmb.identity.input;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "FirstName",
        "LastName",
        "AddressLine1",
        "AddressLine2",
        "AddressLine3",
        "Country",
        "IDNumber",
        "PlaceOfBirth",
        "DOB",
        "Citizenship",
        "Nationality"
})
public class Row {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("AddressLine1")
    private String addressLine1;
    @JsonProperty("AddressLine2")
    private String addressLine2;
    @JsonProperty("AddressLine3")
    private String addressLine3;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("IDNumber")
    private String iDNumber;
    @JsonProperty("PlaceOfBirth")
    private String placeOfBirth;
    @JsonProperty("DOB")
    private String dOB;
    @JsonProperty("Citizenship")
    private String citizenship;
    @JsonProperty("Nationality")
    private String nationality;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     */
    public Row() {
    }

    /**
     * @param lastName
     * @param placeOfBirth
     * @param nationality
     * @param name
     * @param citizenship
     * @param addressLine3
     * @param firstName
     * @param addressLine2
     * @param iDNumber
     * @param addressLine1
     * @param dOB
     * @param country
     */
    public Row(String name, String firstName, String lastName, String addressLine1, String addressLine2, String addressLine3, String country, String iDNumber, String placeOfBirth, String dOB, String citizenship, String nationality) {
        super();
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.country = country;
        this.iDNumber = iDNumber;
        this.placeOfBirth = placeOfBirth;
        this.dOB = dOB;
        this.citizenship = citizenship;
        this.nationality = nationality;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    public Row withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Row withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Row withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @JsonProperty("AddressLine1")
    public String getAddressLine1() {
        return addressLine1;
    }

    @JsonProperty("AddressLine1")
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public Row withAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    @JsonProperty("AddressLine2")
    public String getAddressLine2() {
        return addressLine2;
    }

    @JsonProperty("AddressLine2")
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Row withAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    @JsonProperty("AddressLine3")
    public String getAddressLine3() {
        return addressLine3;
    }

    @JsonProperty("AddressLine3")
    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public Row withAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
        return this;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    public Row withCountry(String country) {
        this.country = country;
        return this;
    }

    @JsonProperty("IDNumber")
    public String getIDNumber() {
        return iDNumber;
    }

    @JsonProperty("IDNumber")
    public void setIDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
    }

    public Row withIDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
        return this;
    }

    @JsonProperty("PlaceOfBirth")
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    @JsonProperty("PlaceOfBirth")
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Row withPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    @JsonProperty("DOB")
    public String getDOB() {
        return dOB;
    }

    @JsonProperty("DOB")
    public void setDOB(String dOB) {
        this.dOB = dOB;
    }

    public Row withDOB(String dOB) {
        this.dOB = dOB;
        return this;
    }

    @JsonProperty("Citizenship")
    public String getCitizenship() {
        return citizenship;
    }

    @JsonProperty("Citizenship")
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public Row withCitizenship(String citizenship) {
        this.citizenship = citizenship;
        return this;
    }

    @JsonProperty("Nationality")
    public String getNationality() {
        return nationality;
    }

    @JsonProperty("Nationality")
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Row withNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Row withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("firstName", firstName).append("lastName", lastName).append("addressLine1", addressLine1).append("addressLine2", addressLine2).append("addressLine3", addressLine3).append("country", country).append("iDNumber", iDNumber).append("placeOfBirth", placeOfBirth).append("dOB", dOB).append("citizenship", citizenship).append("nationality", nationality).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lastName).append(placeOfBirth).append(citizenship).append(addressLine3).append(addressLine2).append(iDNumber).append(addressLine1).append(country).append(nationality).append(additionalProperties).append(name).append(firstName).append(dOB).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Row) == false) {
            return false;
        }
        Row rhs = ((Row) other);
        return new EqualsBuilder().append(lastName, rhs.lastName).append(placeOfBirth, rhs.placeOfBirth).append(citizenship, rhs.citizenship).append(addressLine3, rhs.addressLine3).append(addressLine2, rhs.addressLine2).append(iDNumber, rhs.iDNumber).append(addressLine1, rhs.addressLine1).append(country, rhs.country).append(nationality, rhs.nationality).append(additionalProperties, rhs.additionalProperties).append(name, rhs.name).append(firstName, rhs.firstName).append(dOB, rhs.dOB).isEquals();
    }

}
