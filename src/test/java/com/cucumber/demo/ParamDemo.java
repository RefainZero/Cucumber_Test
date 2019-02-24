package com.cucumber.demo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParamDemo {

    WebDriver driver;

    @Given("^用户正停留在360影视登录页$")
    public void goToCsdn() {
        driver = new ChromeDriver();
        driver.navigate().to("https://i.360kan.com/login");
        driver.manage().window().maximize();
    }

    @When("^用户输入用户名 \"(.*)\"$")
    public void enterUsername(String arg1) {
        driver.findElement(By.name("loginname")).sendKeys(arg1);
    }

    @When("^用户输入密码 \"(.*)\"$")
    public void enterPassword(String arg1) {
        driver.findElement(By.name("loginpassword")).sendKeys(arg1);
        driver.findElement(By.linkText("立即登录")).click();
    }

    @Then("^登录失败，提示手机号不合法$")
    public void checkFail() {
        String msg=driver.findElement(By.xpath("//p[@class='b-signin-error js-b-signin-error error-2']")).getText();
        Assert.assertEquals("输入手机号不合法",msg);
        driver.close();
    }
}
