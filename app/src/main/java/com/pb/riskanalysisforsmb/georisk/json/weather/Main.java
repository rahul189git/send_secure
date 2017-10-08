package com.pb.riskanalysisforsmb.georisk.json.weather;

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
        "temp",
        "temp_min",
        "temp_max",
        "pressure",
        "sea_level",
        "grnd_level",
        "humidity",
        "temp_kf"
})
public class Main {

    @JsonProperty("temp")
    private double temp;
    @JsonProperty("temp_min")
    private double tempMin;
    @JsonProperty("temp_max")
    private double tempMax;
    @JsonProperty("pressure")
    private double pressure;
    @JsonProperty("sea_level")
    private double seaLevel;
    @JsonProperty("grnd_level")
    private double grndLevel;
    @JsonProperty("humidity")
    private long humidity;
    @JsonProperty("temp_kf")
    private long tempKf;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     */
    public Main() {
    }

    /**
     * @param seaLevel
     * @param humidity
     * @param pressure
     * @param grndLevel
     * @param tempMax
     * @param temp
     * @param tempKf
     * @param tempMin
     */
    public Main(double temp, double tempMin, double tempMax, double pressure, double seaLevel, double grndLevel, long humidity, long tempKf) {
        super();
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.seaLevel = seaLevel;
        this.grndLevel = grndLevel;
        this.humidity = humidity;
        this.tempKf = tempKf;
    }

    @JsonProperty("temp")
    public double getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(double temp) {
        this.temp = temp;
    }

    public Main withTemp(double temp) {
        this.temp = temp;
        return this;
    }

    @JsonProperty("temp_min")
    public double getTempMin() {
        return tempMin;
    }

    @JsonProperty("temp_min")
    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public Main withTempMin(double tempMin) {
        this.tempMin = tempMin;
        return this;
    }

    @JsonProperty("temp_max")
    public double getTempMax() {
        return tempMax;
    }

    @JsonProperty("temp_max")
    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public Main withTempMax(double tempMax) {
        this.tempMax = tempMax;
        return this;
    }

    @JsonProperty("pressure")
    public double getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public Main withPressure(double pressure) {
        this.pressure = pressure;
        return this;
    }

    @JsonProperty("sea_level")
    public double getSeaLevel() {
        return seaLevel;
    }

    @JsonProperty("sea_level")
    public void setSeaLevel(double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Main withSeaLevel(double seaLevel) {
        this.seaLevel = seaLevel;
        return this;
    }

    @JsonProperty("grnd_level")
    public double getGrndLevel() {
        return grndLevel;
    }

    @JsonProperty("grnd_level")
    public void setGrndLevel(double grndLevel) {
        this.grndLevel = grndLevel;
    }

    public Main withGrndLevel(double grndLevel) {
        this.grndLevel = grndLevel;
        return this;
    }

    @JsonProperty("humidity")
    public long getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public Main withHumidity(long humidity) {
        this.humidity = humidity;
        return this;
    }

    @JsonProperty("temp_kf")
    public long getTempKf() {
        return tempKf;
    }

    @JsonProperty("temp_kf")
    public void setTempKf(long tempKf) {
        this.tempKf = tempKf;
    }

    public Main withTempKf(long tempKf) {
        this.tempKf = tempKf;
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

    public Main withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("temp", temp).append("tempMin", tempMin).append("tempMax", tempMax).append("pressure", pressure).append("seaLevel", seaLevel).append("grndLevel", grndLevel).append("humidity", humidity).append("tempKf", tempKf).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(seaLevel).append(humidity).append(pressure).append(grndLevel).append(tempMax).append(additionalProperties).append(temp).append(tempKf).append(tempMin).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Main) == false) {
            return false;
        }
        Main rhs = ((Main) other);
        return new EqualsBuilder().append(seaLevel, rhs.seaLevel).append(humidity, rhs.humidity).append(pressure, rhs.pressure).append(grndLevel, rhs.grndLevel).append(tempMax, rhs.tempMax).append(additionalProperties, rhs.additionalProperties).append(temp, rhs.temp).append(tempKf, rhs.tempKf).append(tempMin, rhs.tempMin).isEquals();
    }

}
