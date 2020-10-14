package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * base class for webpages uses page factory pattern
 */
@Slf4j
public class BasePage {
	protected WebDriver driver;
	protected String pageUrl;

	@Getter
	@FindBy(css = ".close")
	private WebElement closeModalButton;

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void openPage() {
		log.info("open " + pageUrl);
		driver.get(pageUrl);
	}

	public void closeModalWindow() {
		log.info("close modal window");
		while (true) {
		closeModalButton.click();
		pause();
		if (!closeModalButton.isDisplayed()) {
			break;
		}
		}
	}

	/**
	 * bad practice but sometimes nothing to be done
	 */
	public void pause() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
