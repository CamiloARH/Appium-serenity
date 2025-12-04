package co.com.pragma.utils;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

// PATRÓN FACTORY: Centraliza la creación de interacciones comunes
public class InteractionFactory {

    public static Performable tapOn(Target target) {
        return Click.on(target);
    }

    // Aquí podrías expandir para devolver diferentes interacciones según iOS o Android
}