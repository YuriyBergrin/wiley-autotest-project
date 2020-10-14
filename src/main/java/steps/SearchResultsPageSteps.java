package steps;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SearchResultsPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SearchResultsPageSteps extends BaseSteps {
	public SearchResultsPageSteps(WebDriver driver) {
		super(driver);
	}

	private SearchResultsPage page = new SearchResultsPage(driver);

	public ArrayList<String> getSearchTitles() {
		ArrayList<String> result = new ArrayList<>();
		List<WebElement> elements = page.getSearchResultTitles();
		for (WebElement element : elements) {
			result.add(element.getText());
		}
		return result;
	}

	public int getSearchResultsCount() {
		return page.getSearchResultTitles().size();
	}

	public boolean isAddToCartDisplayed() {
		boolean result = true;
		List<WebElement> searchResultPanels = page.getSearchResultPanels();
		for (WebElement element : searchResultPanels) {
			if (!element.findElement(By.cssSelector("[class*=\"small-button add-to-cart-button\"]")).isDisplayed()) {
				result = false;
				break;
			}
		}
	return result;}

	/**
	 * is VIEW ON WILEY ONLINE LIBRARY button visible
	 */
	public boolean isVOWOLButtonVisible() {
		boolean result = true;
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> searchResultPanels = page.getSearchResultPanels();

		for (WebElement element : searchResultPanels) {
			try {
				element.findElement(By.xpath("//div[contains(text(),\"O-Book\")]")).click();
				if (!element.findElement(By.xpath("//*[contains(text(),\"View on Wiley Online Library\")]")).isDisplayed()){
					result = false;
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					break;
				}
			} catch (Exception e) {
				log.info("O-Book tab doesn't exist");
			}
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return result;}
}
