package com.cucumber.demo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * @author rongrong
 * cucumber参数化使用
 */
public class TestParamDemo {

    int temp;
    @Given("^打开计算器进行计算$")
    public void openCalc() {
        System.out.println("打开计算器进行计算");
    }

    @When("^输入 \"([^\"]*)\" and \"([^\"]*)\" 并计算结果$")
    public int addition(int a1, int a2) {
        System.out.println("输入数字 "+a1+" \t "+"输入数字 "+a2);
        temp=a1 + a2;
        return temp;
    }

    @Then("^等待计算结果 \"([^\"]*)\" $")
    public void verify_result(int result) {
        //验证实际计算和预期结果是否一致
        if(temp==result){
            Assert.assertEquals(temp,result);
            System.out.println("结果验证一致");
        }else {
            System.out.println("结果验证不一致");
        }
    }
}