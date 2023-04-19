package stepDef;

import Gen.Wait;
import Pages.P01_GoogleSearch;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class D01_GoogleSearch {
    String numberOfResultsPage2 ;
    String numberOfResultsPage3 ;

    P01_GoogleSearch search = new P01_GoogleSearch();
    Wait wait = new Wait();

    @Given("^User Navigate to \"(.*)\"$")
    public void navigateToGoogle(String URL) {
        //Navigate to google.com
        Hook.driver.get(URL);
    }

    @When("^User enter keyword \"(.*)\" & Click search$")
    public void enterKeywordAndSearch(String keyword) {
        //wait for english localization & click if visible
        wait.waitToBeClickableElement(search.englishLocalization(), 15);
        //enter keyword in search field
        search.searchField().sendKeys(keyword);
        //click enter
        search.searchField().sendKeys(Keys.ENTER);

    }

    @And("^Clear search field & search another keyword \"(.*)\"$")
    public void clearAndSearchAnotherKeyword(String keyword) {
        //clear search field
        search.searchField().clear();
        //enter keyword in search field
        search.searchField().sendKeys(keyword);
        //click enter
        search.searchField().sendKeys(Keys.ENTER);

    }

    @And("Click page 2")
    public void clickPage2() throws InterruptedException {
        //click page 2 in paginator
        search.paginatorPage2().click();
        //set number of results at page 2
        numberOfResultsPage2=search.resultStats().getText().substring(16,23);
        //assert that result stats contains page 2
        Assert.assertEquals(search.resultStats().getText().substring(0,6).equals("Page 2"), true);
    }

    @Then("Number of results exist on UI")
    public void numberOfResults() {
        //assert number of search result is displayed
        search.resultStats().isDisplayed();
    }

    @And("Click on page 3 and check number of results equals to page2")
    public void clickPage3() {
        //click page 3 in paginator
        search.paginatorPage3().click();
        //set number of results at page 3
        numberOfResultsPage3 = search.resultStats().getText().substring(16,23);
        //assert that result stats contains page 3
        Assert.assertEquals(search.resultStats().getText().substring(0,6).equals("Page 3"), true);
        //assert number of search results in page 2 equal to results in page 3
        Assert.assertEquals(numberOfResultsPage2.equals(numberOfResultsPage3),true);
    }

    @And("There is different search suggestions at the end of the page")
    public void searchSuggestions() {
        wait.waitVisibilityOfElement(search.relatedSearches(), 15);
        //assert that related search header is displayed
        search.relatedSearches().isDisplayed();
        //assert related search header is equal to 'Related searches'
        Assert.assertEquals(search.relatedSearches().getText().equals("Related searches"), true);
        //assert search suggestions is displayed
        search.searchSuggestionsCard().isDisplayed();
    }

}
