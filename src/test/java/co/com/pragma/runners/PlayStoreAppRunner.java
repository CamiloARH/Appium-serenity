package co.com.pragma.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/playstore.feature",
        glue = "co.com.pragma.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@AppStore"
)
public class PlayStoreAppRunner {}
