import service.Service;
import service.ServiceImpl;

public class App {

    public static void main(String[] args) {
        Service service;
        if (args.length > 0) {
            service = new ServiceImpl(args[0]);
        } else {
            service = new ServiceImpl("");
        }
        service.createUniqueParams();
        service.createParamsWellsInRange(10, 12);
        service.createDepartmentsAndWells();
    }
}
