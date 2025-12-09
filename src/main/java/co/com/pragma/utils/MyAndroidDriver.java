package co.com.pragma.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.net.URL;
import java.time.Duration;

public class MyAndroidDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        try {
            System.out.println(">>>>>>>>>> INICIANDO CREACIÓN DE DRIVER MANUAL <<<<<<<<<<");

            File chromedriverFile = new File("./drivers/chromedriver.exe");
            if (!chromedriverFile.exists()) {
                throw new RuntimeException("CRÍTICO: No encuentro el driver en: " + chromedriverFile.getAbsolutePath());
            }

            URL appiumUrl = new URL("http://127.0.0.1:4723/");

            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setAutomationName("UiAutomator2")
                    .setDeviceName("emulator-5554")
                    .withBrowserName("Chrome");

            // Configuración del driver manual
            options.setCapability("appium:chromedriverAutodownload", false);
            options.setCapability("appium:chromedriverExecutable", chromedriverFile.getAbsolutePath());

            // AUMENTAMOS EL TIMEOUT A 5 MINUTOS (Para evitar que corte la conexión)
            options.setNewCommandTimeout(Duration.ofSeconds(300));

            System.out.println(">>>>>>>>>> ENVIANDO PETICIÓN A APPIUM... <<<<<<<<<<");
            AndroidDriver driver = new AndroidDriver(appiumUrl, options);

            System.out.println(">>>>>>>>>> ¡DRIVER CREADO! RETORNANDO A SERENITY <<<<<<<<<<");
            return driver;

        } catch (Throwable e) {
            // ESTO ES LO IMPORTANTE: Imprimirá el error real en rojo
            System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.err.println("ERROR FATAL EN MyAndroidDriver: " + e.getMessage());
            e.printStackTrace();
            System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
