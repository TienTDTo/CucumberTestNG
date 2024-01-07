package com.tientd0802.CucumberAF.steps;

import com.tientd0802.CucumberAF.pageObjects.InventoryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class InventoryStep {

    @Autowired
    @Lazy
    InventoryPage inventoryPage;

    @Then("Verify Inventory page is displayed")
    public void verifyInventoryPageIsDisplayed(){
        inventoryPage.verifyInventoryItemNameIsDisplayed();
    }


    @When("^User select price filter (.+)$")
    public void userSelectPriceFilter(String filter) {
        inventoryPage.selectPriceFilter(filter);
    }

    @Then("^Verify that products are sorted by (.+)$")
    public void verifyThatProductsAreSortedBy(String filter) {
        inventoryPage.verifySortedPrice(filter);
    }
}
