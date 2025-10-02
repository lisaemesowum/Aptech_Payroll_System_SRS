package payrollSystem.Services;

import payrollSystem.Enum.Department;
import payrollSystem.Models.Employee;

import java.util.List;

// Provides business logic for payroll operations calculates the payroll
public class Payrollmanagement {

                 //calculate the total of salaries
    public double CalculateTotalPayroll(List<Employee> employees){
        double total = 0.0;
//        loop through
        for(Employee employee : employees){
            total += employee.getSalary();
        }
        return total;
    }
//                        calculate the   payroll for department
    public double CalculateDepartmentPayroll(List<Employee> employees ,Department dept){
        double total = 0.0;
        for(Employee employee : employees){
            if(employee.getDepartment() == dept){
                total += employee.getSalary();
            }
        }
        return  total;
    }

//    payroll report in text
    public  String generatePayrollReport(List<Employee> employees){
        StringBuilder reports  = new StringBuilder("➖➖➖➖➖➖General Payroll Reports➖➖➖➖➖➖➖");

//        totAL payrol
        reports.append("Total Payroll").append(CalculateTotalPayroll(employees)).append("\n");

        //department payroll
        for(Department dept : Department.values()){
            reports.append(dept).append(" Payroll: ")
                    .append(CalculateTotalPayroll(employees)).append("\n");
        }
        return reports.toString();
    }
}
