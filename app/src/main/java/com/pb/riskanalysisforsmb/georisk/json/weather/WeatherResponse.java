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
        "cod",
        "message",
        "cnt",
        "list",
        "city"
})
public class WeatherResponse {

    @JsonProperty("cod")
    private String cod;
    @JsonProperty("message")
    private double message;
    @JsonProperty("cnt")
    private long cnt;
    @JsonProperty("list")
    private java.util.List<List> list = null;
    @JsonProperty("city")
    private City city;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     */
    public WeatherResponse() {
    }

    /**
     * @param message
     * @param cnt
     * @param cod
     * @param list
     * @param city
     */
    public WeatherResponse(String cod, double message, long cnt, java.util.List<List> list, City city) {
        super();
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    @JsonProperty("cod")
    public String getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(String cod) {
        this.cod = cod;
    }

    public WeatherResponse withCod(String cod) {
        this.cod = cod;
        return this;
    }

    @JsonProperty("message")
    public double getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(double message) {
        this.message = message;
    }

    public WeatherResponse withMessage(double message) {
        this.message = message;
        return this;
    }

    @JsonProperty("cnt")
    public long getCnt() {
        return cnt;
    }

    @JsonProperty("cnt")
    public void setCnt(long cnt) {
        this.cnt = cnt;
    }

    public WeatherResponse withCnt(long cnt) {
        this.cnt = cnt;
        return this;
    }

    @JsonProperty("list")
    public java.util.List<List> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public WeatherResponse withList(java.util.List<List> list) {
        this.list = list;
        return this;
    }

    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }

    public WeatherResponse withCity(City city) {
        this.city = city;
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

    public WeatherResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cod", cod).append("message", message).append("cnt", cnt).append("list", list).append("city", city).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(message).append(cnt).append(cod).append(additionalProperties).append(list).append(city).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WeatherResponse) == false) {
            return false;
        }
        WeatherResponse rhs = ((WeatherResponse) other);
        return new EqualsBuilder().append(message, rhs.message).append(cnt, rhs.cnt).append(cod, rhs.cod).append(additionalProperties, rhs.additionalProperties).append(list, rhs.list).append(city, rhs.city).isEquals();
    }

}
