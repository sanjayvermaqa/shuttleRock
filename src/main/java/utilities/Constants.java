package utilities;

public class Constants {

    public static String configFolderPath = "src/main/resources/config/";
    public static String url = ConfigManager.getProperty("url");
    public static String negativeValue = ConfigManager.getProperty("negativeValue");
    public static String aplhaText = ConfigManager.getProperty("aplhaText");
    public static String alphaNumbericText = ConfigManager.getProperty("alphaNumbericText");
    public static String specialCharText = ConfigManager.getProperty("specialCharText");
    public static String minRangeValue =  ConfigManager.getProperty("minRangeValue");
    public static String maxRangeValue = ConfigManager.getProperty("maxRangeValue");
    public static String limitRangeValue = ConfigManager.getProperty("limitRangeValue");

    public enum TestResult {
        TEST_PASSED,
        TEST_FAILED,
    }
}
