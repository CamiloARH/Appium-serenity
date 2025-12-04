package co.com.pragma.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SerebiiPage {

    public static final Target PAGE_TITLE = Target.the("Logo de Serebii")
            .located(By.xpath("//a[@title='Serebii.net Header']"));
}
