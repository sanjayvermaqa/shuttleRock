package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import utilities.Logging;
import java.util.Random;
import static utilities.Constants.*;

public class HomePageTest extends BaseClass {
    HomePage homePage;
    String uiValue;
    String calcValue;
    SoftAssert softAssert = new SoftAssert();

    /*
    *Below test is to do the page validation tests
    */
    @Test (priority = 0)
    public void pageValidation() throws Exception {
        try {
            homePage = new HomePage(driver);

            int loadTime = ((Long) ((JavascriptExecutor) driver).executeScript(
                    "return performance.timing.loadEventEnd - performance.timing.navigationStart;")).intValue();
            Logging.info("Page took - " + (loadTime / 1000) + "sec to load");

            homePage.elementValidations();
            homePage.inputFieldValidation();
            Logging.info(String.valueOf(TestResult.TEST_PASSED));
        } catch (Exception e) {
            Logging.error(String.valueOf(TestResult.TEST_FAILED));
            throw new Exception ("Test was unable to complete due to - " + e.getMessage());
        }
    }

    /*
     *Below test is to do positive tests
     */
    @Test (priority = 1)
    public void positiveTests() throws Exception {

        try {

            for (int i = 1; i < 4; i++) {
                Random random = new Random();
                int randomNumber = random.nextInt((Integer.parseInt(maxRangeValue) - Integer.parseInt(minRangeValue)) + 1) + Integer.parseInt(minRangeValue);

                evaluate(randomNumber, uiValue, calcValue);

                if (calcValue.contains("Please enter an integer") != uiValue.contains("Please enter an integer")) {
                    Assert.assertEquals(calcValue, uiValue, "Output calculated is incorrect");
                }
                Logging.info(String.valueOf(TestResult.TEST_PASSED));
            }
        }catch (Exception e){
            Logging.error(String.valueOf(TestResult.TEST_FAILED));
            throw new Exception ("Test was unable to complete due to - " + e.getMessage());
        }

    }

    /*
     *Below test is to do negative tests
     */
    @Test (priority = 2)
    public void negativeTests() throws Exception{
        try {
            Logging.info("Try with input number as 0");
            evaluate(0, uiValue, calcValue);

            softAssert.assertEquals(calcValue, uiValue, "Output calculated is incorrect");

            Logging.info("Try with input number as " + minRangeValue);
            evaluate(Integer.parseInt(minRangeValue), uiValue, calcValue);
            softAssert.assertEquals(calcValue, uiValue, "Output calculated is incorrect");

            Logging.info("Try with input number as " + maxRangeValue);
            evaluate(Integer.parseInt(maxRangeValue), uiValue, calcValue);
            softAssert.assertEquals(calcValue, uiValue, "Output calculated is incorrect");

            Logging.info("Try with input number as " + limitRangeValue);
            evaluate(Integer.parseInt(limitRangeValue), uiValue, calcValue);
            softAssert.assertEquals(calcValue, uiValue, "Output calculated is incorrect");

            Logging.info(String.valueOf(TestResult.TEST_PASSED));
        }catch (Exception e){
            Logging.error(String.valueOf(TestResult.TEST_FAILED));
            throw new Exception ("Test was unable to complete due to - " + e.getMessage());
        }
    }

    /*
     * Method to evaluate the value in UI and from the factorial method.
     */
    public void evaluate(int num, String uiValue, String calcValue) throws Exception {
            driver.navigate().refresh();
            homePage = new HomePage(driver);

            homePage.inpNumber.sendKeys(String.valueOf(num));
            homePage.btnCalculate.click();
            Thread.sleep(500);
            this.uiValue = homePage.lblResult.getText();
            Logging.info("Factorial value obtained from UI is - " + this.uiValue);

            this.calcValue = "The factorial of " + num + " is: " + factorial(num);
            Logging.info("Actual factorial value of " + num + " is: " + this.calcValue);
    }
    /*
    * Method to calculate factorial value of a number
    */
    public double factorial(double num){
        double res = 1;
        for(int i = 1; i <= num; ++i)
        {
            res = res * i;
        }
        return res;
    }
}
