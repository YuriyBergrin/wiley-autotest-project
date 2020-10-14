package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EducationPage extends  BasePage{
	public EducationPage(WebDriver driver) {
		super(driver);
	}

	@Getter
	@FindBy(xpath = "//*[@class=\"side-panel\"]//a[not(contains(@class, \"link-corner\"))]")
	private List<WebElement> subjects;
}
