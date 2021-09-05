package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.HashMap;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseClass;

public class GeneralFunctions extends BaseClass {
    public static synchronized WebDriver InitialiseDriver(String browser) throws Exception {
        try {
            HashMap<String, Object> chromePrefs = null;
            ChromeOptions chromeOptions = null;

            if ("firefox".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if ("internetExplorer".equals(browser)) {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            } else if ("chrome_headless".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "Downloads");
                chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("disable-gpu");
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
            } else {
                WebDriverManager.chromedriver().setup();
                chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "Downloads");
                chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                driver = new ChromeDriver(chromeOptions);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return driver;
    }

}
