package org.example.read;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Department;
import org.example.entity.Well;
import org.example.entity.WellParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.service.ServiceImpl;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonDataReaderImpl implements DataReader{
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonDataReaderImpl.class);

    /**
     * readDepartments - возвращает List<Department> месторождения, встречающиеся в файле departments.json
     */
    @Override
    public List<Department> readDepartments() {
        List<Department> list = null;
        try (FileInputStream inputStream = new FileInputStream(/*"src/main/resources/departments.json"*/ServiceImpl.INPUT_FILES_PATH + "/departments.json")) {
            list = Arrays.asList(new ObjectMapper().readValue(inputStream, Department[].class));
        } catch (FileNotFoundException e) {
            LOGGER.error("Файл \"departments.json\" не найден!", e);
        } catch (IOException e) {
            LOGGER.error("Ошибка чтения!", e);
        }
        return list;
    }

    /**
     * readWells - возвращает List<Well> скважины, встречающиеся в файле wells.json
     */
    @Override
    public List<Well> readWells() {
        List<Well> list = null;
        try (FileInputStream inputStream = new FileInputStream(/*"src/main/resources/wells.json"*/ServiceImpl.INPUT_FILES_PATH + "/wells.json")) {
            list = Arrays.asList(new ObjectMapper().readValue(inputStream, Well[].class));
        } catch (FileNotFoundException e) {
            LOGGER.error("Файл \"wells.json\" не найден!", e);
        } catch (IOException e) {
            LOGGER.error("Ошибка чтения!", e);
        }
        return list;
    }

    /**
     * getListWellParameters - возвращает List<WellParameter> параметры скважин, встречающиеся в файле wellParameters.json
     */
    @Override
    public List<WellParameter> readWellParameters() {
        List<WellParameter> list = null;
        try (FileInputStream inputStream = new FileInputStream(/*"src/main/resources/wellParameters.json"*/ServiceImpl.INPUT_FILES_PATH + "/wellParameters.json")) {
            list = Arrays.asList(new ObjectMapper().readValue(inputStream, WellParameter[].class));
        } catch (FileNotFoundException e) {
            LOGGER.error("Файл \"wellParameters.json\" не найден!", e);
        } catch (IOException e) {
            LOGGER.error("Ошибка чтения!", e);
        }
        return list;
    }
}
