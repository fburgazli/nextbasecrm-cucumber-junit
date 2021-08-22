package com.nextbasecrm.step_definitions;

import com.nextbasecrm.pages.TimeManagementPage;
import com.nextbasecrm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class TimeManagementPage_StepDefinitions {

    TimeManagementPage timeManagementPage = new TimeManagementPage();

    @When("user clicks on Clock in button")
    public void user_clicks_on_clock_in_button() {
        timeManagementPage.clockInButton.click();
    }
    @Then("user should be able to clock in")
    public void user_should_be_able_to_clock_in() {
        String expected ="WORKING";
        Driver.getDriver().navigate().refresh();
        String actual = timeManagementPage.timeManStatus.getText();
        Assert.assertEquals(expected,actual);
    }

    @When("user clicks on Clock out button")
    public void user_clicks_on_clock_out_button() {
        timeManagementPage.clockOutButton.click();
    }
    @Then("user should be able to clock out")
    public void user_should_be_able_to_clock_out() {
        String expected ="CLOCKED OUT";
        Driver.getDriver().navigate().refresh();
        String actual = timeManagementPage.timeManStatus.getText();
        Assert.assertEquals(expected,actual);
    }
    @When("user clicks on time management tab")
    public void user_clicks_on_time_management_tab() {
        timeManagementPage.timeManStatus.click();
    }
    @When("user creates a new task {string}")
    public void user_creates_a_new_task(String newTask) {
       timeManagementPage.inputNewTask.sendKeys(newTask);
       timeManagementPage.newTaskSubmitButton.click();
    }
    @Then("user should be able to see new task {string} is created")
    public void user_should_be_able_to_see_new_task_is_created(String newTask) {
        String actualCreatedTask = Driver.getDriver().findElement(By.xpath("//a[.='"+newTask+"']")).getText();
        Assert.assertEquals(newTask,actualCreatedTask);
    }

    @When("user creates a new event {string} with start time {string} and end time {string}")
    public void user_creates_a_new_event(String newEvent,String startTime ,String endTime) {
        timeManagementPage.newEventStartTime.clear();
        timeManagementPage.newEventStartTime.sendKeys(startTime);
        timeManagementPage.newEventEndTime.clear();
        timeManagementPage.newEventEndTime.sendKeys(endTime);
        timeManagementPage.newEventTitleBox.clear();
        timeManagementPage.newEventTitleBox.sendKeys(newEvent);
        timeManagementPage.newEventSubmitButton.click();


    }
    @Then("user should be able to see new event {string} is created")
    public void user_should_be_able_to_see_new_event_is_created(String newEvent) {
        Driver.getDriver().navigate().refresh();
        timeManagementPage.timeManStatus.click();
        String actualCreatedTask = Driver.getDriver().findElement(By.xpath("//span[@class='tm-popup-event-text']")).getText();
        Assert.assertEquals(newEvent,actualCreatedTask);
    }

}
