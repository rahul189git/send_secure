package com.pb.riskanalysisforsmb.identity;

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
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "OverallRiskLevel",
        "SanctionedCountryIdentified",
        "AddressLine1",
        "AddressLine2",
        "AddressLine3",
        "Citizenship",
        "Country",
        "DOB",
        "FirstName",
        "IDNumber",
        "LastName",
        "Name",
        "Nationality",
        "EntryID",
        "InputFilteredFirstName",
        "InputFilteredLastName",
        "InputFilteredName",
        "InputFirstName",
        "InputLastName",
        "InputName",
        "ListType",
        "NameMatchIdentified",
        "NameProvided",
        "AddressProvided",
        "IDNumberProvided",
        "InputAddressLine1",
        "InputAddressLine2",
        "InputAddressLine3",
        "InputCountry",
        "InputIDNumber",
        "InputDOB",
        "InputNationality",
        "InputCitizenship",
        "InputPlaceOfBirth",
        "AddressMatchIdentified",
        "IDNumberMatchIdentified",
        "CitizenshipScore",
        "CitizenshipMatchIdentified",
        "DOBScore",
        "DOBMatchIdentified",
        "NationalityScore",
        "NationalityMatchIdentified",
        "PlaceOfBirthScore",
        "PlaceOfBirthMatchIdentified",
        "CitizenshipProvided",
        "DOBProvided",
        "NationalityProvided",
        "PlaceOfBirthProvided",
        "NameScore",
        "MatchStatus",
        "user_fields"
})
public class Output {

    @JsonProperty("OverallRiskLevel")
    private String overallRiskLevel;
    @JsonProperty("SanctionedCountryIdentified")
    private String sanctionedCountryIdentified;
    @JsonProperty("AddressLine1")
    private String addressLine1;
    @JsonProperty("AddressLine2")
    private String addressLine2;
    @JsonProperty("AddressLine3")
    private String addressLine3;
    @JsonProperty("Citizenship")
    private String citizenship;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("DOB")
    private String dOB;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("IDNumber")
    private String iDNumber;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Nationality")
    private String nationality;
    @JsonProperty("EntryID")
    private String entryID;
    @JsonProperty("InputFilteredFirstName")
    private String inputFilteredFirstName;
    @JsonProperty("InputFilteredLastName")
    private String inputFilteredLastName;
    @JsonProperty("InputFilteredName")
    private String inputFilteredName;
    @JsonProperty("InputFirstName")
    private String inputFirstName;
    @JsonProperty("InputLastName")
    private String inputLastName;
    @JsonProperty("InputName")
    private String inputName;
    @JsonProperty("ListType")
    private String listType;
    @JsonProperty("NameMatchIdentified")
    private String nameMatchIdentified;
    @JsonProperty("NameProvided")
    private String nameProvided;
    @JsonProperty("AddressProvided")
    private String addressProvided;
    @JsonProperty("IDNumberProvided")
    private String iDNumberProvided;
    @JsonProperty("InputAddressLine1")
    private String inputAddressLine1;
    @JsonProperty("InputAddressLine2")
    private String inputAddressLine2;
    @JsonProperty("InputAddressLine3")
    private String inputAddressLine3;
    @JsonProperty("InputCountry")
    private String inputCountry;
    @JsonProperty("InputIDNumber")
    private String inputIDNumber;
    @JsonProperty("InputDOB")
    private String inputDOB;
    @JsonProperty("InputNationality")
    private String inputNationality;
    @JsonProperty("InputCitizenship")
    private String inputCitizenship;
    @JsonProperty("InputPlaceOfBirth")
    private String inputPlaceOfBirth;
    @JsonProperty("AddressMatchIdentified")
    private String addressMatchIdentified;
    @JsonProperty("IDNumberMatchIdentified")
    private String iDNumberMatchIdentified;
    @JsonProperty("CitizenshipScore")
    private String citizenshipScore;
    @JsonProperty("CitizenshipMatchIdentified")
    private String citizenshipMatchIdentified;
    @JsonProperty("DOBScore")
    private String dOBScore;
    @JsonProperty("DOBMatchIdentified")
    private String dOBMatchIdentified;
    @JsonProperty("NationalityScore")
    private String nationalityScore;
    @JsonProperty("NationalityMatchIdentified")
    private String nationalityMatchIdentified;
    @JsonProperty("PlaceOfBirthScore")
    private String placeOfBirthScore;
    @JsonProperty("PlaceOfBirthMatchIdentified")
    private String placeOfBirthMatchIdentified;
    @JsonProperty("CitizenshipProvided")
    private String citizenshipProvided;
    @JsonProperty("DOBProvided")
    private String dOBProvided;
    @JsonProperty("NationalityProvided")
    private String nationalityProvided;
    @JsonProperty("PlaceOfBirthProvided")
    private String placeOfBirthProvided;
    @JsonProperty("NameScore")
    private String nameScore;
    @JsonProperty("MatchStatus")
    private String matchStatus;
    @JsonProperty("user_fields")
    private List<Object> userFields = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     */
    public Output() {
    }

