package payrollSystem.DataAccessObject;

import payrollSystem.Models.Employee;

import java.util.List;

                         //DAO is to  take care of those functional requirements at the file level for storing data in the file qnd removing

public interface EmployeeDAO {
    void addEmployee( Employee employee);
    //    we need to read all the employees into a list find the employee matching id and update the details and rewrite the entire file with the updated file
    void updateEmployee(Employee updatedEmployee);
    void deleteEmployee(String id);
    List<Employee> viewAllEmployees();
}
