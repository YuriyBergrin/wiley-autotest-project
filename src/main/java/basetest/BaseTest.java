package basetest;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

/**
 * base class for test classes
 */
@Slf4j
public class BaseTest {
	protected WebDriver driver = new DriverManager().getDriver();;

	@Before
	public void setUp() {
		log.info("============================");
		log.info("======== START TEST ========");
		log.info("============================");
	}

	@After
	public void finish() {
		log.info("============================");
		log.info("========= END TEST =========");
		log.info("============================");
	}
}
