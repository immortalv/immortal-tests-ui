package immortlv.automationimmortalv.utils;

import immortlv.automationimmortalv.exceptions.RemoteBrowserException;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static immortlv.automationimmortalv.utils.LoggerWrapper.debug;
import static immortlv.automationimmortalv.utils.LoggerWrapper.info;
import static immortlv.automationimmortalv.utils.WaiterWrapper.implicitWait;

public class WebDriverWrapper {
    private static RemoteWebDriver driver;
    private final String SELENIUM_GRID_URL_API = "http://selenium:4444/wd/hub";
    private final String SELENIUM_GRID_URL_UI = "http://selenium:4444/ui";
    private Actions actions;



    private static RemoteWebDriver initializeLocalChromeDriver() {
        info("Initializing Local Driver");

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--window-size=1920,1080");
        opt.addArguments("--ignore-ssl-errors=yes");
        opt.addArguments("--ignore-certificate-errors");
        opt.addArguments("--allow-running-insecure-content");
        opt.addArguments("--incognito");

        // if you need to see it running, uncomment headless mod
//        opt.addArguments("--headless");

        Map<String, Object> prefs = new HashMap<String, Object>();
        opt.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(opt);
    }

    private static RemoteWebDriver initializeRemoteChromeDriver(String seleniumHubUrl) {
        info("Initializing Remote Driver by URL: " + seleniumHubUrl);
        waitForSeleniumHubToBeAccesable(seleniumHubUrl);
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--window-size=1920,1080");
        opt.addArguments("--ignore-ssl-errors=yes");
        opt.addArguments("--ignore-certificate-errors");
        opt.addArguments("--allow-running-insecure-content");
        opt.addArguments("--incognito");
        info("Added browser arguments");
        URL url = null;
        try {
            info("Try to create URL");
            url = new URI(seleniumHubUrl).toURL();
        } catch (Throwable e) {
            info("Got a problem while creating URL: " + e);
            throw new RuntimeException(String.format("Error while creating url for: \"%s\"", seleniumHubUrl));
        }
        try {
            return new RemoteWebDriver(url, opt);
        } catch (Error | Exception e) {
            throw new RemoteBrowserException(String.format("Error while creating RemoteDriver for: URL: \"%s\", ", seleniumHubUrl));
        }
    }

    public RemoteWebDriver getDriver() {
        if (driver == null) {
            driver = initializeRemoteChromeDriver(SELENIUM_GRID_URL_API);
            driver.manage().deleteAllCookies();
            actions = new Actions(driver);
        }
        return driver;
    }

    public WebElement waitForElement(String locator, Integer secondsToWait) {
        debug(String.format("Waiting \"%s\" until element is displayed: \"%s\"", secondsToWait, locator));
        WebElement element;
        try {

            Awaitility.await().pollInterval(500, TimeUnit.MILLISECONDS).atMost(secondsToWait, TimeUnit.SECONDS).ignoreExceptions()
                    .until(() -> driver.findElement(By.xpath(locator)).isDisplayed());
            element = driver.findElement(By.xpath(locator));
            return element;
        } catch (ConditionTimeoutException e) {
            throw new RuntimeException("Element is not found: " + locator);
        }
    }

    public WebElement waitForElement(String locator) {
        return waitForElement(locator, 10);
    }

    public WebDriverWrapper clickElement(String xpath) {
        findElement(xpath).click();
        return this;
    }

    public WebElement findElement(String xpath) {
        waitForElement(xpath, 10);
        return getDriver().findElement(By.xpath(xpath));
    }

    public WebDriverWrapper inputText(String xpath, String... text) {
        WebElement element = findElement(xpath);
        actions.scrollToElement(element).perform();
        element.click();
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public void openUrl(String url) {
        info("Open URL: " + url);
        getDriver().get(url);
    }

    public void closeAllBrowsers() {
        info("Close All drivers sessions");
        getDriver().quit();
        driver = null;
    }

    private static void waitForSeleniumHubToBeAccesable(String seleniumHubUrl) {
        info("Wait For SeleniumHub To Be Accesable");
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
