package payrollSystem.Models;

import payrollSystem.Enum.Department;

public class Employee {
    private  String id;
    private  String Name;
    private Department department;
    private double salary;

    public Employee(String id,String Name,Department department,double salary){
        this.id = id;
        this.Name = Name;
        this.department = department;
        this.salary = salary;
    }
//    getter  method

    public String getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
//    setter method

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
//    to string method

    @Override
    public String toString() {
        return "Employee [" +
                "Id='" + id + '\'' +
                ",Name='" + Name + '\'' +
                ", Department=" + department +
                ", Salary=" + salary +
                ']';
    }
}
