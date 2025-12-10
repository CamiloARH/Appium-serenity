package co.com.pragma.userinterface;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class LoginAPK {

    public static final Target USERNAME_INPUT = Target.the("Campo de usuario")
            .located(AppiumBy.accessibilityId("test-Username"));

    public static final Target PASSWORD_INPUT = Target.the("Campo de contraseña")
            .located(AppiumBy.accessibilityId("test-Password"));

    public static final Target LOGIN_BUTTON = Target.the("Botón de Login")
            .located(AppiumBy.accessibilityId("test-LOGIN"));

    public static final Target PRODUCT_TITLE = Target.the("Título de Productos")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='PRODUCTS']"));
}