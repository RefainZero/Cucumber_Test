import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.AfterClass;

import java.io.File;

@RunWith(Cucumber.class)
@ContextConfiguration("classpath:cucumber.xml")
@CucumberOptions(
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/extent-report/report.html"},//1
        format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},//2
        features = {"src/test/resources/feature/"},
        glue = {"com.cucumber"}


        //tags = {
        //        "~@performance","~@skip"
        //}
)
public class RunCukesTest{

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