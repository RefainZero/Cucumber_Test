package com.cucumber.demo;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * cucumber使用初探
 */
public class CalculatorDemo {

    @Given("^打开计算器面板$")
    public void openCalculator() throws Exception {
        System.out.println("打开计算器面板");
    }

    @When("^已经输入1并按下+")
    public void alreadyInput1() {
        System.out.println("已经输入1并按下+");
    }


    @And("^输入 \"([^\"]*)\"$")
    public void input1(String num) throws Throwable {
        System.out.println("输入" + num);
    }

    @And("^按下=")
    public void pressEaualButton() {
        System.out.println("按下=");
    }

    @Then("^等待计算结果")
    public void wait_the_query_result() throws InterruptedException {
        System.out.println("等待计算结果");
    }

}
