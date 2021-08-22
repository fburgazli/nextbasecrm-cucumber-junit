package com.nextbasecrm.pages;

import com.nextbasecrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PollPage {
    public PollPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "question_0")
    public WebElement question1Box;

    @FindBy(id = "answer_0__0_")
    public WebElement answer1Box;

    @FindBy(id="answer_0__1_")
    public WebElement answer2Box;

    @FindBy(id="answer_0__2_")
    public WebElement answer3Box;

    @FindBy(id="answer_0__3_")
    public WebElement answer4Box;

    @FindBy(id = "multi_0")
    public WebElement allowMultipleChoiceCheckbox;

    @FindBy(linkText = "Add question")
    public WebElement addQuestionLink;

    @FindBy(id = "question_1")
    public WebElement question2Box;

    @FindBy(id="answer_1__0_")
    public WebElement q2_answer1Box;

    @FindBy(id="answer_1__1_")
    public WebElement q2_answer2Box;


}
