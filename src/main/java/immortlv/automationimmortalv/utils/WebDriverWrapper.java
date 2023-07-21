package immortlv.automationimmortalv.utils;

import org.awaitility.Awaitility;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static immortlv.automationimmortalv.utils.LoggerWrapper.info;

public class WebDriverWrapper {
    private final String SELENIUM_GRID_URL = "http://selenium-hub-chrome:4444/wd/hub";
    private RemoteWebDriver driver;

    public RemoteWebDriver getDriver() {
        if (driver == null) {
            driver = initializeRemoteChromeDriver(SELENIUM_GRID_URL);
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

    private RemoteWebDriver initializeRemoteChromeDriver(String seleniumHubUrl) {
        info("Initializing Remote Driver by URL: " + seleniumHubUrl);
        ChromeOptions options = new ChromeOptions();
//        waitForSeleniumHubToBeAccesable(seleniumHubUrl);
        URL url = null;
        try {
            url = new URL(seleniumHubUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(String.format("Error while createing url for: \"%s\"", seleniumHubUrl));
        }
        return new RemoteWebDriver(url, options);
    }

    private void waitForSeleniumHubToBeAccesable(String seleniumHubUrl) {
        Awaitility.await().atMost(30, TimeUnit.SECONDS).pollInterval(2, TimeUnit.SECONDS).ignoreExceptions().until(() -> {
            try {
                new URL(seleniumHubUrl);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }
}
