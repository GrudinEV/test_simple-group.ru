import service.Service;
import service.ServiceImpl;

public class App {
    private static Service service;

    public static void main(String[] args) {
        service = new ServiceImpl();
        service.createUniqueParams();
        service.createParamsWellsInRange(10, 12);
        service.createDepartmentsAndWells();
    }
}
