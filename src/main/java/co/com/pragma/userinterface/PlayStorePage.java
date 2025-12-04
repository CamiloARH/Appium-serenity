package co.com.pragma.userinterface;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class PlayStorePage {

    public static final Target SEARCH_BOX_BUTTON = Target.the("Caja de Búsqueda (Home)")
            .located(AppiumBy.id("com.google.android.finsky:id/search_bar_hint"));

    public static final Target SEARCH_INPUT = Target.the("Input de texto activo")
            .located(AppiumBy.id("com.google.android.finsky:id/search_box_text_input"));

    public static final Target APP_RESULT = Target.the("Resultado Waze")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Waze' or @text='Waze Navigation & Live Traffic']"));

    public static final Target INSTALL_BUTTON = Target.the("Botón Instalar")
            .located(AppiumBy.xpath("//android.widget.Button[@text='Install' or @text='Instalar']"));

    public static final Target OPEN_BUTTON = Target.the("Botón Abrir")
            .located(AppiumBy.xpath("//android.widget.Button[@text='Open' or @text='Abrir']"));
}