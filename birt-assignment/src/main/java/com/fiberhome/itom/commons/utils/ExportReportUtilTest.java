package com.fiberhome.itom.commons.utils;
import com.fiberhome.model.StudentDetails;
import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.IPlatformContext;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.core.framework.PlatformFileContext;
import org.eclipse.birt.report.engine.api.*;
import org.eclipse.birt.report.engine.api.impl.ReportRunnable;
import org.eclipse.birt.report.engine.api.script.element.IReportDesign;
import org.eclipse.birt.report.model.api.DesignElementHandle;
import org.eclipse.birt.report.model.api.activity.SemanticException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ExportReportUtilTest {

    private static final String generateFilePath = "output/report/";

    public String exportReport(){

        IReportEngine engine = null;
        EngineConfig config = null;
        try {
            config = new EngineConfig();
            HashMap<String, Object> dataSources = new HashMap<>();
            dataSources.put("APP_CONTEXT_KEY_DATA SET",getStudentDetails());
            config.setAppContext(dataSources);
            Platform.startup(config);
            IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
            engine = factory.createReportEngine(config);
        } catch (BirtException e) {
            e.printStackTrace();
        }
        try {
            IReportRunnable design = (IReportRunnable) engine.openReportDesign("src\\main\\resources\\report\\student_report.rptdesign");
          /*  try {
                design.getDesignHandle().setProperty("includeResource", "birt");
            } catch (SemanticException e) {
                e.printStackTrace();
            }*/
            IRunAndRenderTask task = engine.createRunAndRenderTask((IReportRunnable) design);
            /*Map map = task.getAppContext();
            task.getAppContext().put("APP_CONTEXT_KEY_DATA SET",getStudentDetails());
            task.setLocale(new Locale("zh", "CN"));*/
            //map.put("APP_CONTEXT_KEY_DATA SET",getStudentDetails() );
            HTMLRenderOption options = new HTMLRenderOption();
            PDFRenderOption pdfRenderOption = new PDFRenderOption();
            pdfRenderOption.setOutputFileName(generateFilePath+"studentReport.pdf");
            pdfRenderOption.setOutputFormat("pdf");
           /* options.setOutputFileName(generateFilePath+"report.html");
            options.setOutputFormat("html");
            options.setEmbeddable(false);
            options.setHtmlPagination(true);
            options.setHtmlRtLFlag(false);
            options.setHtmlTitle("fiberhome");
            options.setHtmlPagination(true);
            task.setRenderOption(options);*/
            task.setRenderOption(pdfRenderOption);
            task.run();
            task.close();
            engine.destroy();
            System.out.println("File is created:");
        } catch (EngineException e) {
            e.printStackTrace();
        }

        return "";
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