package co.com.pragma.tasks;

import co.com.pragma.userinterface.SerebiiPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarPokemon implements Task {

    private final String nombrePokemon;

    public BuscarPokemon(String nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
    }

    public static BuscarPokemon conNombre(String nombrePokemon) {
        return instrumented(BuscarPokemon.class, nombrePokemon);
    }

    @Override
    @Step("{0} busca el pokemon #nombrePokemon en Serebii")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Escribe el nombre y presiona ENTER
                Enter.theValue(nombrePokemon)
                        .into(SerebiiPage.CAJA_BUSQUEDA)
                        .thenHit(Keys.ENTER)
        );
    }
}