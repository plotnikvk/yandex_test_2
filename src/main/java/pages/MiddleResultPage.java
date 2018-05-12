package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Stash;

public class MiddleResultPage extends BasePage {
public  String item;

    MiddleResultPage (){
        driver = Stash.getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,3);
    }

    @FindBy(xpath = "//div")
    private WebElement electronicsMenu;

    @FindBy(xpath = "//a[(text()='Перейти ко всем фильтрам')]")
    private WebElement goToAllFilters;

public SettingsPage selectElectronicsItem(String item){
    electronicsMenu.findElement(By.xpath("//div[@class='catalog-menu__list']/a[@class='link catalog-menu__list-item " +
            "metrika i-bem metrika_js_inited'][contains(text(),'"+item+"')]")).click();
    goToAllFilters.click();
    return new SettingsPage();
}
}
