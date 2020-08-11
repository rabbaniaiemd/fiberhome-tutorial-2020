package com.fiberhome.service;

import com.fiberhome.itom.commons.utils.ExportReportUtil;
import com.fiberhome.model.EmployeeInformation;
import com.fiberhome.model.StudentDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceImpl implements ReportService{
    @Override
    public void getReport(String reportType) {

        //String rptFilePath="report/student_report.rptdesign";
        String rptFilePath="report/employee_report.rptdesign";
        //List<StudentDetails> studentDetailsList = getStudentDetails();
        List<EmployeeInformation> employeeDetailsList = getemployeeDetailsList();
        // Setting up data sources
        Map<String, Object> dataSources = new HashMap();
        List<String> reportKeys = new ArrayList<String>();
        // Setting up data sources
        //dataSources.put("APP_CONTEXT_KEY_DATA SET",studentDetailsList);
        dataSources.put("APP_CONTEXT_KEY_DATA SET",employeeDetailsList);
        String result= ExportReportUtil.exportReport(rptFilePath,reportType,dataSources,reportKeys);
    }

    private List<EmployeeInformation> getemployeeDetailsList() {
        List< EmployeeInformation > employeDetailsList=Arrays.asList(new EmployeeInformation("AA","NNN","CC"),new EmployeeInformation("AA","NNN","CC"),
                new EmployeeInformation("AA","NNN","CC"),
                new EmployeeInformation("AA","NNN","CC"),
                new EmployeeInformation("AA","NNN","CC"),
                new EmployeeInformation("AA","NNN","CC"),
                new EmployeeInformation("AA","NNN","CC"),
                new EmployeeInformation("AA","NNN","CC"),
                new EmployeeInformation("AA","NNN","CC"),
                new EmployeeInformation("AA","NNN","CC"),
                new EmployeeInformation("AA","NNN","CC"),
                new EmployeeInformation("AA","NNN","CC"),
                new EmployeeInformation("AA","NNN","CC"),
                new EmployeeInformation("AA","NNN","CC")
                );
        return  employeDetailsList ;
    }

    public List<StudentDetails>  getStudentDetails(){
        List<StudentDetails> studentDetailsList = Arrays.asList(
                new StudentDetails("md","1","cse","B.tech"),
                new StudentDetails("rab","10","cse","B.tech"),
                new StudentDetails("jax","2","cse","B.tech"),
                new StudentDetails("mike","3","cse","B.tech"),
                new StudentDetails("john ","4","cse","B.tech"),
                new StudentDetails("wally","5","cse","B.tech"),
                new StudentDetails("max","6","cse","B.tech"),
                new StudentDetails("john ","4","cse","B.tech"),
                new StudentDetails("wally","5","cse","B.tech"),
                new StudentDetails("max","6","cse","B.tech"),
                new StudentDetails("john ","4","cse","B.tech"),
                new StudentDetails("wally","5","cse","B.tech"),
                new StudentDetails("max","6","cse","B.tech"),
                new StudentDetails("john ","4","cse","B.tech"),
                new StudentDetails("wally","5","cse","B.tech"),
                new StudentDetails("max","6","cse","B.tech"),
                new StudentDetails("john ","4","cse","B.tech"),
                new StudentDetails("wally","5","cse","B.tech"),
                new StudentDetails("max","6","cse","B.tech"),
                new StudentDetails("john ","4","cse","B.tech"),
                new StudentDetails("wally","5","cse","B.tech"),
                new StudentDetails("john ","4","cse","B.tech"),
                new StudentDetails("wally","5","cse","B.tech"),
                new StudentDetails("max","6","cse","B.tech"),
                new StudentDetails("john ","4","cse","B.tech"),
                new StudentDetails("wally","5","cse","B.tech"),
                new StudentDetails("max","6","cse","B.tech"),
                new StudentDetails("john ","4","cse","B.tech"),
                new StudentDetails("wally","5","cse","B.tech"));
               return  studentDetailsList;
    }
}
