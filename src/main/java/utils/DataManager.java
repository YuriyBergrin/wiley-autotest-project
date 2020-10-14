package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * for data manage, uses data from properties file of the project root
 */
public class DataManager {
	private static String data;

	/**
	 *
	 * @param value - value name in property file
	 * @return value from property file
	 */
	public static String getValue(String value) {
		Properties properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream("properties.properties");
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		data = properties.getProperty(value);
		return data;
	}
}
