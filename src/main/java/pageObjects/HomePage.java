package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import tests.BaseClass;
import utilities.Constants;
import utilities.Logging;


public class HomePage extends BaseClass {

    public HomePage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "number") public WebElement inpNumber;
    @FindBy(id = "getFactorial") public WebElement btnCalculate;
    @FindBy(id = "resultDiv") public WebElement lblResult;


    SoftAssert softAssert = new SoftAssert();
    public void elementValidations() throws Exception{
        try{
            Logging.info("Validating elements on the page");
            softAssert.assertEquals(inpNumber.isDisplayed(), "Input number field does not exists");
            softAssert.assertTrue(btnCalculate.isDisplayed(), "Calculate button does not exists");
            softAssert.assertTrue(lblResult.isDisplayed(), "Result field does not exists");

        } catch (Exception e) {
            throw new Exception("Unable to continue with test due to - " + e.getMessage());
        }
    }

    /*
     * Method validate fields on the page
     */
    public void inputFieldValidation() throws Exception{
        try{

            String validErrorMsg = "Please enter an intger - message is not displayed";
            // When nothing is entered
            Logging.info("Test with empty value");
            btnClick("","No appropriate message is displayed on proceeding with empty value");

            //When empty space is entered
            Logging.info("Test with space value");
            btnClick(" ",validErrorMsg);

            //When Negative value is entered
            Logging.info("Test with negative number value");
            btnClick(Constants.negativeValue, validErrorMsg);

            //When Alphabet is entered
            Logging.info("Test with alphabetic value");
            btnClick(Constants.aplhaText, validErrorMsg);

            //When Alphanumeric vale is entered
            Logging.info("Test with alphanumeric value");
            btnClick(Constants.alphaNumbericText, validErrorMsg);

            //When special character is entered
            Logging.info("Test with special character value");
            btnClick(Constants.specialCharText, validErrorMsg);

            Logging.info("Test Passed");
        } catch (Exception e) {
            Logging.error("Test Failed");
            throw new Exception("Unable to continue with test due to - " + e.getMessage());
        }

    }

    /*
     * Method for the click action of Calculate button
     */
    public void btnClick(String value, String msg){
        try {
            driver.navigate().refresh();
            inpNumber.sendKeys(value);
            btnCalculate.click();
            softAssert.assertEquals(lblResult.getText(), "Please enter an integer", msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
