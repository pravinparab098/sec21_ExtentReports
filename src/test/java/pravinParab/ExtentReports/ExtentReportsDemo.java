package pravinParab.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemo {
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		/*
		 * while dealing with extend reports we need two classes ExtentReports and
		 * ExtentSparkReporter ExtentSparkReporter requires a path where your report
		 * should be created -- responsible for creating a report this helps you to set
		 * ReportName, document Title
		 * ExtentReports so this responsible for drive the all reporting executions so
		 * 
		 * all the configuration of report include file path is attch to the main class
		 * ExtentReport because it is responsible for the all execution of the
		 * extentReport-- with the help of the extentReport you can provide a tester
		 * name
		 * 
		 * so create object for these two classes and then connect them to create
		 * ExtendReport
		 */

		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Result");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Pravin Parab");
	}

	@Test

	public void initialDemo() throws InterruptedException {
		
		ExtentTest testObject =	extent.createTest("Initial Demo");	
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://courses.rahulshettyacademy.com/");
		driver.manage().window().maximize();
		System.out.println("Title : " + driver.getTitle());
		Thread.sleep(1000);
		driver.close();
		testObject.fail("Result Not Match");
		
		extent.flush();
		
		
	}
}
