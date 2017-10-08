package com.pb.riskanalysisforsmb;


import android.os.Parcel;
import android.os.Parcelable;

public final class AddressWithRisk implements Parcelable {

    private final String address;
    private final String crimeRiskScore;
    private final String crimeRiskSeverity;
    private String weatherRiskDescription;

    public AddressWithRisk() {
        address = null;
        crimeRiskScore = null;
        crimeRiskSeverity = null;
    }

    public AddressWithRisk(String address, String crimeRiskScore, String crimeRiskSeverity) {
        this.address = address;
        this.crimeRiskScore = crimeRiskScore;
        this.crimeRiskSeverity = crimeRiskSeverity;
    }

    protected AddressWithRisk(Parcel in) {
        address = in.readString();
        crimeRiskScore = in.readString();
        crimeRiskSeverity = in.readString();
        weatherRiskDescription = in.readString();
    }

    public static final Creator<AddressWithRisk> CREATOR = new Creator<AddressWithRisk>() {
        @Override
        public AddressWithRisk createFromParcel(Parcel in) {
            return new AddressWithRisk(in);
        }

        @Override
        public AddressWithRisk[] newArray(int size) {
            return new AddressWithRisk[size];
        }
    };

    public String getAddress() {
        return address;
    }

    public String getCrimeRiskScore() {
        return crimeRiskScore;
    }

    public String getCrimeRiskSeverity() {
        return crimeRiskSeverity;
    }

    public String getWeatherRiskDescription() {
        return weatherRiskDescription;
    }

    public void setWeatherRiskDescription(String weatherRiskDescription) {
        this.weatherRiskDescription = weatherRiskDescription;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeString(this.crimeRiskScore);
        dest.writeString(this.crimeRiskSeverity);
        dest.writeString(this.weatherRiskDescription);

    }
}
