package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import utils.Stash;

/**
 * Created by plotnikvk .
 */

public class SearchResultByPosition extends BasePage {
    String name;
    Integer size;


    public SearchResultByPosition() {
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='n-snippet-cell2__title']/a")
    List<WebElement> result;

    //Выбираем 1 элемент из коллекции в 12 элементов, которую получаем по ссылке
    public String chooseItemByPosition(int position)
    {
        return name = result.get(position-1).getText();
    }

    public Integer howManyPositions(){
        return
                size = result.size();
    }
}
