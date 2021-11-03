package write;

import entity.Department;
import entity.Well;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class InConsoleAndFileLogWriterImpl implements LogWriter {
    private static final Logger LOGGER = LoggerFactory.getLogger(InConsoleAndFileLogWriterImpl.class);

    /**
     * writeUniqueParams - выводит в файл uniqueParameters.log и консоль уникальные параметры, встречающиеся в файле wellParameters.json
     */
    @Override
    public void writeUniqueParams(Set<String> setParametersName) {
            int i = 0;
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (String x : setParametersName) {
                sb.append(++i).append(". ").append(x).append("\n");
            }
            LOGGER.info(sb.toString());
    }

    /**
     * writeParamsWellsInRange - выводит в файл и консоль параметры скважин из заданного множества
     */
    @Override
    public void writeParamsWellsInRange(int wellStart, int wellEnd, TreeMap<String, HashMap<String, ArrayList<Double>>> mapWellParams) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (Map.Entry<String, HashMap<String, ArrayList<Double>>> mapEntry : mapWellParams.entrySet()) {
                sb.append(mapEntry.getKey()).append("\n");
                int k = 1;
                for (Map.Entry<String, ArrayList<Double>> entry : mapEntry.getValue().entrySet()) {
                    Double min = null, max = null, ave = null;
                    for (Double d : entry.getValue()) {
                        if (min == null) {
                            min = max = ave = d;
                        } else {
                            min = Math.min(min, d);
                            max = Math.max(max, d);
                            ave += d;
                        }
                    }
                    ave /= entry.getValue().size();
                    sb.append(String.format("%d. %s: min - %.2f, max - %.2f, ave - %.2f\n", k++, entry.getKey(), min, max, ave));
                }
                sb.append("\n");
            }
            LOGGER.info(sb.toString());
    }

    /**
     * writeDepartmentsAndWells - выводит в файл и консоль месторождения с принадлежащими им скважинами
     */
    @Override
    public void writeDepartmentsAndWells(Map<Department, List<Well>> mapDepartments) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (Map.Entry<Department, List<Well>> entry : mapDepartments.entrySet()) {
                sb.append(entry.getKey().getName()).append(":");
                if (entry.getValue().isEmpty()) {
                    sb.append(" отсутствуют");
                } else {
                    for (Well well : entry.getValue()) {
                        sb.append(" ").append(well.getName()).append(",");
                    }
                    sb.setLength(sb.length() - 1);
                    sb.append("\n");
                }
            }
            LOGGER.info(sb.toString());
    }
}
