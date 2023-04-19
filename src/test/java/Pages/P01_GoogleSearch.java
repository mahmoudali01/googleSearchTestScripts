package Pages;

import stepDef.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_GoogleSearch {

    public WebElement searchField(){
        return Hook.driver.findElement(By.id("APjFqb"));
    }
    public WebElement englishLocalization(){
        return Hook.driver.findElement(By.linkText("English"));
    }
    public WebElement resultStats(){
        return Hook.driver.findElement(By.id("result-stats"));
    }
    public WebElement relatedSearches(){
        //return Hook.driver.findElement(By.cssSelector("div#bres>div:nth-of-type(2)>div>div>div>div>div>div>span"));
        return Hook.driver.findElement(By.xpath("//span[text()='Related searches']"));
    }
    public WebElement searchSuggestionsCard(){
        return Hook.driver.findElement(By.className("y6Uyqe"));}

    public WebElement paginatorPage2(){
        return Hook.driver.findElement(By.cssSelector("div#botstuff>div>div:nth-of-type(2)>table>tbody>tr>td:nth-of-type(3)>a"));

       // return Hook.driver.findElement(By.xpath("//table[@role='presentation']//a"));

//        return Hook.driver.findElement(By.xpath("//a[@class='fl'])[2]"));
    }
    public WebElement paginatorPage3(){
return Hook.driver.findElement(By.cssSelector("div#botstuff>div>div:nth-of-type(2)>table>tbody>tr>td:nth-of-type(4)>a"));
//        return Hook.driver.findElement(By.xpath("//a[@class='fl'])[3]"));
      //  return Hook.driver.findElement(By.xpath("//table[@role='presentation']//a)[2]"));

    }


}
