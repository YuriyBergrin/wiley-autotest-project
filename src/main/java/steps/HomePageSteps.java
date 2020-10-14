package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class HomePageSteps extends BaseSteps {
	private HomePage page = new HomePage(driver);

	public HomePageSteps(WebDriver driver) {
		super(driver);
	}

	public void open() {
		page.openPage();
	}

	public void closeModalWindow() {
		page.closeModalWindow();
	}

	public int getWhoWeServeOptionsSize() {
		return page.getWhoWeServeDropDown().getDropDownOptions().size();
	}

	/**
	 * @return list of dropdown titles
	 */
	public ArrayList<String> getWhoWeServeOptionsTitles() {
		ArrayList<String> result = new ArrayList<>();
		ArrayList<WebElement> elements = page.getWhoWeServeDropDown().getDropDownOptions();
		for (WebElement element : elements) {
			result.add(element.getAttribute("innerHTML").trim());
		}
		return result;
	}

	public void whoWeServeDropDownMove() {
		wait.until(ExpectedConditions.invisibilityOf(page.getCloseModalButton()));
		page.getWhoWeServeDropDown().moveToElement();
	}

	public void subjectsDropDownMove() {
		wait.until(ExpectedConditions.invisibilityOf(page.getCloseModalButton()));
		page.getSubjectsDropDown().moveToElement();
	}

	public void textToSearchInput(String text) {
		page.getSearchInput().sendKeys(text);
	}

	public ArrayList<String> getSearchResults() {
		ArrayList<String> result = new ArrayList<>();
		List<WebElement> elements = page.getSearchResults();
		for (WebElement element : elements) {
			result.add(element.getText());
		}
		return result;
	}

	public void clickSearchSubmit() {
		page.getSearchSubmitButton().click();
	}

	public void clickOption(String text) {
		page.getSubjectsDropDown().chooseOptionByText(text);
	}
}
