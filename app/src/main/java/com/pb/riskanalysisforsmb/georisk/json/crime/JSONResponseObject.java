package com.pb.riskanalysisforsmb.georisk.json.crime;


public class JSONResponseObject {
    private MatchedAddress matchedAddress;

    private Boundaries boundaries;

    private Themes[] themes;

    public MatchedAddress getMatchedAddress() {
        return matchedAddress;
    }

    public void setMatchedAddress(MatchedAddress matchedAddress) {
        this.matchedAddress = matchedAddress;
    }

    public Boundaries getBoundaries() {
        return boundaries;
    }

    public void setBoundaries(Boundaries boundaries) {
        this.boundaries = boundaries;
    }

    public Themes[] getThemes() {
        return themes;
    }

    public void setThemes(Themes[] themes) {
        this.themes = themes;
    }

    @Override
    public String toString() {
        return "JSONResponseObject [matchedAddress = " + matchedAddress + ", boundaries = " + boundaries + ", themes = " + themes + "]";
    }
}

