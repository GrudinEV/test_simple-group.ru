package org.example.read;

import org.example.entity.Department;
import org.example.entity.Well;
import org.example.entity.WellParameter;

import java.util.List;

public interface DataReader {
    List<Department> readDepartments();
    List<Well> readWells();
    List<WellParameter> readWellParameters();
}
