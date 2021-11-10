package org.example.service;

import org.example.entities.Department;
import org.example.entities.Well;

import java.util.*;

public interface Service {
    Set<String> createUniqueParams();
    TreeMap<String, HashMap<String, ArrayList<Double>>> createParamsWellsInRange(int wellStart, int wellEnd);
    Map<Department, List<Well>> createDepartmentsAndWells();
}
