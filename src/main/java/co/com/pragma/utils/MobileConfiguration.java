package co.com.pragma.utils;

import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class MobileConfiguration {

    private static volatile MobileConfiguration instance;
    private final EnvironmentVariables environmentVariables;

    private MobileConfiguration() {
        // Serenity inyecta las variables del sistema y serenity.conf aquí
        this.environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    }

    public static MobileConfiguration getInstance() {
        if (instance == null) {
            synchronized (MobileConfiguration.class) {
                if (instance == null) {
                    instance = new MobileConfiguration();
                }
            }
        }
        return instance;
    }

    public String getBrowserStackUser() {
        return environmentVariables.getProperty("browserstack.user");
    }

    public String getAppiumHubUrl() {
        return environmentVariables.getProperty("webdriver.remote.url");
    }
}
