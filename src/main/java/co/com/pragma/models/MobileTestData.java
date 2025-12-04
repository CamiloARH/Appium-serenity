package co.com.pragma.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MobileTestData implements Cloneable {
    private String appName;
    private String url;
    private String expectedTitle;

    // para clonar el objeto para no instanciar uno nuevo desde cero
    @Override
    public MobileTestData clone() {
        try {
            return (MobileTestData) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("La clonación no es soportada", e);
        }
    }
}