package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DataManager;
import utils.DropDown;

import java.util.List;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver) {
		super(driver);
		pageUrl = DataManager.getValue("wiley_url");
	}
	@Getter
	@FindBy(id = "js-site-search-input")
	private WebElement searchInput;

	@Getter
	@FindBy(css = ".main-navigation-search button")
	private WebElement searchSubmitButton;

	@Getter
	@FindBy(xpath = "//section[contains(@class,\"suggestions\")]//div[contains(@class,\"searchresults\")]")
	List<WebElement> searchResults;

	@Getter
	private DropDown whoWeServeDropDown = new DropDown(By.xpath("//*[@id=\"Level1NavNode1\"]/parent::li"));

	@Getter
	private DropDown subjectsDropDown = new DropDown(By.xpath("//*[@id=\"Level1NavNode2\"]/parent::li"));
}
