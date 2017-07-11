package Cucumber_test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="Feature", glue="stepDefinition")
public class Test_Runner extends AbstractTestNGCucumberTests
{
}
