package org.example.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "WELL")
public class Well {
    @Id
    @Column(name = "WELL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id") private int id;
    @Column(name = "WELL_NAME") @JsonProperty("name") private String name;
    @Column(name = "COORD_X") @JsonProperty("x") private Double coordX;
    @Column(name = "COORD_Y") @JsonProperty("y") private Double coordY;
    @Column(name = "DEPARTMENT_ID") private Integer departmentId;

    public Well() {
    }

    public Well(int id, String name, Double coordX, Double coordY) {
        this.id = id;
        this.name = name;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
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
                ", departmentId=" + departmentId +
                '}';
    }
}
