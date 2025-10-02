package payrollSystem.DataAccessObject;

import payrollSystem.Enum.Department;
import payrollSystem.Models.Employee;

import java.util.List;

                         //DAO is to  take care of those functional requirements at the file level for storing data in the file qnd removing

public interface EmployeeDAO {
    void addEmployee(Employee employee );
    void updateEmployee(Employee updatedEmployee);
    void deleteEmployee(String id);
    List<Employee> viewAllEmployees();
}
