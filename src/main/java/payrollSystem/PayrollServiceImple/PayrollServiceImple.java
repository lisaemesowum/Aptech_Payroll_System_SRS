package payrollSystem.PayrollServiceImple;

import payrollSystem.DataAccessObject.PayrollRecordDAO;
import payrollSystem.Models.PayrollRecord;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PayrollServiceImple implements PayrollRecordDAO {
    private final String FILE_NAME = "payrollRecords.csv";

    @Override
    public void addPayrollRecord(PayrollRecord record) {
        //Writes all fields of PayrollRecord separated by commas (CSV format).

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME,true))){
            writer.write(record.getRecordId() + "," +
                    record.getEmployeeId() + "," +
                    record.getBasicSalary() + "," +
                    record.getAllowances() + "," +
                    record.getDeductions() +  "," +
                    record.getNetSalary() + "," +
                    record.getPayDate());
            writer.newLine();
        }catch(IOException e){
            System.out.println("❌ Error: Could not write payroll record.");
        }
    }

    @Override
    public void deletePayrollRecord(String recordId) {
        List<PayrollRecord> records = viewAllPayrollRecords();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            for(PayrollRecord payrollRecord : records){
                if(!payrollRecord.getRecordId().equals(recordId)){
                    writer.write(payrollRecord.getRecordId() + "," +
                          payrollRecord.getEmployeeId() + "," +
                          payrollRecord.getBasicSalary() + "," +
                          payrollRecord.getAllowances() + "," +
                          payrollRecord.getDeductions() + "," +
                          payrollRecord.getNetSalary() + "," +
                          payrollRecord.getPayDate());
                    writer.newLine();
                }
            }

        }catch (IOException e){
            System.out.println("❌ Error: Could not delete payroll record.");
        }
    }

    @Override
    public void updatePayrollRecord(PayrollRecord record) {
    List<PayrollRecord> update = viewAllPayrollRecords();
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
        for(PayrollRecord RC : update){
            if(RC.getRecordId().equals(RC.getRecordId())){
                RC = record;    // replace with updated record
            }
            writer.write(RC.getEmployeeId() + "," +
                    RC.getBasicSalary() + "," +
                    RC.getAllowances() + "," +
                    RC.getDeductions() + "," +
                    RC.getNetSalary() + "," +
                    RC.getPayDate());
            writer.newLine();
        }
    } catch (Exception e) {
        System.out.println("❌ Error: Could not update payroll record.");
    }
    }

    @Override
    public List<PayrollRecord> viewAllPayrollRecords() {
       List<PayrollRecord> records = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if(data.length == 7){
                    String recordId = data[0];
                    String employeeId = data[1];
                    double basic = Double.parseDouble(data[2]);
                    double allowances = Double.parseDouble(data[3]);
                    double deductions = Double.parseDouble(data[4]);
                    double netSalary = Double.parseDouble(data[5]);
                    LocalDate payDate = LocalDate.parse(data[6]);
                    records.add(new PayrollRecord(recordId,employeeId,basic,allowances,deductions,netSalary,payDate));
                }
            }
        } catch (IOException e){
            System.out.println("❌ Error: Could not read payroll records.");
        }
       return  records;
    }

    @Override
    public PayrollRecord getPayrollRecordById(String recordId) {
       List<PayrollRecord> records = viewAllPayrollRecords();
       for(PayrollRecord RC : records){
           if(RC.getRecordId().equals(recordId)){
               return  RC;
           }
       }
       return null;
    }
}
