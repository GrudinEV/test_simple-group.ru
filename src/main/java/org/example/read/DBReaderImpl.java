package org.example.read;

import org.example.entities.Department;
import org.example.entities.Well;
import org.example.entities.WellParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBReaderImpl implements DataReader{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DBReaderImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Department> readDepartments() {
        List<Department> departments = jdbcTemplate.query("SELECT department_id, department_name,coord_x, coord_y, radius FROM Department", (rs,i) ->
                new Department(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5)));
        return departments;
    }

    @Override
    public List<Well> readWells() {
        List<Well> wells = jdbcTemplate.query("SELECT well_id, well_name, coord_x, coord_y FROM Well", (rs,i) ->
                new Well(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
        return wells;
    }

    @Override
    public List<WellParameter> readWellParameters() {
        List<WellParameter> wellParameters = jdbcTemplate.query("SELECT well_id, parameter_name, parameter_value FROM WellParameter", (rs,i) ->
                new WellParameter(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
        return wellParameters;
    }
}