    /**
     * @param inputNationality
     * @param inputIDNumber
     * @param dOBMatchIdentified
     * @param overallRiskLevel
     * @param citizenshipMatchIdentified
     * @param inputFilteredLastName
     * @param inputAddressLine2
     * @param addressProvided
     * @param inputAddressLine3
     * @param citizenshipScore
     * @param inputAddressLine1
     * @param nameMatchIdentified
     * @param iDNumber
     * @param placeOfBirthScore
     * @param addressMatchIdentified
     * @param nationalityScore
     * @param lastName
     * @param sanctionedCountryIdentified
     * @param inputDOB
     * @param nameScore
     * @param inputLastName
     * @param addressLine3
     * @param inputFilteredName
     * @param entryID
     * @param addressLine2
     * @param addressLine1
     * @param country
     * @param iDNumberProvided
     * @param inputCitizenship
     * @param dOB
     * @param nationalityProvided
     * @param citizenship
     * @param inputName
     * @param nameProvided
     * @param nationalityMatchIdentified
     * @param userFields
     * @param inputCountry
     * @param name
     * @param placeOfBirthMatchIdentified
     * @param inputPlaceOfBirth
     * @param firstName
     * @param iDNumberMatchIdentified
     * @param citizenshipProvided
     * @param dOBProvided
     * @param inputFirstName
     * @param listType
     * @param dOBScore
     * @param nationality
     * @param placeOfBirthProvided
     * @param matchStatus
     * @param inputFilteredFirstName
     */
    public Output(String overallRiskLevel, String sanctionedCountryIdentified, String addressLine1, String addressLine2, String addressLine3, String citizenship, String country, String dOB, String firstName, String iDNumber, String lastName, String name, String nationality, String entryID, String inputFilteredFirstName, String inputFilteredLastName, String inputFilteredName, String inputFirstName, String inputLastName, String inputName, String listType, String nameMatchIdentified, String nameProvided, String addressProvided, String iDNumberProvided, String inputAddressLine1, String inputAddressLine2, String inputAddressLine3, String inputCountry, String inputIDNumber, String inputDOB, String inputNationality, String inputCitizenship, String inputPlaceOfBirth, String addressMatchIdentified, String iDNumberMatchIdentified, String citizenshipScore, String citizenshipMatchIdentified, String dOBScore, String dOBMatchIdentified, String nationalityScore, String nationalityMatchIdentified, String placeOfBirthScore, String placeOfBirthMatchIdentified, String citizenshipProvided, String dOBProvided, String nationalityProvided, String placeOfBirthProvided, String nameScore, String matchStatus, List<Object> userFields) {
        super();
        this.overallRiskLevel = overallRiskLevel;
        this.sanctionedCountryIdentified = sanctionedCountryIdentified;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.citizenship = citizenship;
        this.country = country;
        this.dOB = dOB;
        this.firstName = firstName;
        this.iDNumber = iDNumber;
        this.lastName = lastName;
        this.name = name;
        this.nationality = nationality;
        this.entryID = entryID;
        this.inputFilteredFirstName = inputFilteredFirstName;
        this.inputFilteredLastName = inputFilteredLastName;
        this.inputFilteredName = inputFilteredName;
        this.inputFirstName = inputFirstName;
        this.inputLastName = inputLastName;
        this.inputName = inputName;
        this.listType = listType;
        this.nameMatchIdentified = nameMatchIdentified;
        this.nameProvided = nameProvided;
        this.addressProvided = addressProvided;
        this.iDNumberProvided = iDNumberProvided;
        this.inputAddressLine1 = inputAddressLine1;
        this.inputAddressLine2 = inputAddressLine2;
        this.inputAddressLine3 = inputAddressLine3;
        this.inputCountry = inputCountry;
        this.inputIDNumber = inputIDNumber;
        this.inputDOB = inputDOB;
        this.inputNationality = inputNationality;
        this.inputCitizenship = inputCitizenship;
        this.inputPlaceOfBirth = inputPlaceOfBirth;
        this.addressMatchIdentified = addressMatchIdentified;
        this.iDNumberMatchIdentified = iDNumberMatchIdentified;
        this.citizenshipScore = citizenshipScore;
        this.citizenshipMatchIdentified = citizenshipMatchIdentified;
        this.dOBScore = dOBScore;
        this.dOBMatchIdentified = dOBMatchIdentified;
        this.nationalityScore = nationalityScore;
        this.nationalityMatchIdentified = nationalityMatchIdentified;
        this.placeOfBirthScore = placeOfBirthScore;
        this.placeOfBirthMatchIdentified = placeOfBirthMatchIdentified;
        this.citizenshipProvided = citizenshipProvided;
        this.dOBProvided = dOBProvided;
        this.nationalityProvided = nationalityProvided;
        this.placeOfBirthProvided = placeOfBirthProvided;
        this.nameScore = nameScore;
        this.matchStatus = matchStatus;
        this.userFields = userFields;
    }

