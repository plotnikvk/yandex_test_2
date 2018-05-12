package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Stash;

 class MainPage extends BasePage {
    public MainPage(){
        driver = Stash.getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,3);
    }

    @FindBy(xpath = "//a[@data-id='market']")
    private WebElement marketLink;

    public SearchPage marketClick(){
        marketLink.click();//Переходим в "Яндекс Маркет"
        return new SearchPage();
    }

}
