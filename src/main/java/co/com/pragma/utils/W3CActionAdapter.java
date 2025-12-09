package co.com.pragma.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class W3CActionAdapter {

    public static void scrollDown(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);

        sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 500, 1500));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(new Pause(finger, Duration.ofMillis(100)));
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), 500, 500)); // Arrastra hacia arriba
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((org.openqa.selenium.remote.RemoteWebDriver) driver).perform(Collections.singletonList(sequence));
    }
}