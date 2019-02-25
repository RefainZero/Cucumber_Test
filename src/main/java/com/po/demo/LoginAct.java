package com.po.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author rongrong
 * 360登录首页
 */
public class LoginAct extends LoginPage{

    public void inputUserName(String str) {
        sendKeys(getUserName(),str);
    }

    public void inputPassWord(String str) {
        sendKeys(getPasswd(),str);
    }

    public void clickButton() {
        click(getLoginButton());
    }

    public String checkTip() {
        return getText(getCheckTips());
    }

}