    @JsonProperty("OverallRiskLevel")
    public String getOverallRiskLevel() {
        return overallRiskLevel;
    }

    @JsonProperty("OverallRiskLevel")
    public void setOverallRiskLevel(String overallRiskLevel) {
        this.overallRiskLevel = overallRiskLevel;
    }

    public Output withOverallRiskLevel(String overallRiskLevel) {
        this.overallRiskLevel = overallRiskLevel;
        return this;
    }

    @JsonProperty("SanctionedCountryIdentified")
    public String getSanctionedCountryIdentified() {
        return sanctionedCountryIdentified;
    }

    @JsonProperty("SanctionedCountryIdentified")
    public void setSanctionedCountryIdentified(String sanctionedCountryIdentified) {
        this.sanctionedCountryIdentified = sanctionedCountryIdentified;
    }

    public Output withSanctionedCountryIdentified(String sanctionedCountryIdentified) {
        this.sanctionedCountryIdentified = sanctionedCountryIdentified;
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

    public Output withAddressLine1(String addressLine1) {
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

    public Output withAddressLine2(String addressLine2) {
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

    public Output withAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
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

    public Output withCitizenship(String citizenship) {
        this.citizenship = citizenship;
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

    public Output withCountry(String country) {
        this.country = country;
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

    public Output withDOB(String dOB) {
        this.dOB = dOB;
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

    public Output withFirstName(String firstName) {
        this.firstName = firstName;
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

    public Output withIDNumber(String iDNumber) {
        this.iDNumber = iDNumber;
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

    public Output withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    public Output withName(String name) {
        this.name = name;
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

    public Output withNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    @JsonProperty("EntryID")
    public String getEntryID() {
        return entryID;
    }

    @JsonProperty("EntryID")
    public void setEntryID(String entryID) {
        this.entryID = entryID;
    }

    public Output withEntryID(String entryID) {
        this.entryID = entryID;
        return this;
    }

    @JsonProperty("InputFilteredFirstName")
    public String getInputFilteredFirstName() {
        return inputFilteredFirstName;
    }

    @JsonProperty("InputFilteredFirstName")
    public void setInputFilteredFirstName(String inputFilteredFirstName) {
        this.inputFilteredFirstName = inputFilteredFirstName;
    }

    public Output withInputFilteredFirstName(String inputFilteredFirstName) {
        this.inputFilteredFirstName = inputFilteredFirstName;
        return this;
    }

    @JsonProperty("InputFilteredLastName")
    public String getInputFilteredLastName() {
        return inputFilteredLastName;
    }

    @JsonProperty("InputFilteredLastName")
    public void setInputFilteredLastName(String inputFilteredLastName) {
        this.inputFilteredLastName = inputFilteredLastName;
    }

    public Output withInputFilteredLastName(String inputFilteredLastName) {
        this.inputFilteredLastName = inputFilteredLastName;
        return this;
    }

    @JsonProperty("InputFilteredName")
    public String getInputFilteredName() {
        return inputFilteredName;
    }

    @JsonProperty("InputFilteredName")
    public void setInputFilteredName(String inputFilteredName) {
        this.inputFilteredName = inputFilteredName;
    }

    public Output withInputFilteredName(String inputFilteredName) {
        this.inputFilteredName = inputFilteredName;
        return this;
    }

    @JsonProperty("InputFirstName")
    public String getInputFirstName() {
        return inputFirstName;
    }

    @JsonProperty("InputFirstName")
    public void setInputFirstName(String inputFirstName) {
        this.inputFirstName = inputFirstName;
    }

    public Output withInputFirstName(String inputFirstName) {
        this.inputFirstName = inputFirstName;
        return this;
    }

    @JsonProperty("InputLastName")
    public String getInputLastName() {
        return inputLastName;
    }

    @JsonProperty("InputLastName")
    public void setInputLastName(String inputLastName) {
        this.inputLastName = inputLastName;
    }

    public Output withInputLastName(String inputLastName) {
        this.inputLastName = inputLastName;
        return this;
    }

    @JsonProperty("InputName")
    public String getInputName() {
        return inputName;
    }

    @JsonProperty("InputName")
    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public Output withInputName(String inputName) {
        this.inputName = inputName;
        return this;
    }

    @JsonProperty("ListType")
    public String getListType() {
        return listType;
    }

    @JsonProperty("ListType")
    public void setListType(String listType) {
        this.listType = listType;
    }

    public Output withListType(String listType) {
        this.listType = listType;
        return this;
    }

    @JsonProperty("NameMatchIdentified")
    public String getNameMatchIdentified() {
        return nameMatchIdentified;
    }

    @JsonProperty("NameMatchIdentified")
    public void setNameMatchIdentified(String nameMatchIdentified) {
        this.nameMatchIdentified = nameMatchIdentified;
    }

    public Output withNameMatchIdentified(String nameMatchIdentified) {
        this.nameMatchIdentified = nameMatchIdentified;
        return this;
    }

    @JsonProperty("NameProvided")
    public String getNameProvided() {
        return nameProvided;
    }

    @JsonProperty("NameProvided")
    public void setNameProvided(String nameProvided) {
        this.nameProvided = nameProvided;
    }

    public Output withNameProvided(String nameProvided) {
        this.nameProvided = nameProvided;
        return this;
    }

    @JsonProperty("AddressProvided")
    public String getAddressProvided() {
        return addressProvided;
    }

    @JsonProperty("AddressProvided")
    public void setAddressProvided(String addressProvided) {
        this.addressProvided = addressProvided;
    }

    public Output withAddressProvided(String addressProvided) {
        this.addressProvided = addressProvided;
        return this;
    }

    @JsonProperty("IDNumberProvided")
    public String getIDNumberProvided() {
        return iDNumberProvided;
    }

    @JsonProperty("IDNumberProvided")
    public void setIDNumberProvided(String iDNumberProvided) {
        this.iDNumberProvided = iDNumberProvided;
    }

    public Output withIDNumberProvided(String iDNumberProvided) {
        this.iDNumberProvided = iDNumberProvided;
        return this;
    }

    @JsonProperty("InputAddressLine1")
    public String getInputAddressLine1() {
        return inputAddressLine1;
    }

    @JsonProperty("InputAddressLine1")
    public void setInputAddressLine1(String inputAddressLine1) {
        this.inputAddressLine1 = inputAddressLine1;
    }

    public Output withInputAddressLine1(String inputAddressLine1) {
        this.inputAddressLine1 = inputAddressLine1;
        return this;
    }

    @JsonProperty("InputAddressLine2")
    public String getInputAddressLine2() {
        return inputAddressLine2;
    }

    @JsonProperty("InputAddressLine2")
    public void setInputAddressLine2(String inputAddressLine2) {
        this.inputAddressLine2 = inputAddressLine2;
    }

    public Output withInputAddressLine2(String inputAddressLine2) {
        this.inputAddressLine2 = inputAddressLine2;
        return this;
    }

    @JsonProperty("InputAddressLine3")
    public String getInputAddressLine3() {
        return inputAddressLine3;
    }

    @JsonProperty("InputAddressLine3")
    public void setInputAddressLine3(String inputAddressLine3) {
        this.inputAddressLine3 = inputAddressLine3;
    }

    public Output withInputAddressLine3(String inputAddressLine3) {
        this.inputAddressLine3 = inputAddressLine3;
        return this;
    }

    @JsonProperty("InputCountry")
    public String getInputCountry() {
        return inputCountry;
    }

    @JsonProperty("InputCountry")
    public void setInputCountry(String inputCountry) {
        this.inputCountry = inputCountry;
    }

    public Output withInputCountry(String inputCountry) {
        this.inputCountry = inputCountry;
        return this;
    }

    @JsonProperty("InputIDNumber")
    public String getInputIDNumber() {
        return inputIDNumber;
    }

    @JsonProperty("InputIDNumber")
    public void setInputIDNumber(String inputIDNumber) {
        this.inputIDNumber = inputIDNumber;
    }

    public Output withInputIDNumber(String inputIDNumber) {
        this.inputIDNumber = inputIDNumber;
        return this;
    }

    @JsonProperty("InputDOB")
    public String getInputDOB() {
        return inputDOB;
    }

    @JsonProperty("InputDOB")
    public void setInputDOB(String inputDOB) {
        this.inputDOB = inputDOB;
    }

    public Output withInputDOB(String inputDOB) {
        this.inputDOB = inputDOB;
        return this;
    }

    @JsonProperty("InputNationality")
    public String getInputNationality() {
        return inputNationality;
    }

    @JsonProperty("InputNationality")
    public void setInputNationality(String inputNationality) {
        this.inputNationality = inputNationality;
    }

    public Output withInputNationality(String inputNationality) {
        this.inputNationality = inputNationality;
        return this;
    }

    @JsonProperty("InputCitizenship")
    public String getInputCitizenship() {
        return inputCitizenship;
    }

    @JsonProperty("InputCitizenship")
    public void setInputCitizenship(String inputCitizenship) {
        this.inputCitizenship = inputCitizenship;
    }

    public Output withInputCitizenship(String inputCitizenship) {
        this.inputCitizenship = inputCitizenship;
        return this;
    }

    @JsonProperty("InputPlaceOfBirth")
    public String getInputPlaceOfBirth() {
        return inputPlaceOfBirth;
    }

    @JsonProperty("InputPlaceOfBirth")
    public void setInputPlaceOfBirth(String inputPlaceOfBirth) {
        this.inputPlaceOfBirth = inputPlaceOfBirth;
    }

    public Output withInputPlaceOfBirth(String inputPlaceOfBirth) {
        this.inputPlaceOfBirth = inputPlaceOfBirth;
        return this;
    }

    @JsonProperty("AddressMatchIdentified")
    public String getAddressMatchIdentified() {
        return addressMatchIdentified;
    }

    @JsonProperty("AddressMatchIdentified")
    public void setAddressMatchIdentified(String addressMatchIdentified) {
        this.addressMatchIdentified = addressMatchIdentified;
    }

    public Output withAddressMatchIdentified(String addressMatchIdentified) {
        this.addressMatchIdentified = addressMatchIdentified;
        return this;
    }

    @JsonProperty("IDNumberMatchIdentified")
    public String getIDNumberMatchIdentified() {
        return iDNumberMatchIdentified;
    }

    @JsonProperty("IDNumberMatchIdentified")
    public void setIDNumberMatchIdentified(String iDNumberMatchIdentified) {
        this.iDNumberMatchIdentified = iDNumberMatchIdentified;
    }

    public Output withIDNumberMatchIdentified(String iDNumberMatchIdentified) {
        this.iDNumberMatchIdentified = iDNumberMatchIdentified;
        return this;
    }

    @JsonProperty("CitizenshipScore")
    public String getCitizenshipScore() {
        return citizenshipScore;
    }

    @JsonProperty("CitizenshipScore")
    public void setCitizenshipScore(String citizenshipScore) {
        this.citizenshipScore = citizenshipScore;
    }

    public Output withCitizenshipScore(String citizenshipScore) {
        this.citizenshipScore = citizenshipScore;
        return this;
    }

    @JsonProperty("CitizenshipMatchIdentified")
    public String getCitizenshipMatchIdentified() {
        return citizenshipMatchIdentified;
    }

    @JsonProperty("CitizenshipMatchIdentified")
    public void setCitizenshipMatchIdentified(String citizenshipMatchIdentified) {
        this.citizenshipMatchIdentified = citizenshipMatchIdentified;
    }

    public Output withCitizenshipMatchIdentified(String citizenshipMatchIdentified) {
        this.citizenshipMatchIdentified = citizenshipMatchIdentified;
        return this;
    }

    @JsonProperty("DOBScore")
    public String getDOBScore() {
        return dOBScore;
    }

    @JsonProperty("DOBScore")
    public void setDOBScore(String dOBScore) {
        this.dOBScore = dOBScore;
    }

    public Output withDOBScore(String dOBScore) {
        this.dOBScore = dOBScore;
        return this;
    }

    @JsonProperty("DOBMatchIdentified")
    public String getDOBMatchIdentified() {
        return dOBMatchIdentified;
    }

    @JsonProperty("DOBMatchIdentified")
    public void setDOBMatchIdentified(String dOBMatchIdentified) {
        this.dOBMatchIdentified = dOBMatchIdentified;
    }

    public Output withDOBMatchIdentified(String dOBMatchIdentified) {
        this.dOBMatchIdentified = dOBMatchIdentified;
        return this;
    }

    @JsonProperty("NationalityScore")
    public String getNationalityScore() {
        return nationalityScore;
    }

    @JsonProperty("NationalityScore")
    public void setNationalityScore(String nationalityScore) {
        this.nationalityScore = nationalityScore;
    }

    public Output withNationalityScore(String nationalityScore) {
        this.nationalityScore = nationalityScore;
        return this;
    }

    @JsonProperty("NationalityMatchIdentified")
    public String getNationalityMatchIdentified() {
        return nationalityMatchIdentified;
    }

    @JsonProperty("NationalityMatchIdentified")
    public void setNationalityMatchIdentified(String nationalityMatchIdentified) {
        this.nationalityMatchIdentified = nationalityMatchIdentified;
    }

    public Output withNationalityMatchIdentified(String nationalityMatchIdentified) {
        this.nationalityMatchIdentified = nationalityMatchIdentified;
        return this;
    }

    @JsonProperty("PlaceOfBirthScore")
    public String getPlaceOfBirthScore() {
        return placeOfBirthScore;
    }

    @JsonProperty("PlaceOfBirthScore")
    public void setPlaceOfBirthScore(String placeOfBirthScore) {
        this.placeOfBirthScore = placeOfBirthScore;
    }

    public Output withPlaceOfBirthScore(String placeOfBirthScore) {
        this.placeOfBirthScore = placeOfBirthScore;
        return this;
    }

    @JsonProperty("PlaceOfBirthMatchIdentified")
    public String getPlaceOfBirthMatchIdentified() {
        return placeOfBirthMatchIdentified;
    }

    @JsonProperty("PlaceOfBirthMatchIdentified")
    public void setPlaceOfBirthMatchIdentified(String placeOfBirthMatchIdentified) {
        this.placeOfBirthMatchIdentified = placeOfBirthMatchIdentified;
    }

    public Output withPlaceOfBirthMatchIdentified(String placeOfBirthMatchIdentified) {
        this.placeOfBirthMatchIdentified = placeOfBirthMatchIdentified;
        return this;
    }

    @JsonProperty("CitizenshipProvided")
    public String getCitizenshipProvided() {
        return citizenshipProvided;
    }

    @JsonProperty("CitizenshipProvided")
    public void setCitizenshipProvided(String citizenshipProvided) {
        this.citizenshipProvided = citizenshipProvided;
    }

    public Output withCitizenshipProvided(String citizenshipProvided) {
        this.citizenshipProvided = citizenshipProvided;
        return this;
    }

    @JsonProperty("DOBProvided")
    public String getDOBProvided() {
        return dOBProvided;
    }

    @JsonProperty("DOBProvided")
    public void setDOBProvided(String dOBProvided) {
        this.dOBProvided = dOBProvided;
    }

    public Output withDOBProvided(String dOBProvided) {
        this.dOBProvided = dOBProvided;
        return this;
    }

    @JsonProperty("NationalityProvided")
    public String getNationalityProvided() {
        return nationalityProvided;
    }

    @JsonProperty("NationalityProvided")
    public void setNationalityProvided(String nationalityProvided) {
        this.nationalityProvided = nationalityProvided;
    }

    public Output withNationalityProvided(String nationalityProvided) {
        this.nationalityProvided = nationalityProvided;
        return this;
    }

    @JsonProperty("PlaceOfBirthProvided")
    public String getPlaceOfBirthProvided() {
        return placeOfBirthProvided;
    }

    @JsonProperty("PlaceOfBirthProvided")
    public void setPlaceOfBirthProvided(String placeOfBirthProvided) {
        this.placeOfBirthProvided = placeOfBirthProvided;
    }

    public Output withPlaceOfBirthProvided(String placeOfBirthProvided) {
        this.placeOfBirthProvided = placeOfBirthProvided;
        return this;
    }

    @JsonProperty("NameScore")
    public String getNameScore() {
        return nameScore;
    }

    @JsonProperty("NameScore")
    public void setNameScore(String nameScore) {
        this.nameScore = nameScore;
    }

    public Output withNameScore(String nameScore) {
        this.nameScore = nameScore;
        return this;
    }

    @JsonProperty("MatchStatus")
    public String getMatchStatus() {
        return matchStatus;
    }

    @JsonProperty("MatchStatus")
    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public Output withMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
        return this;
    }

    @JsonProperty("user_fields")
    public List<Object> getUserFields() {
        return userFields;
    }

    @JsonProperty("user_fields")
    public void setUserFields(List<Object> userFields) {
        this.userFields = userFields;
    }

    public Output withUserFields(List<Object> userFields) {
        this.userFields = userFields;
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

    public Output withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("overallRiskLevel", overallRiskLevel).append("sanctionedCountryIdentified", sanctionedCountryIdentified).append("addressLine1", addressLine1).append("addressLine2", addressLine2).append("addressLine3", addressLine3).append("citizenship", citizenship).append("country", country).append("dOB", dOB).append("firstName", firstName).append("iDNumber", iDNumber).append("lastName", lastName).append("name", name).append("nationality", nationality).append("entryID", entryID).append("inputFilteredFirstName", inputFilteredFirstName).append("inputFilteredLastName", inputFilteredLastName).append("inputFilteredName", inputFilteredName).append("inputFirstName", inputFirstName).append("inputLastName", inputLastName).append("inputName", inputName).append("listType", listType).append("nameMatchIdentified", nameMatchIdentified).append("nameProvided", nameProvided).append("addressProvided", addressProvided).append("iDNumberProvided", iDNumberProvided).append("inputAddressLine1", inputAddressLine1).append("inputAddressLine2", inputAddressLine2).append("inputAddressLine3", inputAddressLine3).append("inputCountry", inputCountry).append("inputIDNumber", inputIDNumber).append("inputDOB", inputDOB).append("inputNationality", inputNationality).append("inputCitizenship", inputCitizenship).append("inputPlaceOfBirth", inputPlaceOfBirth).append("addressMatchIdentified", addressMatchIdentified).append("iDNumberMatchIdentified", iDNumberMatchIdentified).append("citizenshipScore", citizenshipScore).append("citizenshipMatchIdentified", citizenshipMatchIdentified).append("dOBScore", dOBScore).append("dOBMatchIdentified", dOBMatchIdentified).append("nationalityScore", nationalityScore).append("nationalityMatchIdentified", nationalityMatchIdentified).append("placeOfBirthScore", placeOfBirthScore).append("placeOfBirthMatchIdentified", placeOfBirthMatchIdentified).append("citizenshipProvided", citizenshipProvided).append("dOBProvided", dOBProvided).append("nationalityProvided", nationalityProvided).append("placeOfBirthProvided", placeOfBirthProvided).append("nameScore", nameScore).append("matchStatus", matchStatus).append("userFields", userFields).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(inputNationality).append(dOBMatchIdentified).append(inputIDNumber).append(citizenshipMatchIdentified).append(overallRiskLevel).append(inputFilteredLastName).append(inputAddressLine2).append(citizenshipScore).append(inputAddressLine3).append(addressProvided).append(inputAddressLine1).append(nameMatchIdentified).append(iDNumber).append(placeOfBirthScore).append(addressMatchIdentified).append(nationalityScore).append(lastName).append(inputDOB).append(sanctionedCountryIdentified).append(nameScore).append(inputLastName).append(addressLine3).append(inputFilteredName).append(entryID).append(addressLine2).append(addressLine1).append(country).append(iDNumberProvided).append(inputCitizenship).append(additionalProperties).append(dOB).append(nationalityProvided).append(citizenship).append(inputName).append(nameProvided).append(nationalityMatchIdentified).append(userFields).append(inputCountry).append(name).append(placeOfBirthMatchIdentified).append(inputPlaceOfBirth).append(firstName).append(citizenshipProvided).append(iDNumberMatchIdentified).append(dOBProvided).append(inputFirstName).append(listType).append(dOBScore).append(nationality).append(placeOfBirthProvided).append(matchStatus).append(inputFilteredFirstName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Output) == false) {
            return false;
        }
        Output rhs = ((Output) other);
        return new EqualsBuilder().append(inputNationality, rhs.inputNationality).append(dOBMatchIdentified, rhs.dOBMatchIdentified).append(inputIDNumber, rhs.inputIDNumber).append(citizenshipMatchIdentified, rhs.citizenshipMatchIdentified).append(overallRiskLevel, rhs.overallRiskLevel).append(inputFilteredLastName, rhs.inputFilteredLastName).append(inputAddressLine2, rhs.inputAddressLine2).append(citizenshipScore, rhs.citizenshipScore).append(inputAddressLine3, rhs.inputAddressLine3).append(addressProvided, rhs.addressProvided).append(inputAddressLine1, rhs.inputAddressLine1).append(nameMatchIdentified, rhs.nameMatchIdentified).append(iDNumber, rhs.iDNumber).append(placeOfBirthScore, rhs.placeOfBirthScore).append(addressMatchIdentified, rhs.addressMatchIdentified).append(nationalityScore, rhs.nationalityScore).append(lastName, rhs.lastName).append(inputDOB, rhs.inputDOB).append(sanctionedCountryIdentified, rhs.sanctionedCountryIdentified).append(nameScore, rhs.nameScore).append(inputLastName, rhs.inputLastName).append(addressLine3, rhs.addressLine3).append(inputFilteredName, rhs.inputFilteredName).append(entryID, rhs.entryID).append(addressLine2, rhs.addressLine2).append(addressLine1, rhs.addressLine1).append(country, rhs.country).append(iDNumberProvided, rhs.iDNumberProvided).append(inputCitizenship, rhs.inputCitizenship).append(additionalProperties, rhs.additionalProperties).append(dOB, rhs.dOB).append(nationalityProvided, rhs.nationalityProvided).append(citizenship, rhs.citizenship).append(inputName, rhs.inputName).append(nameProvided, rhs.nameProvided).append(nationalityMatchIdentified, rhs.nationalityMatchIdentified).append(userFields, rhs.userFields).append(inputCountry, rhs.inputCountry).append(name, rhs.name).append(placeOfBirthMatchIdentified, rhs.placeOfBirthMatchIdentified).append(inputPlaceOfBirth, rhs.inputPlaceOfBirth).append(firstName, rhs.firstName).append(citizenshipProvided, rhs.citizenshipProvided).append(iDNumberMatchIdentified, rhs.iDNumberMatchIdentified).append(dOBProvided, rhs.dOBProvided).append(inputFirstName, rhs.inputFirstName).append(listType, rhs.listType).append(dOBScore, rhs.dOBScore).append(nationality, rhs.nationality).append(placeOfBirthProvided, rhs.placeOfBirthProvided).append(matchStatus, rhs.matchStatus).append(inputFilteredFirstName, rhs.inputFilteredFirstName).isEquals();
    }

}
