public class Main {

    public static void main(String[] args) {
        Employee employee = new Programmer();
        employee.doWork();
        employee.tellWithEmployyes();

        employee = new HRManager();
        employee.doWork();
        employee.tellWithEmployyes();
        employee.log();

    }
}
