package com.nextbasecrm.step_definitions;

import com.nextbasecrm.pages.LoginPage;
import com.nextbasecrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import javax.swing.*;

public class LoginPage_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User is on nextbasecrm login page")
    public void user_is_on_nextbasecrm_login_page() {
        Driver.getDriver().get("https://login2.nextbasecrm.com/");
    }

    @When("User enter valid {string} and {string}")
    public void user_enter_valid_credentials(String username, String password) {
        LoginPage.login(username,password);
    }

    @Then("User should be able to login")
    public void user_should_be_able_to_login() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle= "Portal";
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    @Then("close the browser")
    public void close_the_browser() {
       Driver.closeDriver();
    }

    @When("User enter invalid {string} or {string}")
    public void userEnterInvalidOr(String username, String password) {
        LoginPage.login(username,password);
    }

    @Then("User should NOT able to login")
    public void userShouldNOTAbleToLogin() {

        String actualMessage = loginPage.invalidLoginErrorText.getText();
        String expectedMessage= "Incorrect login or password";
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("User clicks on Remember me on this computer checkbox")
    public void userClicksOnRememberMeOnThisComputerCheckbox() {
        loginPage.rememberMeCheckBox.click();
    }

    @Then("Remember me on this computer is selected with a tick")
    public void rememberMeOnThisComputerIsSelectedWithATick() {
        Assert.assertTrue(loginPage.rememberMeCheckBox.isSelected());
    }

    @When("User clicks on FORGOT YOUR PASSWORD? link")
    public void userClicksOnFORGOTYOURPASSWORDLink() {
        loginPage.forgotPasswordLink.click();
    }

    @Then("User navigated to Get Password page")
    public void userNavigatedToGetPasswordPage() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle= "Get Password";
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
