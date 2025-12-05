package co.com.pragma.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features/serebii.feature")
@IncludeTags("WebMobile")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "co.com.pragma.stepdefinitions")
public class SerebiiWebRunner {
}