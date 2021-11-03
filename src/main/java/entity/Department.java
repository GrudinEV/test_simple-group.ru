package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Department {
    @JsonProperty("name") private String name;
    @JsonProperty("x") private Double coordX;
    @JsonProperty("y") private Double coordY;
    @JsonProperty("radius") private Double radius;

    public Department() {
    }

    public Department(String name, Double coordX, Double coordY, Double radius) {
        this.name = name;
        this.coordX = coordX;
        this.coordY = coordY;
        this.radius = radius;
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

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                ", radius=" + radius +
                '}';
    }
}
