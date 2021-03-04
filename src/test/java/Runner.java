import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "classpath:.", glue = "stepdefination",
        plugin = {"pretty", "html:taget/cucumber-reports"},tags = "@WebserviceTest")
public class Runner {

}