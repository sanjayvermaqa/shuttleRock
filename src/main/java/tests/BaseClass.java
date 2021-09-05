package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.Constants;
import utilities.GeneralFunctions;
import utilities.Logging;

import java.lang.reflect.Method;

public class BaseClass {
    public static WebDriver driver;

    public BaseClass() {
        super();
    }

    /*
     * Before suite method is called once during the test suite execution to initialize activities needed for test suite.
     * Here we are initializing Web Driver and navigating to the URL provided in config
     */
    @Parameters({"browser"})
    @BeforeSuite
    public void beforeSuite(String browser) throws Exception {
        driver = GeneralFunctions.InitialiseDriver(browser);
        driver.navigate().to(Constants.url);
    }

    /*
     * This method is called before each test method.
     * Here we are stating the start for test case in the logger.
     */
    @BeforeMethod
    public void beforeMethod(Method method) {
        String methodName = method.getName().trim();
        Logging.startTestCase(methodName);
    }

    /*
     * This method is called after each test method.
     * Here we are stating the end of test case in the logger.
     */
    @AfterMethod
    public void afterMethod() {
        Logging.endTestCase();
    }

    /*
     * After suite method is called once during the test suite execution to free any resources used by test suite.
     * Here we are quitting the Web Driver.
     */
    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }
}
