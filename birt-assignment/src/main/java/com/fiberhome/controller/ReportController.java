package com.fiberhome.controller;

import com.fiberhome.itom.commons.utils.ExportReportUtilTest;
import com.fiberhome.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentsDetails")
public class ReportController {
    @Autowired
    ReportService reportService;
    @Autowired
    ExportReportUtilTest exportReportUtilTest;

    @GetMapping(value = "/getStudentReport/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getStudentReport(@PathVariable("type") String type) {
        try {
            reportService.getReport(type);
            return new ResponseEntity<>("Success fully created pdf:", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }



    @GetMapping(value = "/getStudentReport", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getStudentReporttest() {
        try {
            exportReportUtilTest.exportReport();
            return new ResponseEntity<>("Success fully created pdf:", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
