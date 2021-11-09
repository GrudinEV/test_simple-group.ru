package org.example.adddata;

import org.example.entities.Department;
import org.example.entities.Well;
import org.example.entities.WellParameter;
import org.example.read.DataReader;
import org.example.read.JsonDataReaderImpl;
import org.example.repositories.DepartmentRepository;
import org.example.repositories.WellParameterRepository;
import org.example.repositories.WellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddedDataFromJsonToBd {
    private final DataReader dataReader = new JsonDataReaderImpl();
    private final DepartmentRepository departmentRepository;
    private final WellRepository wellRepository;
    private final WellParameterRepository wellParameterRepository;

    @Autowired
    public AddedDataFromJsonToBd(WellParameterRepository wellParameterRepository,
                                 WellRepository wellRepository,
                                 DepartmentRepository departmentRepository) {
        this.wellParameterRepository = wellParameterRepository;
        this.departmentRepository = departmentRepository;
        this.wellRepository = wellRepository;
    }

    public void insertDepartments() {
        List<Department> departments = dataReader.readDepartments();
        departmentRepository.saveAll(departments);
        departmentRepository.flush();
    }

    public void insertWells() {
        List<Well> wells = dataReader.readWells();
        List<Department> departments = departmentRepository.findAll();
        for (Well well : wells) {
            if (well.getCoordX() != null && well.getCoordY() != null) {
                for (Department department : departments) {
                    if (Math.sqrt(Math.pow(department.getCoordX() - well.getCoordX(), 2) + Math.pow(department.getCoordY() - well.getCoordY(), 2)) <= department.getRadius()) {
                        well.setDepartmentId(department.getId());
                        break;
                    }
                }
            }
            wellRepository.save(well);
            wellRepository.flush();
        }
    }

    public void insertWellsParameter() {
        List<WellParameter> wellParameters = dataReader.readWellParameters();
        wellParameterRepository.saveAll(wellParameters);
        wellParameterRepository.flush();
    }
}
