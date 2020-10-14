package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BaseSteps {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BaseSteps(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	public void waitUntilElementToBeVisible(By locator) {
		wait.until(visibilityOfElementLocated(locator));
	}

	public void waitUntilElementToBeClickable(By locator) {
		wait.until(elementToBeClickable(locator));
	}

	public void waitUntilElementToBeClickable(WebElement element) {
		wait.until(elementToBeClickable(element));
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}
