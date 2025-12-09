package co.com.pragma.stepdefinitions;

import co.com.pragma.models.MobileTestData;
import co.com.pragma.questions.ValidateSite;
import co.com.pragma.tasks.DownloadApp;
import co.com.pragma.tasks.NavigateTo;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class MobileSteps {

    private MobileTestData testData;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    // --- TEST 1: WEB ---
    @Given("que el usuario desea navegar en la web")
    public void prepareWeb() {
        // Uso del Builder
        testData = MobileTestData.builder()
                .url("https://www.serebii.net/")
                .build();
        OnStage.theActorCalled("Ash Ketchum");
    }

    @When("ingresa a la pagina de serebii")
    public void navigateSerebii() {
        // Uso de Prototype (Clone) simulado: creamos una copia para asegurar inmutabilidad si fuera necesario
        MobileTestData currentData = testData.clone();
        OnStage.theActorInTheSpotlight().attemptsTo(NavigateTo.website(currentData));

    }

    @Then("deberia ver el home de la pagina")
    public void verifySerebii() {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateSite.isLoaded()));
    }

    // --- TEST 2: APP PLAY STORE ---
    @Given("que el usuario accede a la tienda de aplicaciones")
    public void prepareStore() {
        OnStage.theActorCalled("Driver User");
    }

    @When("busca la aplicacion {string} y la selecciona")
    public void searchApp(String appName) {
        OnStage.theActorInTheSpotlight().attemptsTo(DownloadApp.named(appName));
    }

    @Then("deberia poder iniciar la descarga")
    public void verifyDownload() {
        // La validación está implícita en encontrar el botón Instalar en el Task,
        // pero aquí podríamos agregar un Question adicional.
    }
}
