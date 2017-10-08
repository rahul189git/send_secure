package com.pb.riskanalysisforsmb.georisk.json.crime;

public class IndexVariable {
    private String percentile;

    private String category;

    private String name;

    private String score;

    public String getPercentile() {
        return percentile;
    }

    public void setPercentile(String percentile) {
        this.percentile = percentile;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "IndexVariable [percentile = " + percentile + ", category = " + category + ", name = " + name + ", score = " + score + "]";
    }
}
