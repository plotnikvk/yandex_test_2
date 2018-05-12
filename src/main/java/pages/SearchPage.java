package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Stash;

/**
 * Created by plotnikvk
 */

class SearchPage extends BasePage{

    SearchPage (){
        driver = Stash.getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,3);
    }

    @FindBy(xpath = "//div[@class='topmenu i-bem topmenu_margin-bottom_no topmenu_js_inited']")
    private WebElement mainMenu;

    public MiddleResultPage selectMainMenu(String itemName){
        mainMenu.findElement(By.xpath(".//a[@class='link topmenu__link'][contains(text(),'"+itemName+"')]")).click();
        return new MiddleResultPage();
    }
}
