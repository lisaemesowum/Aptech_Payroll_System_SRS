package payrollSystem.ConsoleApp;

import payrollSystem.DataAccessObject.EmployeeDAO;
import payrollSystem.DataAccessObject.PayrollRecordDAO;
import payrollSystem.EmployeeImpl.EmployeeDAOImpl;
import payrollSystem.Enum.Department;
import payrollSystem.Models.Employee;
import payrollSystem.PayrollServiceImple.PayrollServiceImple;
import payrollSystem.Services.Payrollmanagement;


import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleApp {
    private  static final EmployeeDAO employeeDAO = new EmployeeDAOImpl();  //employeeDAO → handles all employee data in the CSV file
    private  static final  PayrollRecordDAO payrollRecordDAO = new PayrollServiceImple();  //handles all payroll records in the CSV file
    private  static final Payrollmanagement payrollManagement = new Payrollmanagement(payrollRecordDAO);  //contains business logic for payroll operations like Payrollmanagement can create, update, or fetch payroll records using the DAO.



    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        while(true){
            displayMeny();
            System.out.println("Enter Choice");
            int choice = scan.nextInt();
            scan.nextLine();

            switch(choice){
                case 1 -> {
                    System.out.print("Enter Employee ID: ");
                    String id = scan.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scan.nextDouble();
                    scan.nextLine();
                    System.out.print("Enter Department (HR, IT, SALES, FINANCE): ");
                    String deptInput = scan.nextLine();
                    Department dept = Department.valueOf(deptInput.toUpperCase());
                    LocalDate.now();
                    Employee newemployee = new Employee(id,name, dept, salary);
                    employeeDAO.addEmployee(newemployee);
                    System.out.println("✅ Employee added successfully!");
                }

            }
        }


    }

    private static void displayMeny() {
    }


}
