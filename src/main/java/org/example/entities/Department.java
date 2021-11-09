package org.example.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
public class Department {
    @Id
    @Column(name = "DEPARTMENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DEPARTMENT_NAME") @JsonProperty("name") private String name;
    @Column(name = "COORD_X") @JsonProperty("x") private Double coordX;
    @Column(name = "COORD_Y") @JsonProperty("y") private Double coordY;
    @Column(name = "RADIUS") @JsonProperty("radius") private Double radius;

    public Department() {
    }

    public Department(int id, String name, Double coordX, Double coordY, Double radius) {
        this.id = id;
        this.name = name;
        this.coordX = coordX;
        this.coordY = coordY;
        this.radius = radius;
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

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (coordX != null ? !coordX.equals(that.coordX) : that.coordX != null) return false;
        if (coordY != null ? !coordY.equals(that.coordY) : that.coordY != null) return false;
        return radius != null ? radius.equals(that.radius) : that.radius == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (coordX != null ? coordX.hashCode() : 0);
        result = 31 * result + (coordY != null ? coordY.hashCode() : 0);
        result = 31 * result + (radius != null ? radius.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                ", radius=" + radius +
                '}';
    }
}
