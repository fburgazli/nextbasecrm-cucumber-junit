package com.nextbasecrm.pages;


import com.nextbasecrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement inputLogin;

    @FindBy(name = "USER_PASSWORD")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='errortext']")
    public WebElement invalidLoginErrorText;

    @FindBy(id = "USER_REMEMBER")
    public WebElement rememberMeCheckBox;

    @FindBy(xpath = "//a[@class='login-link-forgot-pass']")
    public WebElement forgotPasswordLink;

    public static void login(String username,String password){
        LoginPage loginPage = new LoginPage();
        loginPage.inputLogin.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
        loginPage.loginButton.click();
    }
}
