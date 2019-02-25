package com.cucumber.demo;

import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
//加入注释语句位置，不能运行所有用例集合
//@RunWith(Cucumber.class)
@ContextConfiguration("classpath:cucumber.xml")
@CucumberOptions(
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/extent-report/report.html"},//1
        format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},//2
        features = {"src/test/resources/feature/"},
        glue = {"com.cucumber.demo","com.po.demo"},
        monochrome = true)
public class RunCukesTest extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setup() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("target/extent-report/myreport.html");
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);

    }

    @AfterClass
    public static void tearDown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));//1
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }

}