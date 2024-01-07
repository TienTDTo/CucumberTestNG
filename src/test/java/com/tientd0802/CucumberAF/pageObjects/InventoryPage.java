package com.tientd0802.CucumberAF.pageObjects;

import com.tientd0802.CucumberAF.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InventoryPage extends BasePage {

    @FindBys(@FindBy(className = "inventory_item_price"))
    List<WebElement> itemPrices;

    @FindBy(xpath = "//*[@class='title']")
    WebElement inventorySubTitle;

    @FindBy(className = "product_sort_container")
    WebElement filterSelector;

    public void verifyInventoryPageUrl(String fraction){
        pageActions.verifyCurrentUrlContainsFraction(fraction);
    }

    public void verifyInventoryItemNameIsDisplayed(){
        pageActions.verifyElementContainsText(inventorySubTitle, "Products");
    }

    public void selectPriceFilter(String filter){
        switch (filter){
            case "LOHI":
                pageActions.selectDropdownListItem(filterSelector, FilterValue.LOHI.name());
            case "HILO":
                pageActions.selectDropdownListItem(filterSelector, FilterValue.HILO.name());
        }
    }

    public void verifySortedPrice(String filter){
        List<String> textPrices = pageActions.getListInnerText(itemPrices);
        switch (filter){
            case "LOHI":
                Assert.assertTrue(isSortedList(textPrices,FilterValue.LOHI));
            case "HILO":
                Assert.assertTrue(isSortedList(textPrices,FilterValue.HILO));
        }
    }

    private boolean isSortedList(List<String> items, FilterValue orderBy){
        boolean isSorted = true;
        Iterator<String> iterator = items.iterator();
        float previous = Float.parseFloat(iterator.next());
        while(iterator.hasNext()){
            float nextItem = Float.parseFloat(iterator.next());
            switch (orderBy){
                case LOHI:
                    if(previous <= nextItem){
                        previous = nextItem;
                        continue;
                    }
                case HILO:
                    if(previous >= nextItem){
                        previous = nextItem;
                        continue;
                    }
            }
            isSorted = false;
        }
        return isSorted;
    }

    enum FilterValue{
        AZ,
        ZA,
        LOHI,
        HILO
    }
}
