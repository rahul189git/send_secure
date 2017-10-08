package com.pb.riskanalysisforsmb.georisk.json.crime;


public class Boundaries {
    private Boundary[] boundary;

    public Boundary[] getBoundary() {
        return boundary;
    }

    public void setBoundary(Boundary[] boundary) {
        this.boundary = boundary;
    }

    @Override
    public String toString() {
        return "Boundaries [boundary = " + boundary + "]";
    }
}