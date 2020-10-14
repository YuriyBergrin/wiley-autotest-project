package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EducationPage;

import java.util.ArrayList;
import java.util.List;

public class EducationPageSteps extends BaseSteps {
	private EducationPage page = new EducationPage(driver);
	public EducationPageSteps(WebDriver driver) {
		super(driver);
	}

	public ArrayList<String> getSubjectsTitles() {
		List<WebElement> subjects = page.getSubjects();
		ArrayList<String> subjectsTitles = new ArrayList<>();
		for (WebElement subject : subjects) {
			subjectsTitles.add(subject.getText().trim());
		}
		return subjectsTitles;
	}
}
