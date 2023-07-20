package immortlv;

import immortlv.utils.WebDriverWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static immortlv.utils.Constants.IMMORTAL_URL_STAGE;

@SpringBootApplication
public class AutomationImmortalvApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutomationImmortalvApplication.class, args);
        WebDriverWrapper driverWrapper = new WebDriverWrapper();
        driverWrapper.openUrl(IMMORTAL_URL_STAGE);
        driverWrapper.closeAllBrowsers();
    }

}
