package co.com.pragma.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import co.com.pragma.models.MobileTestData;
import io.appium.java_client.AppiumDriver;

public class NavigateTo implements Task {

    private MobileTestData testData;

    public NavigateTo(MobileTestData testData) {
        this.testData = testData;
    }

    public static NavigateTo website(MobileTestData testData) {
        return new NavigateTo(testData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Crear driver Appium con capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("appium:chromedriverAutodownload", true);

        try {
            // SOLUCIÓN ERROR 1: Try-catch para la URL y el driver
            AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), caps);

            // Asignar el driver al actor
            actor.can(BrowseTheWeb.with(driver));

            // SOLUCIÓN ERROR 2: Usar Open.url de Serenity
            actor.attemptsTo(
                    Open.url(testData.getUrl())
            );

        } catch (MalformedURLException e) {
            throw new RuntimeException("La URL del servidor Appium es inválida", e);
        }
    }
}
