package com.po.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/13.
 * 登录页面
 */
public class BaseStep {

    WebDriver driver;
    public final String URL="https://i.360kan.com/login";

    public BaseStep() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL);
    }

    public void quit() {
        driver.quit();
    }

    public void sendKeys(WebElement element, String str) {
        element.clear();
        element.sendKeys(str);
    }

    public void click(WebElement element) {
        element.click();
    }

    public String getText(WebElement element ) {
        return element.getText();
    }

    public void pause(int i) {
        try {
            Thread.sleep(1000*i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
