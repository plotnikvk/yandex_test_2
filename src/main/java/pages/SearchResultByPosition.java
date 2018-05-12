package pages;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import utils.Stash;

/**
 * Created by plotnikvk .
 */

public  class SearchResultByPosition extends BasePage {

    SearchResultByPosition() {
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='n-snippet-card2__title']/a")
    private List<WebElement> result;

    @FindBy(xpath = "//div[@class='n-snippet-cell2__title']/a")
    private List<WebElement> result2;

    @FindBy(xpath = "//input[@id='header-search']")
    private WebElement searchWindow;

    @FindBy(xpath = "//span[text()='Найти']/ancestor::button")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='n-title__text']//h1")
    private WebElement searchedElement;



    //Выбираем 1 элемент из коллекции в 12 элементов, которую получаем по ссылке
    public void chooseItemByPositionAndSearchAndCheck(int position, String value)
    {
        if(value=="Т") {
            Asserts.check(true, String.valueOf(result.size()), 12);//Проверяем что элементов 12
            String Item = result.get(position - 1).getText();//Запоминаем позицию из коллекции
            searchWindow.sendKeys(Item);//Ищем товар по запомненному значению
            searchButton.click();
            Asserts.check(true, Item, searchedElement.getText());//Проверка: наименование соответствует запомненному значению
        }
        else{
            Asserts.check(true, String.valueOf(result2.size()), 12);//Проверяем что элементов 12
            String Item2 = result2.get(position - 1).getText();//Запоминаем позицию из коллекции
            searchWindow.sendKeys(Item2);//Ищем товар по запомненному значению
            searchButton.click();
            Asserts.check(true, Item2, searchedElement.getText());//Проверка: наименование соответствует запомненному значению
        }
    }


}
