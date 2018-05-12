package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Stash;

 class SettingsPage extends BasePage {

    SettingsPage(){
        driver = Stash.getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,3);
    }

    @FindBy(xpath = "//input[@name='glf-pricefrom-var']")
    private WebElement priceWindow;

    @FindBy(xpath = "//div")
    private WebElement manufacturerItem;

    @FindBy(xpath = "//span[text()='Показать подходящие']//ancestor::a[@role='button']")
    private WebElement showMe;

    @FindBy(xpath = "//span[text()='Показывать по 48']//ancestor::button[@role='listbox']")
    private WebElement showBy48;

    @FindBy(xpath = "//span[@class ='select__text' and contains(text(),'Показывать по 12')]")
    private WebElement showBy12;

    public SearchResultByPosition selectFilters(String price,String manufacturers){
        priceWindow.sendKeys(price);
        WebElement m1 = manufacturerItem.findElement(By.xpath("//label[@class='checkbox__label'][contains(text(),'"
                +manufacturers+"')]"));
        m1.click();
        showMe.click();
        showBy48.click();//Жмем "показывать по 48", чтобы выбрать "показывать по 12"
        wait.until(ExpectedConditions.visibilityOf(showBy48));
        showBy12.click();//Выбираем показывать по 12
        return new SearchResultByPosition();
    }

    public SearchResultByPosition selectFilters(String price,String manufacturers1,String manufacturers2 ){
        priceWindow.sendKeys(price);
        wait.until(ExpectedConditions.visibilityOf(priceWindow));
        WebElement m1 = manufacturerItem.findElement(By.xpath("//label[@class='checkbox__label'][contains(text(),'"
                +manufacturers1+"')]"));
        m1.click();
        WebElement m2 = manufacturerItem.findElement(By.xpath("//label[@class='checkbox__label'][contains(text(),'"
                +manufacturers2+"')]"));
        m2.click();
        showMe.click();//Нажимаем "Показать подходящие"
        showBy48.click();//Жмем "показывать по 48", чтобы выбрать "показывать по 12"
        wait.until(ExpectedConditions.visibilityOf(showBy48));
        showBy12.click();//Выбираем показывать по 12
        return new SearchResultByPosition();
    }
}
