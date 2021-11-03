package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WellParameter {
    @JsonProperty("wellId") private long wellID;
    @JsonProperty("parameterName") private String parameterName;
    @JsonProperty("value") private double value;

    public WellParameter() {
    }

    public WellParameter(long wellID, String parameterName, double value) {
        this.wellID = wellID;
        this.parameterName = parameterName;
        this.value = value;
    }

    public long getWellID() {
        return wellID;
    }

    public void setWellID(long wellID) {
        this.wellID = wellID;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "WellParameter{" +
                "wellID=" + wellID +
                ", parameterName='" + parameterName + '\'' +
                ", value=" + value +
                '}';
    }
}
