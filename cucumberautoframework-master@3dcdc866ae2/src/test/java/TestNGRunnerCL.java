import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@CucumberOptions(features = {"src/Feature"},
        glue = {"com.cucumber.stepdefinition"},
        
        tags = {"@Atlas_LoginScenario"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/Extentreport.html","json:target/cucumber-reports/cucumber.json"},
        monochrome = true)

public class TestNGRunnerCL extends AbstractTestNGCucumberTests {
        @Test
        public void run_cukes(){
                new TestNGCucumberRunner(getClass()).runCukes();
        }
}
