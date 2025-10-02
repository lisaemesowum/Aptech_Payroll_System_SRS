package payrollSystem.EmployeeImpl;

import payrollSystem.DataAccessObject.EmployeeDAO;
import payrollSystem.Enum.Department;
import payrollSystem.Models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//EmployeeDAOImpl implements the EmployeeDAO interface   // FILE_NAME is the CSV file where employee data is stored
//CRUD operations

public class EmployeeDAOImpl  implements EmployeeDAO {
    private final String FILE_NAME = "employees.csv";  //CSV (Comma-Separated Values)

    public void addEmployee(Employee employee) {
      try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))){  //opens the file in append mode
          writer.write(employee.getId() + ", " +
                  employee.getName() + " , " +
                  employee.getDepartment() + " , " +
                  employee.getSalary());  //fetch the employee’s data. separates with a comma
          writer.newLine();//moves to the next line for the next employee.
          writer.close();
      }catch (IOException e){
          System.out.println("❌ Error: Could not write to the file.");
      }
    }


    //    we need to read all the employees into a list find the employee matching id and update the details and rewrite the entire file with the updated file
    @Override
    public void updateEmployee(Employee updatedEmployee) {
        List<Employee> employees = viewAllEmployees(); // step 1 full list because a CSV file cannot be edited line-by-line
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){  //overwrite the old file with updated data.
            for (Employee emp : employees ){
                if(emp.getId().equals(updatedEmployee.getId())){   //Compares IDs to find the employee to update.
                    emp = updatedEmployee;   //replace matching employee
                }
                // write back to the file
                writer.write(updatedEmployee.getId() + "," + updatedEmployee.getName() + updatedEmployee.getDepartment() + "," + updatedEmployee.getSalary());
                writer.newLine();


                // if id not found
                boolean found = false;
                if(emp.getId().equals(updatedEmployee.getId())){
                    emp = updatedEmployee;
                    found = true;
                }
                if(!found) System.out.println("Employee ID not found");
            }
            System.out.println("✅ Employee updated successfully.");
        }catch (IOException e){
            System.out.println("❌ Error: Could not update the file.");
        }

    }



    @Override
    public void deleteEmployee(String id) {
    List<Employee> employees = viewAllEmployees();
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
        for(Employee emp : employees){
            if(!emp.getId().equals(id)){   // Step 2: skip the one to delete
                writer.write(emp.getId() + "," + emp.getName() + "," + emp.getDepartment() + "," + emp.getSalary());
                writer.newLine();
            }
        }
        System.out.println("✅ Employee deleted successfully.");
    }catch (IOException e){
        System.out.println("❌ Error: Could not delete from the file.");
    }

    }

    @Override
    public List<Employee> viewAllEmployees() {
       //list to store employees
        List<Employee> employees = new ArrayList<>();

        //Read the file line by line
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine()) != null){  //Reads one line at a time until the end of the file.
                //spit each line
                String[] data = line.split(",");
                // the data is 4 that will be in the file like id,name etc
                if(data.length == 4){
                    String id = data[0];
                    String name = data[1];
                    Department department = Department.valueOf(data[2]);   // converting string to enum
                    double salary = Double.parseDouble(data[3]);   //Double.parseDouble converts it to a numeric double, so you can do calculations.
                    employees.add(new Employee(id,name,department,salary));
                }

            }
        } catch (Exception e) {
            System.out.println();
        }
        return employees; // return all employees
    }

}
