package com.qa.opencart.factory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	  private static ExtentReports extent;
	    private static ExtentSparkReporter htmlReporter;
	    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            htmlReporter = new ExtentSparkReporter("extent.html");
	            htmlReporter.config().setTheme(Theme.DARK);
	            htmlReporter.config().setDocumentTitle("Automation Report");
	            htmlReporter.config().setReportName("Test Report");

	            extent = new ExtentReports();
	            extent.attachReporter(htmlReporter);
	            extent.setSystemInfo("OS", "Windows");
	            extent.setSystemInfo("Tester", "Your Name");
	        }
	        return extent;
	    }

	    public static synchronized ExtentTest createTest(String testName) {
	        ExtentTest extentTest = extent.createTest(testName);
	        test.set(extentTest);
	        return extentTest;
	    }

	    public static synchronized ExtentTest getTest() {
	        return test.get();
	    }

	    public static void flush() {
	        extent.flush();
	    }

}
