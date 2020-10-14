package uitests;

import basetest.BaseTest;
import org.junit.Test;
import steps.EducationPageSteps;
import steps.HomePageSteps;
import steps.SearchResultsPageSteps;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UiTest extends BaseTest {
	private HomePageSteps homePageSteps = new HomePageSteps(driver);
	private SearchResultsPageSteps searchResultsPageSteps = new SearchResultsPageSteps(driver);
	private EducationPageSteps educationPageSteps = new EducationPageSteps(driver);
	private ArrayList<String> optionsExpectedList =
			new ArrayList<>(Arrays.asList("Students", "Instructors", "Book Authors", "Professionals",
					"Researchers", "Institutions", "Librarians", "Corporations", "Societies", "Journal Editors", "Government"));
	private ArrayList<String> subjectsExpectedList =
			new ArrayList<>(Arrays.asList("Information & Library Science","Education & Public Policy",
					"K-12 General","Higher Education General","Vocational Technology",
					"Conflict Resolution & Mediation (School settings)","Curriculum Tools- General",
					"Special Educational Needs", "Theory of Education", "Education Special Topics","Educational Research & Statistics",
					"Literacy & Reading","Classroom Management"
					));


	@Test
	public void whoWeServeDropDownTest() {
		homePageSteps.open();
		homePageSteps.closeModalWindow();
		homePageSteps.whoWeServeDropDownMove();
		assertEquals(11, homePageSteps.getWhoWeServeOptionsSize());
		assertEquals(optionsExpectedList, homePageSteps.getWhoWeServeOptionsTitles());
		/**
		 * this test failed because options has 13 items (+1 not exist task element and +1 invisible element)
		 * Expected :[Students, Instructors, Book Authors, Professionals, Researchers, Institutions, Librarians, Corporations, Societies, Journal Editors, Government]
		 * Actual   :[Students, Textbook Rental, Instructors, Book Authors, Professionals, Researchers, Institutions, Librarians, Corporations, Societies, Journal Editors, Bookstores, Government]
		 */
	}

	@Test
	public void searchFunctionalityTest() {
		homePageSteps.open();
		homePageSteps.closeModalWindow();
		homePageSteps.textToSearchInput("Java");
		ArrayList<String> searchResults = homePageSteps.getSearchResults();
		for (String searchItem : searchResults) {
			assertTrue(searchItem.contains("java"));
		}
	}

	@Test
	public void searchFunctionalityWithSearchButton() {
		homePageSteps.open();
		homePageSteps.closeModalWindow();
		homePageSteps.textToSearchInput("Java");
		homePageSteps.clickSearchSubmit();
		homePageSteps.closeModalWindow();
		assertEquals(10, searchResultsPageSteps.getSearchResultsCount());
		ArrayList<String> searchResults = searchResultsPageSteps.getSearchTitles();
		for (String searchItem : searchResults) {
			assertTrue(searchItem.contains("Java"));
		}
		assertTrue(searchResultsPageSteps.isAddToCartDisplayed());
		assertTrue(searchResultsPageSteps.isVOWOLButtonVisible());
	}

	@Test
	public void subjectsTest() {
		homePageSteps.open();
		homePageSteps.closeModalWindow();
		homePageSteps.subjectsDropDownMove();
		homePageSteps.clickOption("Education");
		homePageSteps.closeModalWindow();
		assertTrue(homePageSteps.getPageTitle().contains("Education"));
		assertEquals(subjectsExpectedList, educationPageSteps.getSubjectsTitles());
	}
}
