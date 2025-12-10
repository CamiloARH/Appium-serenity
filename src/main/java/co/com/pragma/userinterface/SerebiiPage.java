package co.com.pragma.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SerebiiPage {

    public static final Target PAGE_TITLE = Target.the("Logo de Serebii")
            .located(By.xpath("//a[@title='Serebii.net Header']"));

    public static final Target CAJA_BUSQUEDA = Target.the("Caja de búsqueda de Serebii")
            .located(By.cssSelector("input[type=search]:nth-child(3)"));
}
