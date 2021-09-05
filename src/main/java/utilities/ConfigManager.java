package utilities;

import tests.ExecutableJAR;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	private static Properties config = null;
	/*
	 * This method is to load config file from the path mentioned in Constants class
	 */
	public static synchronized void loadConfig() throws IOException {
		config = new Properties();
		String fileName = "config/default.properties";
		InputStream in = ExecutableJAR.class.getClassLoader().getResourceAsStream(fileName);
		config.load(in);
	}

	/*
	 * This method is to get the property value form config loaded
	 */
	public static synchronized String getProperty(String property) {
		try {
			if (config == null)
				loadConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return config.getProperty(property).trim();
	}
}
