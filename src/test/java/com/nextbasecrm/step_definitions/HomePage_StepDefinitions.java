package com.nextbasecrm.step_definitions;

import com.github.javafaker.Faker;
import com.nextbasecrm.pages.HomePage;
import com.nextbasecrm.pages.LoginPage;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.Driver;
import com.nextbasecrm.utilities.Log;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage_StepDefinitions {
    HomePage homePage = new HomePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    String message = "";



    @When("User clicks on Message Tab")
    public void user_clicks_on_message_tab() {
        Log.info("User clicks on Message Tab");
        homePage.messageTab.click();

    }

    @When("User enters message body and click Send button")
    public void user_enters_message_body() {
        Faker faker = new Faker();
        message = faker.chuckNorris().fact();
        Driver.getDriver().switchTo().frame(homePage.iframe);
        homePage.messageBody.sendKeys(message);
        Driver.getDriver().switchTo().defaultContent();
        homePage.sendButton.click();

    }

    @Then("User should be able to see message sent")
    public void user_should_be_able_to_see_message_sent() {
        Driver.getDriver().navigate().refresh();
        List<WebElement> list = homePage.sentMessageBody;
        Assert.assertTrue(BrowserUtils.getElementsText(list).contains(message));
        //Driver.closeDriver();
    }

    @When("User enters message body and click Cancel button")
    public void user_enters_message_body_and_click_cancel_button() {
        Faker faker = new Faker();
        message = faker.chuckNorris().fact();
        Driver.getDriver().switchTo().frame(homePage.iframe);
        homePage.messageBody.sendKeys(message);
        Driver.getDriver().switchTo().defaultContent();
        homePage.cancelButton.click();
    }

    @Then("User should be able to see message NOT sent")
    public void user_should_be_able_to_see_message_not_sent() {
        Driver.getDriver().navigate().refresh();
        List<WebElement> list = homePage.sentMessageBody;
        Assert.assertTrue(!BrowserUtils.getElementsText(list).contains(message));
        //Driver.closeDriver();
    }

    @When("User enters message body and click Link button")
    public void user_enters_message_body_and_click_link_button() {
        message = "Good morning SDETs!\nKeep growing!\n";
        Driver.getDriver().switchTo().frame(homePage.iframe);
        homePage.messageBody.sendKeys(message);
        Driver.getDriver().switchTo().defaultContent();
        homePage.attachLinkToMessage.click();
        String linkURL = "https://www.youtube.com/watch?v=9NoDUUybUe8";
        String linkText = "Here's a beautiful song for y'all! Enjoy...";

        homePage.linkText.sendKeys(linkText);

        homePage.linkURL.sendKeys(linkURL);

        homePage.linkSaveButton.click();

        Driver.getDriver().switchTo().defaultContent();
        homePage.sendButton.click();
    }

    @When("User clicks on Comment tab and enters the message")
    public void user_clicks_on_comment_tab_and_enters_the_message() {
        homePage.commentButton.click();
        message = "Almost done...";
        Driver.getDriver().switchTo().frame(homePage.iframe);
        homePage.messageBody.sendKeys(message);


    }

    @When("User clicks on send comment button")
    public void user_clicks_on_send_comment_button() {
        BrowserUtils.sleep(3);
        Driver.getDriver().switchTo().defaultContent();
        homePage.sendCommentButton.click();
    }

    @Then("User should be able to send comment")
    public void user_should_be_able_to_send_comment() {
        Driver.getDriver().navigate().refresh();
        List<WebElement> comments = Driver.getDriver().findElements(By.xpath("//div[contains(@id,'record-BLOG') and @class='feed-com-text-inner-inner']"));
        System.out.println("BrowserUtils.getElementsText(comments) = " + BrowserUtils.getElementsText(comments));
        System.out.println("message = " + message);
        Assert.assertTrue(BrowserUtils.getElementsText(comments).contains(message));
    }

    @When("user is searching for {string}")
    public void user_is_searching_for(String string) {
        BrowserUtils.sleep(2);
        homePage.searchBox.sendKeys(string);
        BrowserUtils.sleep(2);
        homePage.searchBox.sendKeys(Keys.ENTER);
    }

    @Then("user should see {string} in result page")
    public void user_should_see_in_result_page(String expected) {
        BrowserUtils.sleep(3);
        String actual = homePage.pageTitleAfterSearch.getText();
        System.out.println("actual = " + actual);
        Assert.assertTrue(expected + " could not found in page!", actual.contains(expected));

    }

    @Then("user should see Nothing found in result page")
    public void user_should_see_nothing_found_in_result_page() {
        Assert.assertTrue(homePage.nothingFoundMessage.isDisplayed());
    }

    @When("user is searching for with the first letter {string}")
    public void user_is_searching_for_with_the_first_letter(String string) {
        Log.info("user enters just one letter...");
        BrowserUtils.sleep(2);
        homePage.searchBox.sendKeys(string);
    }
    @Then("user should see following sections in opened window")
    public void user_should_see_following_sections_in_opened_window(List<String> expectedList) {
        Log.info("check this out!");
        BrowserUtils.sleep(5);
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//div[@class='search-title-top-subtitle-text']"));

        System.out.println("expectedList = " + expectedList);
        System.out.println("BrowserUtils.getElementsText(list) = " + BrowserUtils.getElementsText(list));
        Assert.assertTrue(!list.isEmpty() && expectedList.containsAll(BrowserUtils.getElementsText(list)));

    }

    @When("user select an answer to vote the poll")
    public void user_select_an_answer_to_vote_the_poll() {
        if(homePage.pollOption1.isSelected()){
            homePage.pollOption2.click();
        }else {
            homePage.pollOption1.click();
        }
    }
    @When("user clicks Vote button")
    public void user_clicks_vote_button() {
       homePage.voteButton.click();
    }
    @Then("user should be able to see Vote Again button")
    public void user_should_be_able_to_see_vote_again_button() {
        wait.until(ExpectedConditions.visibilityOf(homePage.voteAgainButton));
       Assert.assertTrue(homePage.voteAgainButton.isDisplayed());
    }
    @When("user clicks Vote again button")
    public void user_clicks_vote_again_button() {
        homePage.voteAgainButton.click();
    }

    @Then("user can Stop the poll which he-she created")
    public void user_can_stop_the_poll_which_he_she_created() {

        homePage.stopButton.click();
    }


    @And("user should be able to see Results button is displayed")
    public void userShouldBeAbleToSeeResultsButtonIsDisplayed() {
    Assert.assertTrue(homePage.resultsButton.isDisplayed());
    }
}
