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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (coordX != null ? !coordX.equals(that.coordX) : that.coordX != null) return false;
        if (coordY != null ? !coordY.equals(that.coordY) : that.coordY != null) return false;
        return radius != null ? radius.equals(that.radius) : that.radius == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (coordX != null ? coordX.hashCode() : 0);
        result = 31 * result + (coordY != null ? coordY.hashCode() : 0);
        result = 31 * result + (radius != null ? radius.hashCode() : 0);
        return result;
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
