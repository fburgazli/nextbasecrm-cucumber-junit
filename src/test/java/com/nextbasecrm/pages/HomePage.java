package com.nextbasecrm.pages;

import com.nextbasecrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "feed-add-post-form-tab-message")
    public WebElement messageTab;

    @FindBy(id ="feed-add-post-form-tab-vote")
    public WebElement pollTab;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iframe;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageBody;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(id = "blog-submit-button-cancel")
    public WebElement cancelButton;

    @FindBy(id = "bx-b-link-blogPostForm")
    public WebElement attachLinkToMessage;

    @FindBy(id = "linkidPostFormLHE_blogPostForm-text")
    public WebElement linkText;

    @FindBy(id = "linkidPostFormLHE_blogPostForm-href")
    public WebElement linkURL;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement linkSaveButton;

    @FindBy(id = "feed-add-post-destination-input")
    public WebElement toBox;

    @FindBy(id = "bx-destination-tag")
    public WebElement toBoxAddMoreButton;

    @FindBy(linkText = "Comment")
    public WebElement commentButton;

    @FindBy(xpath = "//button[contains(@id,'lhe_button_submit_blogCommentForm')]")
    public WebElement sendCommentButton;

    @FindBy(xpath = "//span[contains(@id,'bx-b-uploadfile-blogCommentForm')]")
    public WebElement uploadFilesButton;

    @FindBy(xpath = "//div[contains(@id,'blog_post_body')]")
    public List<WebElement> sentMessageBody;

    @FindBy(id = "search-textbox-input")
    public WebElement searchBox;

    @FindBy(id = "pagetitle")
    public WebElement pageTitleAfterSearch;

    @FindBy(id = "feed-empty-wrap")
    public WebElement nothingFoundMessage;

    @FindBy(xpath = "(//span[@class='bx-vote-block-inp-substitute'])[1]")
    public WebElement pollOption1;

    @FindBy(xpath = "(//span[@class='bx-vote-block-inp-substitute'])[2]")
    public WebElement pollOption2;

    @FindBy(xpath = "//div[@class='bx-vote-buttons']/button[2]")
    public WebElement voteButton;

    @FindBy(xpath = "//div[@class='bx-vote-buttons']/button[1]")
    public WebElement voteAgainButton;

    @FindBy(xpath = "//button[.='Stop']")
    public WebElement stopButton;

    @FindBy(xpath = "//button[.='Results (xls)']")
    public WebElement resultsButton;


}
