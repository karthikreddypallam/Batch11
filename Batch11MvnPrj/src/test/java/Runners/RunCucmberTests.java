package Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"StepDefinitions"},
		tags = {"@sfL"},
		plugin = {"json:output/cucumber.json"},
		format = {"pretty", "html:target/Destination"},
		monochrome = true
		)
public class RunCucmberTests {

	
	
}
