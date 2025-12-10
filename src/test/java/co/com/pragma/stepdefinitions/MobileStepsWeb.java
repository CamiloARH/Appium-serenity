package co.com.pragma.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import co.com.pragma.models.MobileTestData;
import co.com.pragma.questions.ValidateSite;
import co.com.pragma.tasks.BuscarPokemon;
import co.com.pragma.tasks.NavigateTo;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MobileStepsWeb {

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
        theActorInTheSpotlight().attemptsTo(NavigateTo.website(currentData));
        theActorInTheSpotlight().attemptsTo(
                BuscarPokemon.conNombre("pikachu")
        );
    }

    @Then("deberia ver el home de la pagina")
    public void verifySerebii() {
        theActorInTheSpotlight().should(seeThat(ValidateSite.isLoaded()));
    }

}
