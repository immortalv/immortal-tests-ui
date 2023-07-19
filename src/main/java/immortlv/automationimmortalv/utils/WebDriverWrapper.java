package immortlv.automationimmortalv.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

import static immortlv.automationimmortalv.utils.LoggerWrapper.info;

public class WebDriverWrapper {
    private RemoteWebDriver driver;

    public RemoteWebDriver getDriver() {
        if (driver == null) {
            driver = initializeLocalChromeDriver();
        }
        return driver;
    }

    public void openUrl(String url) {
        info("Open URL: " + url);
        getDriver().get(url);
    }

    public void closeAllBrowsers() {
        info("Close All drivers sessions");
        getDriver().quit();
    }

    private RemoteWebDriver initializeLocalChromeDriver() {
        info("Initializing Local Driver");

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--window-size=1920,1080");
        opt.addArguments("--ignore-certificate-errors");
        opt.addArguments("--allow-running-insecure-content");

        // if you need to see it running, uncomment headless mod
//        opt.addArguments("--headless");

        Map<String, Object> prefs = new HashMap<String, Object>();
        opt.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(opt);
    }
}
