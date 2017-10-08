package com.pb.riskanalysisforsmb.georisk.json.crime;


public class Themes {
    private CrimeIndexTheme crimeIndexTheme;

    public CrimeIndexTheme getCrimeIndexTheme() {
        return crimeIndexTheme;
    }

    public void setCrimeIndexTheme(CrimeIndexTheme crimeIndexTheme) {
        this.crimeIndexTheme = crimeIndexTheme;
    }

    @Override
    public String toString() {
        return "Themes [crimeIndexTheme = " + crimeIndexTheme + "]";
    }
}