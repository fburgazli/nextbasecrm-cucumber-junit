package com.nextbasecrm.step_definitions;

import com.nextbasecrm.pages.HomePage;
import com.nextbasecrm.pages.PollPage;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.Driver;
import com.nextbasecrm.utilities.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PollPage_StepDefinitions {

    HomePage homePage = new HomePage();
    PollPage pollPage = new PollPage();
    String message="";

    @When("user navigates to Poll page")
    public void user_navigates_to_poll_page() {
        homePage.pollTab.click();
    }
    @When("user writes {string} and question with options and click Send button")
    public void user_writes_message_and_question_with_options_and_click_send_button(String message) {
        this.message=message;
        Driver.getDriver().switchTo().frame(homePage.iframe);
        homePage.messageBody.sendKeys(message);
        Driver.getDriver().switchTo().defaultContent();
        pollPage.question1Box.sendKeys("What are you working today?");
        pollPage.answer1Box.sendKeys("Java review!");
        pollPage.answer2Box.sendKeys("Selenium/Cucumber review!");
        pollPage.answer3Box.sendKeys("SQL practice!");
        pollPage.answer4Box.sendKeys("Nadir's task!");
        pollPage.allowMultipleChoiceCheckbox.click();
        pollPage.addQuestionLink.click();
        pollPage.question2Box.sendKeys("Did you take Selenium quiz? (Due today!)");
        pollPage.q2_answer1Box.sendKeys("Yes!");
        pollPage.q2_answer2Box.sendKeys("Not yet!");
        homePage.sendButton.click();
    }

    @Then("user should be able to see Poll is sent")
    public void user_should_be_able_to_see_poll_is_sent() {
        Log.info("Poll sent!");
        Driver.getDriver().navigate().refresh();
        List<WebElement> list = homePage.sentMessageBody;
        Assert.assertTrue(!BrowserUtils.getElementsText(list).contains(message));
    }

    @Then("user get error message: The message title is not specified")
    public void user_get_error_message_the_message_title_is_not_specified() {
        String expectedErrorMessage="The message title is not specified";
        String actualErrorMessage = Driver.getDriver().findElement(By.xpath("//span[.='The message title is not specified']")).getText();
        Assert.assertEquals("Error message did not match!",expectedErrorMessage,actualErrorMessage);
    }

    @When("user check allow multiple Choice")
    public void user_check_allow_multiple_choice() {
        pollPage.allowMultipleChoiceCheckbox.click();
    }
    @Then("user should be able to see allow multiple Choice is selected")
    public void user_should_be_able_to_see_allow_multiple_choice_is_selected() {
        Assert.assertTrue(pollPage.allowMultipleChoiceCheckbox.isSelected());
    }

    @When("user click on add more questions link")
    public void user_click_on_add_more_questions_link() {
        pollPage.addQuestionLink.click();
    }
    @Then("user should be able to see another question added")
    public void user_should_be_able_to_see_another_question_added() {
        Assert.assertTrue(pollPage.question2Box.isDisplayed());
    }

    @When("user click on cancel button")
    public void user_click_on_cancel_button() {
       homePage.cancelButton.click();
    }
    @Then("user should not be able to see Cancel button on the page")
    public void user_should_not_be_able_to_see_cancel_button_on_the_page() {
        Assert.assertTrue(!homePage.cancelButton.isDisplayed());
    }


}
