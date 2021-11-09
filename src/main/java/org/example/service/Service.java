package org.example.service;

public interface Service {
    void initBD();
    void createUniqueParams();
    void createParamsWellsInRange(int wellStart, int wellEnd);
    void createDepartmentsAndWells();
}
