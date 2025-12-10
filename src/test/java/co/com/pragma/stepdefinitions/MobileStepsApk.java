package co.com.pragma.stepdefinitions;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import co.com.pragma.tasks.LoginApp;
import co.com.pragma.userinterface.LoginAPK;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MobileStepsApk {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el usuario abre la app de Swag Labs")
    public void openApp() {
        OnStage.theActorCalled("Usuario Movil");
    }

    @When("ingresa el usuario {string} y clave {string}")
    public void login(String user, String pass) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginApp.withCredentials(user, pass)
        );
    }

    @Then("deberia ver la lista de productos")
    public void verifyLogin() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(LoginAPK.PRODUCT_TITLE).isDisplayed()
        );
    }
}
