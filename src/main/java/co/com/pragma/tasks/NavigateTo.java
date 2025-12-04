package co.com.pragma.tasks;

import co.com.pragma.models.MobileTestData;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo implements Task {
    private final String url;

    public NavigateTo(String url) {
        this.url = url;
    }

    @Step("{0} navega a la URL #url")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static NavigateTo website(MobileTestData data) {
        return new NavigateTo(data.getUrl());
    }
}
