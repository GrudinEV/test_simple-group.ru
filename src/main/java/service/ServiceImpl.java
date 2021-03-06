package service;

import entity.Department;
import entity.Well;
import entity.WellParameter;
import read.DataReader;
import read.JsonDataReaderImpl;
import write.InConsoleAndFileLogWriterImpl;
import write.LogWriter;

import java.util.*;
import java.util.stream.Collectors;

public class ServiceImpl implements Service{
    public static String INPUT_FILES_PATH = null;
    private final DataReader dataReader;
    private final LogWriter logWriter;

    public ServiceImpl(String filePath) {
        ServiceImpl.INPUT_FILES_PATH = filePath.length() > 0 ? filePath : "src/main/resources";
        this.dataReader = new JsonDataReaderImpl();
        this.logWriter = new InConsoleAndFileLogWriterImpl();
    }

    /**
     * getUniqueParams - возвращает Set<String> уникальные параметры, встречающиеся в файле wellParameters.json
     */
    @Override
    public void createUniqueParams() {
        List<WellParameter> listParameters = dataReader.readWellParameters();
        Set<String> setParametersName = new HashSet<>();
        for (WellParameter parameter : listParameters) {
            setParametersName.add(parameter.getParameterName());
        }
        logWriter.writeUniqueParams(setParametersName);
    }

    /**
     * getParamsWellsInRange - получает параметры скважин из заданного множества и отправляет на вывод в лог
     */
    @Override
    public void createParamsWellsInRange(int wellStart, int wellEnd) {
        List<WellParameter> listParameters = dataReader.readWellParameters();
        List<Well> wells = dataReader.readWells();
        wells = wells.stream().filter(x -> x.getId() >= wellStart && x.getId() <= wellEnd).collect(Collectors.toList());
        List<WellParameter> listParamsForCurrentWell;
        HashMap<String, ArrayList<Double>> mapParamsForCurrentWell;
        TreeMap<String, HashMap<String, ArrayList<Double>>> mapWellsParams = new TreeMap<>();
        for (Well well : wells) {
            mapParamsForCurrentWell = new HashMap<>();
            listParamsForCurrentWell = listParameters.stream().filter(x -> x.getWellID() == well.getId()).collect(Collectors.toList());
            for (WellParameter parameter : listParamsForCurrentWell) {
                mapParamsForCurrentWell.computeIfAbsent(parameter.getParameterName(), v -> new ArrayList<>()).add(parameter.getValue());
            }
            mapWellsParams.put(well.getName(), mapParamsForCurrentWell);
        }
        logWriter.writeParamsWellsInRange(wellStart, wellEnd, mapWellsParams);
    }

    /**
     * getDepartmentsAndWells - формирует мапу месторождений и их скважини и отправляет на вывод в лог
     */
    @Override
    public void createDepartmentsAndWells() {
        List<Department> departments = dataReader.readDepartments();
        List<Well> wells = dataReader.readWells();
        Map<Department, List<Well>> mapDepartmentsAndWells = new HashMap<>();
        for (Department department : departments) {
            mapDepartmentsAndWells.put(department, new ArrayList<Well>());
        }
        Department unknownDepartment = new Department();
        unknownDepartment.setName("Неизвестное месторождение");
        mapDepartmentsAndWells.put(unknownDepartment, new ArrayList<Well>());
        for (Well well : wells) {
            if (well.getCoordX() == null || well.getCoordY() == null) {
                mapDepartmentsAndWells.get(unknownDepartment).add(well);
            } else {
                boolean wellIsAdded = false;
                for (Department department : departments) {
                    if (Math.sqrt(Math.pow(department.getCoordX() - well.getCoordX(), 2) + Math.pow(department.getCoordY() - well.getCoordY(), 2)) <= department.getRadius()) {
                        mapDepartmentsAndWells.get(department).add(well);
                        wellIsAdded = true;
                    }
                }
                if (!wellIsAdded) {
                    mapDepartmentsAndWells.get(unknownDepartment).add(well);
                }
            }
        }
        logWriter.writeDepartmentsAndWells(mapDepartmentsAndWells);
    }
}
