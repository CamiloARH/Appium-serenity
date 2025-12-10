package co.com.pragma.tasks;

import co.com.pragma.userinterface.LoginAPK;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginApp implements Task {

    private final String username;
    private final String password;

    public  LoginApp(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static  LoginApp withCredentials(String username, String password) {
        return instrumented(LoginApp.class, username, password);
    }

    @Override
    @Step("{0} inicia sesión en Swag Labs")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginAPK.USERNAME_INPUT),
                Enter.theValue(password).into(LoginAPK.PASSWORD_INPUT),
                Click.on(LoginAPK.LOGIN_BUTTON)
        );
    }
}