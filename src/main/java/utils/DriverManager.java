package utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * initializes and returns driver
 */
@Slf4j
public class DriverManager {
	private static WebDriver driver;

	public WebDriver getDriver() {
		if (driver == null) {
			log.info("initialize new driver");
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			/**
			 * shutdown hook for faster drivers work
			 */
			Runtime.getRuntime().addShutdownHook(new Thread(() -> {
				driver.quit();
				driver = null;
			}));
		}
		return driver;
	}
}
