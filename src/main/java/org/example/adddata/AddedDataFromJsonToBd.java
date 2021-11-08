package org.example.adddata;

import org.example.entity.Department;
import org.example.entity.Well;
import org.example.entity.WellParameter;
import org.example.read.DataReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AddedDataFromJsonToBd {
    private final JdbcTemplate jdbcTemplate;
    private final DataReader dataReader;

    @Autowired
    public AddedDataFromJsonToBd(JdbcTemplate jdbcTemplate, DataReader dataReader) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataReader = dataReader;
    }

    public void insertDepartments() {
        List<Department> departments = dataReader.readDepartments();
        for (Department department : departments) {
            jdbcTemplate.update("INSERT INTO Department (department_name, coord_x, coord_y, radius) VALUES (?, ?, ?, ?)",
                    department.getName(), department.getCoordX(), department.getCoordY(), department.getRadius());
        }
    }

    public void insertWells() {
        List<Well> wells = dataReader.readWells();
        List<Department> departments = jdbcTemplate.query("SELECT * FROM Department", (rs,i) ->
                new Department(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5)));
        for (Well well : wells) {
            Integer departmentId = null;
            if (well.getCoordX() != null && well.getCoordY() != null) {
                for (Department department : departments) {
                    if (Math.sqrt(Math.pow(department.getCoordX() - well.getCoordX(), 2) + Math.pow(department.getCoordY() - well.getCoordY(), 2)) <= department.getRadius()) {
                        departmentId = department.getId();
                    }
                }
            }
            jdbcTemplate.update("INSERT INTO Well (well_name, coord_x, coord_y, department_id) VALUES (?, ?, ?, ?)",
                    well.getName(), well.getCoordX(), well.getCoordY(), departmentId);
        }
    }

    public void insertWellsParameter() {
        List<WellParameter> wellParameters = dataReader.readWellParameters();
        jdbcTemplate.batchUpdate("INSERT INTO WellParameter (well_id, parameter_name, parameter_value) VALUES (?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        WellParameter wellParameter = wellParameters.get(i);
                        ps.setInt(1, wellParameter.getWellID());
                        ps.setString(2, wellParameter.getParameterName());
                        ps.setDouble(3, wellParameter.getValue());
                    }

                    @Override
                    public int getBatchSize() {
                        return wellParameters.size();
                    }
                });
    }
}
