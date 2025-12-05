package co.com.pragma.tasks;

import co.com.pragma.models.MobileTestData;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo implements Task {
    private final MobileTestData testData;

    public NavigateTo(MobileTestData testData) {
        this.testData = testData;
    }

    public static NavigateTo website(MobileTestData testData) {
        return new NavigateTo(testData);
    }

    @Override
    @Step("{0} navega al sitio web")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(testData.getUrl()));
    }
}