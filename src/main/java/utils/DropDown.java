package utils;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

/**
 * class for dropdown elements
 */
public class DropDown {
	private WebDriver driver;
	private WebElement dropDown;
	@Getter
	private By dropDownLocator;
	private By dropDownOptionLocator = By.xpath(".//li/a");
	private List<WebElement> options;

	public DropDown(By dropDownLocator) {
		this.driver = new DriverManager().getDriver();
		this.dropDownLocator = dropDownLocator;
	}

	public ArrayList<WebElement> getDropDownOptions() {
		dropDown = driver.findElement(dropDownLocator);
		options = dropDown.findElements(dropDownOptionLocator);
		return (ArrayList<WebElement>) options;
	}

	public void click() {
		dropDown = driver.findElement(dropDownLocator);
		dropDown.click();
	}

	public void moveToElement() {
		dropDown = driver.findElement(dropDownLocator);
		Actions actions = new Actions(driver);
		actions.moveToElement(dropDown).build().perform();
	}

	/**
	 * click dropdown option by text
	 * @param text
	 */
	public void chooseOptionByText(String text) {//todo need to edit
		ArrayList<WebElement> options = getDropDownOptions();
		for (WebElement element : options) {
			try {
				if (element.getAttribute("innerHTML").contains(text)) {
					element.click();
				}
			} catch (Exception e) {

			}
		}
	}
}
