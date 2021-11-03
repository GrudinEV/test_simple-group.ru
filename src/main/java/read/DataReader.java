package read;

import entity.Department;
import entity.Well;
import entity.WellParameter;

import java.util.List;

public interface DataReader {
    List<Department> readDepartments();
    List<Well> readWells();
    List<WellParameter> readWellParameters();
}
