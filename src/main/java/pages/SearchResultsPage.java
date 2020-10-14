package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{
	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	@Getter
	@FindBy(css = ".product-title span")
	private List<WebElement> searchResultTitles;

	@Getter
	@FindBy(className = ".product-item")
	private List<WebElement> searchResultPanels;

	@Getter
	@FindBy(xpath = "//div[contains(text(),\"O-Book\")]")
	private List<WebElement> oBookTabs;


}
