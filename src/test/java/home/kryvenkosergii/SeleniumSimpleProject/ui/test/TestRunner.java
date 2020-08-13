package home.kryvenkosergii.SeleniumSimpleProject.ui.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestRunner {
	private final Long ONE_SECOND_DELAY = 1000L;
	//
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	protected WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeClass
	public void setUpBeforeClass() {
//      //
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--headless"); // Chrome Without UI
      driver = new ChromeDriver(options);
        //
//		driver = new ChromeDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownAfterClass() throws Exception {
	    presentationSleep(1);
		if (driver != null) {
			driver.quit();
		}
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver.get("https://google.com");
		presentationSleep(); // For Presentation Only
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		if (!result.isSuccess()) {
		    logger.warn("Test " + result.getName() + " ERROR");
		}
	}

	protected void presentationSleep() {
		presentationSleep(1);
	}
	
	protected void presentationSleep(int seconds) {
		try {
			Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}