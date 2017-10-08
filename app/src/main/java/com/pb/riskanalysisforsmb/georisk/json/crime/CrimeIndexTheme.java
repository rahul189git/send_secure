package com.pb.riskanalysisforsmb.georisk.json.crime;


public class CrimeIndexTheme {
    private String source;

    private String boundaryRef;

    private IndexVariable[] indexVariable;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBoundaryRef() {
        return boundaryRef;
    }

    public void setBoundaryRef(String boundaryRef) {
        this.boundaryRef = boundaryRef;
    }

    public IndexVariable[] getIndexVariable() {
        return indexVariable;
    }

    public void setIndexVariable(IndexVariable[] indexVariable) {
        this.indexVariable = indexVariable;
    }

    @Override
    public String toString() {
        return "CrimeIndexTheme [source = " + source + ", boundaryRef = " + boundaryRef + ", indexVariable = " + indexVariable + "]";
    }
}