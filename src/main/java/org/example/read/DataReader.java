package org.example.read;

import org.example.entities.Department;
import org.example.entities.Well;
import org.example.entities.WellParameter;

import java.util.List;

public interface DataReader {
    List<Department> readDepartments();
    List<Well> readWells();
    List<WellParameter> readWellParameters();
}
