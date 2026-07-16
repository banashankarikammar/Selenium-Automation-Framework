package com.ai.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;// we need only 1 report even tho 100tc present

    public static ExtentReports getExtentReport() {

        if (extent == null) {

            ExtentSparkReporter spark = //HTML designer
                    new ExtentSparkReporter("Reports/AutomationReport.html");

            spark.config().setDocumentTitle("AI Selenium Framework");

            spark.config().setReportName("Automation Test Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Banashankari");

            extent.setSystemInfo("Framework", "Selenium + TestNG");

            extent.setSystemInfo("Language", "Java");

        }

        return extent;

    }

}