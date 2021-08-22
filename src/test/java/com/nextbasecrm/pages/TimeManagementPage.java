package com.nextbasecrm.pages;

import com.nextbasecrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TimeManagementPage {
    public TimeManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='webform-small-button-text']")
    public  WebElement clockInButton;

    @FindBy(xpath = "//span[@class='webform-small-button-text']")
    public  WebElement clockOutButton;

    @FindBy(id = "timeman-status")
    public WebElement timeManStatus;

    @FindBy(xpath = "//input[@class='tm-popup-task-form-textbox']")
    public WebElement inputNewTask;

    @FindBy(xpath = "//span[@class='tm-popup-task-form-submit']")
    public WebElement newTaskSubmitButton;

    @FindBy(xpath = "//input[@class='tm-popup-event-start-time-textbox_am_pm']")
    public WebElement newEventStartTime;

    @FindBy(xpath = "//input[@class='tm-popup-event-end-time-textbox_am_pm']")
    public WebElement newEventEndTime;

    @FindBy(xpath = "//input[@class='tm-popup-event-form-textbox_am_pm']")
    public WebElement newEventTitleBox;

    @FindBy(xpath = "//span[@class='tm-popup-event-form-submit']")
    public WebElement newEventSubmitButton;


}
