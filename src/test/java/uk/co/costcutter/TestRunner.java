package uk.co.costcutter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/features/storefinder"},
    tags = {"@PostcodeFirstPart"},
    plugin = {"pretty", "html:target/cucumber"})
public class TestRunner {

}
