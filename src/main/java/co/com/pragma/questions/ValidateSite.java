package co.com.pragma.questions;

import co.com.pragma.userinterface.SerebiiPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateSite implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        // En mobile web a veces validar titulo es inestable, validamos un elemento
        return SerebiiPage.PAGE_TITLE.resolveFor(actor).isVisible();
    }

    public static ValidateSite isLoaded() {
        return new ValidateSite();
    }
}
