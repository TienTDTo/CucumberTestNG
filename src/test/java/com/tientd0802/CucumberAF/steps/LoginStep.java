package com.tientd0802.CucumberAF.steps;

import com.tientd0802.CucumberAF.customAnotation.LazyAutowire;
import com.tientd0802.CucumberAF.pageObjects.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Map;

public class LoginStep {


    @Autowired
    @Lazy
    LoginPage loginPage;


    @Given("User access to login page")
    public void accessToLoginPage(){
        loginPage.accessToLoginPage();
    }

    @When("^User type (.+) into Username field$")
    public void enterUsername(String username){
        loginPage.enterUsername(username);
    }

    @When("^User type (.+) into Password field$")
    public void enterPassword(String password){
        loginPage.enterPassword(password);
    }


    @When("User click on login button")
    public void clickOnLoginButton(){
        loginPage.clickOnLoginButton();
    }

    @Then("^Verify Error Message is displayed with message (.+)$")
    public void verifyErrorMessage(String errorMessage){
        loginPage.verifyErrorMessage(errorMessage);
    }

    @Given("I have a List of names")
    public void iHaveAListOfNames(DataTable dataTable) {
        List<String> rows = dataTable.asList();
        for (String name: rows){
            System.out.println(name);
        }
    }

    @Given("I have a List of names and age")
    public void iHaveAListOfNamesAndAge(DataTable dataTable) {
        List<Map<String,String>> maps = dataTable.asMaps(String.class, String.class);
        for (Map<String,String> column: maps){
            System.out.println(column);
        }

        List<List<String>> rows = dataTable.asLists(String.class);
        for (List<String> columns : rows){
            System.out.println(columns.get(0) +" "+columns.get(1));
        }
    }
}
