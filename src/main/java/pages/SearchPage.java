package pages;

import org.apache.http.util.Asserts;
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

public class SearchPage extends BasePage{

    SearchResultByPosition spr;

    public SearchPage (){
        driver = Stash.getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,3);
        spr = new SearchResultByPosition();
    }
    @FindBy(xpath = "//a[@data-id='market']")
    public WebElement marketLink;

    @FindBy(xpath = "//a[@class='link topmenu__link'][contains(text(),'Электроника')]")
    public WebElement electronicsLink;

    @FindBy(xpath = "//div[@class='catalog-menu__list']/a[@class='link catalog-menu__list-item metrika i-bem metrika_" +
            "js_inited'][text()='Наушники и Bluetooth-гарнитуры']")
    public WebElement headphonesLink;

    @FindBy(xpath = "//a[(text()='Перейти ко всем фильтрам')]")
    public WebElement goToAllFilters;

    @FindBy(xpath = "//input[@name='glf-pricefrom-var']")
    public WebElement priceWindow;

    @FindBy(xpath = "//label[@class='checkbox__label'][text()='Sennheiser']")
    public WebElement manufacturerSennheiser;
    @FindBy(xpath = "//span[text()='Показать подходящие']//ancestor::a[@role='button']")
    public WebElement showMe;

    @FindBy(xpath = "//span[text()='Показывать по 48']//ancestor::button[@role='listbox']")
    public WebElement showBy48;

    @FindBy(xpath = "//span[@class ='select__text' and contains(text(),'Показывать по 12')]")
    public WebElement showBy12;

    @FindBy(xpath = "//input[@id='header-search']")
    public WebElement searchWindow;

    @FindBy(xpath = "//span[text()='Найти']/ancestor::button")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='n-title__text']//h1")
    public WebElement searchedElement;

    public void searchFinalPage() {
       this.marketClick();
        electronicsLink.click();//Выбираем раздел "Электроника"
        headphonesLink.click();//Выбираем категорию "Наушники"
        goToAllFilters.click();//Нажимаем перейти ко всем фильтрам
        priceWindow.sendKeys("5000");//Задаем параметр поиска от 5000
        manufacturerSennheiser.click();//Жмем галочку "Sennheiser"
        showMe.click();//Жмем "Показать подходящие"
        showBy48.click();//Жмем "показывать по 48", чтобы выбрать "показывать по 12"
        wait.until(ExpectedConditions.visibilityOf(showBy48));
        showBy12.click();//Выбираем показывать по 12
        Asserts.check(true, String.valueOf(spr.howManyPositions()), 12);//Проверяем что элементов 12
        spr.chooseItemByPosition(1);//Выбор наименования товара из коллекции по номеру позиции
        String Item = spr.name;//Запоминаем позицию из коллекции
        searchWindow.sendKeys(Item);//Ищем товар по запомненному значению
        searchButton.click();
        Asserts.check(true, Item ,searchedElement.getText());//Проверка: наименование соответствует запомненному значению
    }
    public SearchPage marketClick(){
        marketLink.click();//Переходим в "Яндекс Маркет"
        return this;
    }
}
