package com.pb.riskanalysisforsmb.identity;

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
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Output"
})
public class IdentifyRiskResponse {

    @JsonProperty("Output")
    private List<Output> output = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     */
    public IdentifyRiskResponse() {
    }

    /**
     * @param output
     */
    public IdentifyRiskResponse(List<Output> output) {
        super();
        this.output = output;
    }

    @JsonProperty("Output")
    public List<Output> getOutput() {
        return output;
    }

    @JsonProperty("Output")
    public void setOutput(List<Output> output) {
        this.output = output;
    }

    public IdentifyRiskResponse withOutput(List<Output> output) {
        this.output = output;
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

    public IdentifyRiskResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("output", output).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(output).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IdentifyRiskResponse) == false) {
            return false;
        }
        IdentifyRiskResponse rhs = ((IdentifyRiskResponse) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(output, rhs.output).isEquals();
    }

}
