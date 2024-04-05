package com.vtiger.stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps {
	
	public static Map<String,Map<String,String>> dt;
	
	public static WebDriver driver;
	
	public String TCName;
	
	public Properties prop;
	
	public static ExtentReports extent;
	
	public static ExtentTest logger;
	
	
	
	public void initiation() throws Exception
	{
		if(extent==null)
		createExtentReport();
		if(prop==null)
			readproperties();
		if(dt==null)
		dt = readExceldata(System.getProperty("user.dir")+"/src/test/resources/TestData/data.xlsx","Sheet1");
	}
	
	public void lauchApp() throws Exception
	{
		
		
		if(driver==null)
		{
		
		 WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    driver.get(prop.getProperty("AppURL"));
		}
	}
	
	
	public void readproperties() throws IOException
	{
		prop = new Properties();
		FileInputStream fis  = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		prop.load(fis);
	}
	
	
	
	public void createExtentReport()
	{
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = ft.format(d);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+fileName+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rajesh U");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.DARK); 
		
	}
	
	public Map<String,Map<String,String>> readExceldata(String file, String sheet) throws Exception
	{
		Map<String,Map<String,String>> m = new HashMap<>();
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(file);
		String strQuery="Select * from "+sheet;
		Recordset recordset=connection.executeQuery(strQuery);
		int rowcount = recordset.getCount();
	
		List<String> ls =  recordset.getFieldNames();
		System.out.println(ls);
		 while(recordset.next())
		{
			 Map<String,String> map = new HashMap<>();
		
			for(int j=1;j<ls.size();j++)
			{
		  	  String key = ls.get(j);
		  	  String value = recordset.getField(key);
		  	  map.put(key, value);
			}
			
			m.put(recordset.getField(ls.get(0)), map);
		}
		
		System.out.println(m);
		 
		recordset.close();
		connection.close();
		
		return m;
	}

}
