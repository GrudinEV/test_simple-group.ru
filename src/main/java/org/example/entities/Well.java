package org.example.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Table;

@Table(name = "well")
public class Well {
    @JsonProperty("id") private int id;
    @JsonProperty("name") private String name;
    @JsonProperty("x") private Double coordX;
    @JsonProperty("y") private Double coordY;

    public Well() {
    }

    public Well(int id, String name, Double coordX, Double coordY) {
        this.id = id;
        this.name = name;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCoordX() {
        return coordX;
    }

    public void setCoordX(Double coordX) {
        this.coordX = coordX;
    }

    public Double getCoordY() {
        return coordY;
    }

    public void setCoordY(Double coordY) {
        this.coordY = coordY;
    }

    @Override
    public String toString() {
        return "Well{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                '}';
    }
}
