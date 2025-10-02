package payrollSystem.DataAccessObject;

import payrollSystem.Models.PayrollRecord;

import java.util.List;

public interface PayrollRecordDAO {

    void addPayrollRecord(PayrollRecord record);  // Add a new payroll record
    void deletePayrollRecord(String recordId);               // Delete record by ID
    void updatePayrollRecord(PayrollRecord record);          // Update existing record
    List<PayrollRecord> viewAllPayrollRecords();             // Get all payroll records
    PayrollRecord getPayrollRecordById(String recordId);     // Get a single record

}
