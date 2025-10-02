package payrollSystem.Models;

import java.time.LocalDate;

public class PayrollRecord {
    private String recordId;  //Unique ID for each payroll record.
    private String employeeId;  //Link to Employee
    private double basicSalary;   // Base salary (from Employee).
    private double allowances;  // Extra payments
    private double deductions; // Tax, pension,
    private double netSalary;  //the amount of money an individual receives after all mandatory deductions, such as taxes
    private LocalDate payDate;   // date of this payroll


    public PayrollRecord(String recordId, String employeeId, double basicSalary, double allowances, double deductions, double netSalary, LocalDate payDate) {
        this.recordId = recordId;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
        this.allowances = allowances;
        this.deductions = deductions;
        this.netSalary = calculateNetSalary();  // calculate automatically
        this.payDate = payDate;
    }

    // Calculate net salary
    private double calculateNetSalary() {
        return basicSalary + allowances - deductions;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getAllowances() {
        return allowances;
    }

    public void setAllowances(double allowances) {
        this.allowances = allowances;
        this.netSalary = calculateNetSalary();   // update net salary
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(int deductions) {
        this.deductions = deductions;
        this.netSalary = calculateNetSalary();
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "PayrollRecord[" +
                "RecordId ='" + recordId + '\'' +
                ", EmployeeId ='" + employeeId + '\'' +
                ", BasicSalary =" + basicSalary +
                ", Allowances =" + allowances +
                ", Deductions =" + deductions +
                ", NetSalary =" + netSalary +
                ", PayDate =" + payDate +
                ']';
    }
}
