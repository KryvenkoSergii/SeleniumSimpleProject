package home.kryvenkosergii.SeleniumSimpleProject.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.qameta.allure.Step;

/**
 * MainGooglePage class.
 * @author SergiiK
 */
public class MainGooglePage {
    //
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private WebDriver driver;
    //
    private WebElement searchField;
    private WebElement searchButton;
    private WebElement searchPageTitle;
    private WebElement searchResult;

    /**
     * MainGooglePage constructor.
     * @param driver WebDriver
     */
    public MainGooglePage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    /**
     * Initialize web elements
     */
    private void initElements() {
        searchField = driver.findElement(By.cssSelector(".a4bIc input[class='gLFyf gsfi']"));
        searchButton = driver.findElement(By.cssSelector(".gNO89b"));
    }

    // Page Object
    // searchField
    private WebElement getSearchField() {
        return searchField;
    }

    @Step(value = "input in Search Field text {0}")
    private MainGooglePage inputSearchField(String text) {
        logger.debug("start inputSearchField()");
        logger.trace("input SearchField: " + text);
        logger.info(this.getClass().getSimpleName() + " input SearchField: " + text);
        log("Start search using string: " + text);
        this.getSearchField().sendKeys(text);
        return this;
    }

    @Step(value = "clear Search Field")
    private MainGooglePage clearSearchField() {
        logger.debug("start clearSearchField()");
        logger.trace("clear SearchField");
        logger.info(this.getClass().getSimpleName() + " clear SearchField");
        this.getSearchField().clear();
        return this;
    }

    @Step(value = "click in Search Field")
    private MainGooglePage clickSearchField() {
        logger.debug("start clickSearchField()");
        logger.trace("click SearchField");
        logger.info(this.getClass().getSimpleName() + " click SearchField");
        if (isDisplayedSearchField()) {
            this.getSearchField().click();
            Actions action = new Actions(driver);
            action.contextClick(getSearchField()).sendKeys(Keys.LEFT).sendKeys(Keys.RIGHT);
        }
        return this;
    }

    private boolean isDisplayedSearchField() {
        logger.debug("start isDisplayedSearchField()");
        logger.trace("is Displayed SearchField");
        return getSearchField().isDisplayed();
    }

    /**
     * Getting text in the Search field.
     * @return String
     */
    public String getSearchFieldText() {
        return getSearchField().getAttribute("data-ved");
    }

    // searchButton
    private MainGooglePage clickSearchButton() {
        logger.debug("start clickSearchButton()");
        logger.trace("click SearchButton");
        logger.info(this.getClass().getSimpleName() + " click SearchButton");
        if (isDisplayedSearchField()) {
            this.getSearchField().submit();
        }
        return this;
    }

    // searchTitle
    private WebElement getSearchTitle() {
        searchPageTitle = driver.findElement(By.cssSelector("head title"));
        return searchPageTitle;
    }

    private boolean isDisplayedSearchTitle() {
        logger.debug("start isDisplayedSearchTitle()");
        logger.trace("is Displayed SearchTitle");
        return getSearchTitle().isDisplayed();
    }

    private String getSearchTitleText() {
        // return driver.getTitle();
        return getSearchTitle().getText();
    }

    // searchResult
    private WebElement getSearchResult() {
        searchResult = driver.findElement(By.cssSelector("#topstuff p[role='heading']"));
        return searchResult;
    }

    private boolean isDisplayedSearchResult() {
        logger.debug("start isDisplayedSearchResult()");
        logger.trace("is Displayed SearchResult");
        return getSearchResult().isDisplayed();
    }

    @Step(value = "get Search Result Text")
    private String getSearchResultText() {
        logger.info(this.getClass().getSimpleName() + " search result = " + getSearchResult().getText());
        log("search result = " + getSearchResult().getText());
        return getSearchResult().getText();
    }

    // empty method for Allure logging
    @Step("{0}")
    private void log(String value) {
        // empty method
    }

    // Functional
    /**
     * In the main Google page click to search field, clear it and input text.
     * @param text String
     * @return MainGooglePage class.
     */
    public MainGooglePage searchText(String text) {
        if (isDisplayedSearchField()) {
            clickSearchField().clearSearchField().inputSearchField(text).clickSearchButton();
        }
        return this;
    }

    /**
     * Getting the title of the page.
     * @return title String.
     */
    public String getResult() {
        if (isDisplayedSearchResult()) {
            return getSearchResultText();
        }
        return "result not found";
    }
}
