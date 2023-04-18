package Pages;

import StepDef.Hook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_GoogleSearch {

    public WebElement searchField(){
        return Hook.driver.findElement(By.name("q"));
    }
    public WebElement searchIcon(){
        return Hook.driver.findElement(By.name("iblpc"));
    }
    public WebElement searchBTN(){
        return Hook.driver.findElement(By.xpath("//input[@name='btnK'])[2]"));
    }
    public WebElement resultStats(){
        return Hook.driver.findElement(By.id("result-stats"));
    }
    public WebElement page2(){
        return Hook.driver.findElement(By.xpath("//a[@class='fl'])[2]"));
    }

}
