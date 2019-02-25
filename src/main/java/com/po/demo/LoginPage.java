package com.po.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author rongrong
 * 360登录首页
 */
public class LoginPage extends BaseStep{

    @FindBy(name = "loginname")
    WebElement userName;

    @FindBy(name = "loginpassword")
    WebElement passwd;

    @FindBy(linkText = "立即登录")
    WebElement loginButton;

    @FindBy(xpath = "//p[@class='b-signin-error js-b-signin-error error-2']")
    WebElement checkTips;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPasswd() {
        return passwd;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getCheckTips() {
        return checkTips;
    }
}
