package com.pb.riskanalysisforsmb.identity.input;

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
        "Input"
})
public class IdentifyRiskInputBody {

    @JsonProperty("Input")
    private Input input;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     */
    public IdentifyRiskInputBody() {
    }

    /**
     * @param input
     */
    public IdentifyRiskInputBody(Input input) {
        super();
        this.input = input;
    }

    @JsonProperty("Input")
    public Input getInput() {
        return input;
    }

    @JsonProperty("Input")
    public void setInput(Input input) {
        this.input = input;
    }

    public IdentifyRiskInputBody withInput(Input input) {
        this.input = input;
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

    public IdentifyRiskInputBody withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("input", input).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(input).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IdentifyRiskInputBody) == false) {
            return false;
        }
        IdentifyRiskInputBody rhs = ((IdentifyRiskInputBody) other);
        return new EqualsBuilder().append(input, rhs.input).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
