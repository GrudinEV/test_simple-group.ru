package write;

import entity.Department;
import entity.Well;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class InConsoleAndFileLogWriterImpl implements LogWriter {
    private static final Logger LOGGER = LoggerFactory.getLogger(InConsoleAndFileLogWriterImpl.class);

    /**
     * writeUniqueParams - выводит в файл uniqueParameters.log и консоль уникальные параметры, встречающиеся в файле wellParameters.json
     */
    @Override
    public void writeUniqueParams(Set<String> setParametersName) {
        try (PrintStream printStream = new PrintStream("src/main/resources/output/uniqueParameters.log")) {
            int i = 0;
            for (String x : setParametersName) {
                printStream.println(++i + ". " + x);
                System.out.println(i + ". " + x);
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Запись в файл не удалась!", e);
        }
    }

    /**
     * writeParamsWellsInRange - выводит в файл и консоль параметры скважин из заданного множества
     */
    @Override
    public void writeParamsWellsInRange(int wellStart, int wellEnd, TreeMap<String, HashMap<String, ArrayList<Double>>> mapWellParams) {
        try (PrintStream printStream = new PrintStream("src/main/resources/output/paramsFrom" + wellStart + "To" + wellEnd + "Wells.log")) {
            for (Map.Entry<String, HashMap<String, ArrayList<Double>>> mapEntry : mapWellParams.entrySet()) {
                System.out.println(mapEntry.getKey());
                printStream.println(mapEntry.getKey());
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
                    System.out.printf("%d. %s: min - %.2f, max - %.2f, ave - %.2f\n", k, entry.getKey(), min, max, ave);
                    printStream.printf("%d. %s: min - %.2f, max - %.2f, ave - %.2f\n", k++, entry.getKey(), min, max, ave);
                }
                printStream.println();
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Запись в файл не удалась!", e);
        }
    }

    /**
     * writeDepartmentsAndWells - выводит в файл и консоль месторождения с принадлежащими им скважинами
     */
    @Override
    public void writeDepartmentsAndWells(Map<Department, List<Well>> mapDepartments) {
        try (PrintStream printStream = new PrintStream(("src/main/resources/output/departmentsAndWells.log"))) {
            for (Map.Entry<Department, List<Well>> entry : mapDepartments.entrySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append(entry.getKey().getName()).append(":");
                if (entry.getValue().isEmpty()) {
                    sb.append(" отсутствуют");
                } else {
                    for (Well well : entry.getValue()) {
                        sb.append(" ").append(well.getName()).append(",");
                    }
                    sb.setLength(sb.length() - 1);
                }
                printStream.println(sb);
                System.out.println(sb);
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Запись в файл не удалась!", e);
        }
    }
}
