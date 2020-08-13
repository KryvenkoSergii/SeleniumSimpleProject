package home.kryvenkosergii.SeleniumSimpleProject.ui.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import home.kryvenkosergii.SeleniumSimpleProject.ui.data.DataRepository;
import home.kryvenkosergii.SeleniumSimpleProject.ui.data.SearchData;
import home.kryvenkosergii.SeleniumSimpleProject.ui.page.MainGooglePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SimpleTest extends TestRunner {

    @DataProvider
    public Object[][] searchRandomWord() {
        return new Object[][] { { DataRepository.get().oneRandomWordSearchData() }, };
    }

    /**
     * A simple test using Selenium. In Google page, we search request which consists of a random string.
     * @param word Random string (20 letters).
     */
    @Epic("A simple test using Selenium.")
    @Feature(value = "search random word")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("In Google page, we search request which consists of a random string.")
    @Story(value = "Make a search request with a random word. Print the response title as a result of the execution.")
    @Parameters("Random word")
    @Test(dataProvider = "searchRandomWord")
    public void search(SearchData word) {
        logger.info("start search with " + word.toString());
        MainGooglePage mainGooglePage = new MainGooglePage(driver).searchText(word.getSearchText());
        String result = mainGooglePage.getResult();
        System.out.println("result = " + result);
        Assert.assertTrue(result.contains(word.getSearchText()), "test is failed");
    }
}
