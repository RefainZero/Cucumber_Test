package com.po.demo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * rongrong
 * cucumber+java+po模式练习案例
 */
public class LoginTest extends LoginAct {

    @Given("^打开chrome浏览器，进入360首页$")
    public void openBrower() {
        open();
    }

    @When("^输入 \"([^\"]*)\" and \"([^\"]*)\" 并点击登录$")
    public void login(String userName, String passWord) {
        //输入用户名
        inputUserName(userName);
        //输入密码
        inputPassWord(passWord);
        //点击登录
        clickButton();
    }

    @Then("^验证登录结果 \"([^\"]*)\"")
    public void verify_result(String result) {
        //验证登录是否成功
        Assert.assertEquals(checkTip(), result);
        //程序暂停等待文本
        pause(3);
        //退出浏览器
        quit();
    }
}
