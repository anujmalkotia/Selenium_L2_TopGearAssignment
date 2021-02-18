package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "D:\\Selenium\\QET_CoE_Selenium_L2\\src\\test\\java\\Resources",
		glue = {"TestCases"}
)

public class runner
{
	
}