package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager_utility implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;  
	public ExtentReports extent;                
	public ExtentTest test;                     

	String repName;
	
	 public void onStart(ITestContext context)
	 {
		 
		 String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 
		 
		 repName = "Test- Report "+ timestamp +".html";
		 sparkReporter = new ExtentSparkReporter(".\\Reports\\"+ repName);
	 
		 
		 
		 
		 sparkReporter.config().setDocumentTitle("Automation Testing");
		 sparkReporter.config().setReportName("Functional Testing");
		 sparkReporter.config().setTheme(Theme.STANDARD);
		 
		 
		 
		 extent= new ExtentReports();
		 extent.attachReporter(sparkReporter);
		 
		 extent.setSystemInfo("Application", "Indigo_Site");
		 extent.setSystemInfo("Environment", "QA");
		 extent.setSystemInfo("Tester Name", "Nitesh Kumar Ojha");
	
		
		 
		 String br = context.getCurrentXmlTest().getParameter("browser");
		 extent.setSystemInfo("Browser name", br);
		 
	
		 
	 
	 }
	
	 public void onTestSuccess(ITestResult result) 
	 {
		 test = extent.createTest(result.getTestClass().getName());  
		 test.log(Status.PASS, result.getName()+ " got successfully executed"); 
	 }
	 
	 
	 
	 
	 public void onTestFailure(ITestResult result)
	 {
		 test = extent.createTest(result.getTestClass().getName());
		 test.log(Status.FAIL, "Test case FAILED is  "+ result.getName());
		 test.log(Status.FAIL,  result.getThrowable().getMessage());
		 
		 
		 try {
			 String imgPath = new BaseClass().captureScreenshot(result.getName());
			 test.addScreenCaptureFromPath(imgPath);
			 
		 }
		 catch(Exception e1)
		 {
			 e1.printStackTrace();
		 }
		 
    
	 }
	 
	 
	 public void onTestSkipped(ITestResult result) 
	 {
		 test = extent.createTest(result.getTestClass().getName());
		 test.log(Status.SKIP, "Test case SKIPPED is  "+ result.getName());	
		 test.log(Status.INFO,  result.getThrowable().getMessage());
     }
	
	 
	 public void onFinish(ITestContext context)
	 {
		 extent.flush();	
		 
		 String pathOfExtentReport = System.getProperty("user.dir")+"\\Reports\\"+repName;
		 File extentReport = new File(pathOfExtentReport);
		 
		 try
		 {
			 Desktop.getDesktop().browse(extentReport.toURI());
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 }
     }
