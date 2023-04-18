package stepDef;

import Pages.P01_GoogleSearch;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class D01_GoogleSearch {
    P01_GoogleSearch search = new P01_GoogleSearch();
    @Given("^User Navigate to \"(.*)\"$")
    public void navigateToGoogle(String URL){
        Hook.driver.get(URL);
    }
    @When("^User enter keyword \"(.*)\" & Click search$")
    public void enterKeywordAndSearch(String keyword){
      search.searchField().sendKeys(keyword);
      search.searchBTN().click();
    }
    @And("^Clear search field & search another keyword \"(.*)\"$")
    public void clearAndSearchAnotherKeyword(String keyword){
        search.searchField().clear();
        search.searchField().sendKeys(keyword);
        search.searchIcon().click();
    }
    @And("Click page 2 from paginator")
    public void clickPage2(){
        search.paginatorPage2().click();
    }
    @Then("Number of results exist on UI")
    public void numberOfResults(){
        search.resultStats().isDisplayed();
    }
    @And("Click on page 3 and check number of results equals to page2")
    public void clickPage3(){
        search.paginatorPage3().click();
    }
    @And("There is different search suggestions at the end of the page")
    public void searchSuggestions(){
        search.relatedSearches().isDisplayed();
        Assert.assertEquals(search.relatedSearches().getText().equals("Related searches"),true);
        search.searchSuggestionsCard().isDisplayed();
    }

}
