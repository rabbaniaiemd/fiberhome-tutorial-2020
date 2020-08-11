package com.fiberhome.itom.commons.utils;


import com.fiberhome.cusa.common.util.ListUtil;
import com.fiberhome.cusa.report.birt.builder.PlatformManager;
import com.fiberhome.cusa.report.birt.entity.ReportContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.lang.time.DateFormatUtils;

/**
 * @Auther: jack
 * @Date: 5/27/2019 13:39
 * @Description:
 */
public class ExportReportUtil {
    /**
     * generate file path
     * */
    private static final String generateFilePath = "output/report/";

    /**
     *
     * 
     * support xls,xlsx,excel,html,pdf,csv
     *
     * @param rptFilePath rptdesign file path
     * @param reportType report type
     * @param dataSources data sources
     * @param keys internationalization key
     * @return report file path
     * */
    public static String exportReport(String rptFilePath, String reportType,
                                      Map<String, Object> dataSources, List<String> keys) {
        //report context
        ReportContext reportContext = new ReportContext();

        //set data source
        reportContext.setDataSources(dataSources);

        //set report type
        reportContext.setReportType(reportType);

        //set column internationalization name
        if (ListUtil.isNotEmpty(keys)) {
            Map<String, Object> params = new HashMap<>();
            for(String key : keys) {
                if (StringUtils.isNotEmpty(I18nUtils.getMessage(key))) {
                    params.put(key, I18nUtils.getMessage(key));
                }
            }
            params.put("employee_name",I18nUtils.getMessage("employee_name"));
            params.put("employee_number",I18nUtils.getMessage("employee_number"));
            reportContext.setParams(params);
        }

        //set report design file path
        reportContext.setReportDesignFilePath(rptFilePath);

        //set export report file path
        File file = new File(generateFilePath);
        if (!file.exists() || file.isDirectory()) {
            file.mkdirs();
        }
        reportContext.setReportPath(generateFilePath);

        //set report name
        Date date = new Date();
        String currentTime = DateFormatUtils.format(date, "yyyyMMddhhmmss");
        String reportName = "report_" + currentTime;
        reportContext.setReportName(reportName);

        //set localization
        //reportContext.setLocale("en_US");

        //start report task
        if (PlatformManager.runReportTask(reportContext)) {
            return "report/" + reportName + "." + reportType;
        } else {
            return "";
        }
    }
}