package com.pb.riskanalysisforsmb.georisk.json.crime;


public class Boundary {
    private String id;

    private String ref;

    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Boundary [id = " + id + ", ref = " + ref + ", type = " + type + "]";
    }
}
