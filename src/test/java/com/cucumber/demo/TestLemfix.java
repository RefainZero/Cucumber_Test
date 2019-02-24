package com.cucumber.demo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TestLemfix {

    WebDriver driver;
    
    @Given("^I navigated to lemfix site$")
    public void i_navigated_to_lemfix_site() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://fm.lemfix.com");
    }

    @When("^I input \"([^\"]*)\" and \"([^\"]*)\" to login$")
    public void i_input_vincent_and_password_to_login(String us_name, String us_psswd) throws Throwable {
        WebElement loginTop;
        WebElement username;
        WebElement password;
        WebElement loginBTN;
        loginTop = driver.findElement(By.linkText("登录"));
        loginTop.click();
        username = driver.findElement(By.id("name"));
        password = driver.findElement(By.id("pass"));
        loginBTN = driver.findElement(By.xpath("//*[@id=\"signin_form\"]/div[3]/input"));
        username.sendKeys(us_name);
        password.sendKeys(us_psswd);
        loginBTN.click();
        
        Thread.sleep(1000);
    }

    @Then("^I verify login \"([^\"]*)\"")
    public void i_verify_login_result(String rs) throws Throwable {
        String title = driver.getTitle();
        String result;
        if(title.contains("lemfix致力打造最专业的测试技术社区")){
            result = "fail";
        }else if(title.equals("Lemfix")){
            result = "success";
        }else{
            result = null;
        }
        System.out.println(title);
        System.out.println("result=" + result);
        Assert.assertTrue(result.equals(rs));
        Thread.sleep(1000);
        driver.quit();
    }
}