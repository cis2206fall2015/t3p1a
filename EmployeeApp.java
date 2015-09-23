package employeefile;

import java.util.Scanner;

/**
 *
 * @author Dylan Lozo and Kyle Zindell 
 */
public class EmployeeApp {

    EmployeeDAO ipList = new EmployeeDAO();
    Scanner sc = new Scanner(System.in);

    public EmployeeApp() {
        menuLoop();
    }

    private void menuLoop() {
        int id, numRequest;
        String ipAddress, dateAdded;
        String choice = "1";
        while (!choice.equals("0")) {
            System.out.println("\nIp Address App");
            System.out.println("0 = Quit");
            System.out.println("1 = List All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Record");
            System.out.println("4 = Update Record");
            System.out.println("5 = Delete Record");
            choice = Validator.getLine(sc, "Number of choice: ", "^[0-5]$");

            switch (choice) {
                case "1":
                    System.out.println(ipList.toString());
                    break;
                case "2":
                    id = Validator.getInt(sc, "New User ID: ");
                    ipAddress = Validator.getLine(sc, "Ip Address: ");
                    homePhone = Validator.getLine(sc, "Home phone number: ");
                    salary = Validator.getDouble(sc, "Yearly salary: ");
                    ipList.createRecord(new Employee(id, last, first, homePhone, salary));
                    break;
                case "3":
                    id = Validator.getInt(sc, "Employee id to retrieve: ");
                    System.out.println(ipList.retrieveRecord(id));
                    break;
                case "4":
                    id = Validator.getInt(sc, "Employee ID to update: ");
                    last = Validator.getLine(sc, "Last name: ");
                    first = Validator.getLine(sc, "First name: ");
                    homePhone = Validator.getLine(sc, "Home phone number: ");
                    salary = Validator.getDouble(sc, "Yearly salary: ");
                    ipList.updateRecord(new Employee(id, last, first, homePhone, salary));
                    break;
                case "5":
                    id = Validator.getInt(sc, "Employee ID to delete: ");
                    System.out.println(ipList.retrieveRecord(id));
                    String ok = Validator.getLine(sc, "Deleter this record? (y/n) ", "^[yYnN]$");
                    if (ok.equalsIgnoreCase("Y")) {
                        ipList.deleteRecord(id);
                    }
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new EmployeeApp();
    }
}
