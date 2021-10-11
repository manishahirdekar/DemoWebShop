package testSuiteBDD;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features=("src/test/java/testSuiteBDD/WebShopFinal.feature"),
		glue= {"testSuiteBDD"},
		tags= "@DemoWebShop"
		)
@RunWith(Cucumber.class)
public class FinalRunnerDemo extends AbstractTestNGCucumberTests
{  
	
}
