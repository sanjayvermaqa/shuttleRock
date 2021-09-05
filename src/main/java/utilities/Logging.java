package utilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tests.BaseClass;

public class Logging extends BaseClass {
    private static Logger log = LogManager.getLogger(Logging.class);

    public static void startTestCase(String testCaseName){
        try{
            log.info("==========================================================================================");
            log.info("Starting test  "+ testCaseName);
            log.info("==========================================================================================");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void info (String msg){
        log.info(msg);
    }
    public static void error (String msg){
        log.error(msg);
    }

    public static void endTestCase(){
        log.info("=======================================End Test===========================================");
    }
}
