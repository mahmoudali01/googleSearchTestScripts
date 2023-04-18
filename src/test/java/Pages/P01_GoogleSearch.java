package Pages;

import stepDef.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_GoogleSearch {

    public WebElement searchField(){
        return Hook.driver.findElement(By.id("APjFqb"));
    }
    public WebElement searchBTN(){
        return Hook.driver.findElement(By.xpath("//input[@name='btnK'])[2]"));
    }
    public WebElement searchIcon(){return Hook.driver.findElement(By.className("Tg7LZd"));}
    public WebElement resultStats(){
        return Hook.driver.findElement(By.id("result-stats"));
    }
    public WebElement relatedSearches(){return Hook.driver.findElement(By.xpath("//span[contains(@class,'mgAbYb OSrXXb')])[3]"));}
    public WebElement searchSuggestionsCard(){
        //y6Uyqe
        return Hook.driver.findElement(By.className("EIaa9b"));}

    public WebElement paginatorPage2(){
        return Hook.driver.findElement(By.xpath("//a[@class='fl'])[2]"));
    }
    public WebElement paginatorPage3(){
        return Hook.driver.findElement(By.xpath("//a[@class='fl'])[3]"));
    }


}
