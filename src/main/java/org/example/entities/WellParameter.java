package org.example.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "WELL_PARAMETER")
public class WellParameter {
    @Id
    @Column(name = "WELL_PARAMETER_ID")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id;
    @Column(name = "WELL_ID") @JsonProperty("wellId") private int wellID;
    @Column(name = "PARAMETER_NAME") @JsonProperty("parameterName") private String parameterName;
    @Column(name = "PARAMETER_VALUE") @JsonProperty("value") private double value;

    public WellParameter() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getWellID() {
        return wellID;
    }

    public void setWellID(int wellID) {
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
                "id=" + id +
                ", wellID=" + wellID +
                ", parameterName='" + parameterName + '\'' +
                ", value=" + value +
                '}';
    }
}
