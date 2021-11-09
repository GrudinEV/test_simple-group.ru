package org.example.service;

import org.example.adddata.AddedDataFromJsonToBd;
import org.example.entities.WellParameter;
import org.example.read.DataReader;
import org.example.repositories.WellParameterRepository;
import org.example.write.LogWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ServiceImpl implements Service{
    public static String INPUT_FILES_PATH = "src/main/resources";
    private final DataReader dataReader;
    private final LogWriter logWriter;
    private final AddedDataFromJsonToBd addedDataFromJsonToBd;
    private final WellParameterRepository wellParameterRepository;

    @Autowired
    public ServiceImpl(DataReader dataReader, LogWriter logWriter,
                       AddedDataFromJsonToBd addedDataFromJsonToBd,
                       WellParameterRepository wellParameterRepository) {
        this.dataReader = dataReader;
        this.logWriter = logWriter;
        this.addedDataFromJsonToBd = addedDataFromJsonToBd;
        this.wellParameterRepository = wellParameterRepository;
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void doSomethingAfterStartup() {
//        System.out.println("hello world, I have just started up");
//        addedDataFromJsonToBd.insertDepartments();
//        addedDataFromJsonToBd.insertDepartments();
//        addedDataFromJsonToBd.insertWells();
//        addedDataFromJsonToBd.insertWellsParameter();
//    }

    public void initBD() {
        addedDataFromJsonToBd.insertDepartments();
        addedDataFromJsonToBd.insertWells();
        addedDataFromJsonToBd.insertWellsParameter();
    }

    /**
     * getUniqueParams - возвращает Set<String> уникальные параметры, встречающиеся в файле wellParameters.json
     */
    @Override
    public void createUniqueParams() {
        List<WellParameter> listParameters = wellParameterRepository.findAll();
        System.out.println(listParameters.size());
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
//        List<WellParameter> listParameters = dataReader.readWellParameters();
//        List<Well> wells = dataReader.readWells();
//        wells = wells.stream().filter(x -> x.getId() >= wellStart && x.getId() <= wellEnd).collect(Collectors.toList());
//        List<WellParameter> listParamsForCurrentWell;
//        HashMap<String, ArrayList<Double>> mapParamsForCurrentWell;
//        TreeMap<String, HashMap<String, ArrayList<Double>>> mapWellsParams = new TreeMap<>();
//        for (Well well : wells) {
//            mapParamsForCurrentWell = new HashMap<>();
//            listParamsForCurrentWell = listParameters.stream().filter(x -> x.getWellID() == well.getId()).collect(Collectors.toList());
//            for (WellParameter parameter : listParamsForCurrentWell) {
//                mapParamsForCurrentWell.computeIfAbsent(parameter.getParameterName(), v -> new ArrayList<>()).add(parameter.getValue());
//            }
//            mapWellsParams.put(well.getName(), mapParamsForCurrentWell);
//        }
//        logWriter.writeParamsWellsInRange(wellStart, wellEnd, mapWellsParams);
    }

    /**
     * getDepartmentsAndWells - формирует мапу месторождений и их скважини и отправляет на вывод в лог
     */
    @Override
    public void createDepartmentsAndWells() {
//        List<Department> departments = dataReader.readDepartments();
//        List<Well> wells = dataReader.readWells();
//        Map<Department, List<Well>> mapDepartmentsAndWells = new HashMap<>();
//        for (Department department : departments) {
//            mapDepartmentsAndWells.put(department, new ArrayList<Well>());
//        }
//        Department unknownDepartment = new Department();
//        unknownDepartment.setName("Неизвестное месторождение");
//        mapDepartmentsAndWells.put(unknownDepartment, new ArrayList<Well>());
//        for (Well well : wells) {
//            if (well.getCoordX() == null || well.getCoordY() == null) {
//                mapDepartmentsAndWells.get(unknownDepartment).add(well);
//            } else {
//                boolean wellIsAdded = false;
//                for (Department department : departments) {
//                    if (Math.sqrt(Math.pow(department.getCoordX() - well.getCoordX(), 2) + Math.pow(department.getCoordY() - well.getCoordY(), 2)) <= department.getRadius()) {
//                        mapDepartmentsAndWells.get(department).add(well);
//                        wellIsAdded = true;
//                    }
//                }
//                if (!wellIsAdded) {
//                    mapDepartmentsAndWells.get(unknownDepartment).add(well);
//                }
//            }
//        }
//        logWriter.writeDepartmentsAndWells(mapDepartmentsAndWells);
    }
}
