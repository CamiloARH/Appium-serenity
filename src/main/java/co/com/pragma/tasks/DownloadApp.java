package co.com.pragma.tasks;

import co.com.pragma.userinterface.PlayStorePage;
import co.com.pragma.utils.InteractionFactory;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DownloadApp implements Task {
    private final String appName;

    public DownloadApp(String appName) {
        this.appName = appName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PlayStorePage.SEARCH_BOX_BUTTON, isVisible()).forNoMoreThan(15).seconds(),
                InteractionFactory.tapOn(PlayStorePage.SEARCH_BOX_BUTTON),

                WaitUntil.the(PlayStorePage.SEARCH_INPUT, isVisible()),
                Enter.theValue(appName).into(PlayStorePage.SEARCH_INPUT).thenHit(Keys.ENTER),

                WaitUntil.the(PlayStorePage.APP_RESULT, isVisible()).forNoMoreThan(10).seconds(),
                InteractionFactory.tapOn(PlayStorePage.APP_RESULT),

                WaitUntil.the(PlayStorePage.INSTALL_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                InteractionFactory.tapOn(PlayStorePage.INSTALL_BUTTON)
                // Nota: No esperamos la descarga completa para no hacer el test eterno en BrowserStack
        );
    }

    public static DownloadApp named(String appName) {
        return instrumented(DownloadApp.class, appName);
    }
}
