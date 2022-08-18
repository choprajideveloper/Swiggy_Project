package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	@CucumberOptions(features = "src/Features/Add_Item_To_Cart.feature", 
			glue = { "StepDefinition"}, 
			monochrome = true, 
			plugin = { "pretty","html:target/CucumberReports.html", "json:target/reports.json"}
			)
			public class SwiggyTestRunner extends AbstractTestNGCucumberTests {

			}


