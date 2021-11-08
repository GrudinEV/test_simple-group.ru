package org.example.write;

import org.example.entity.Department;
import org.example.entity.Well;

import java.util.*;

public interface LogWriter {
    void writeUniqueParams(Set<String> setParametersName);
    void writeParamsWellsInRange(int wellStart, int wellEnd, TreeMap<String, HashMap<String, ArrayList<Double>>> mapWellParams);
    void writeDepartmentsAndWells(Map<Department, List<Well>> mapDepartments);
}
