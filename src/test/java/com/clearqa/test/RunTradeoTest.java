package com.clearqa.test;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/*import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@Cucumber.Options(
		features = "classpath:features",
		format = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"},
		tags = {}
		)*/
@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber-html-report"})
public class RunUlcTest {
}
