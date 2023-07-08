package org.run;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Feature\\LoginPage.feature", glue = "org.step", dryRun = false, monochrome = false,

		plugin = { 
				"html:target\\HtmlReport", 
				"junit:target\\reportJunit.xml", 
				"json:target\\reportjson.json" 
				})

public class TestRunnerClass {

}
