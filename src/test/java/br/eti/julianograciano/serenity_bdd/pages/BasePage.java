package br.eti.julianograciano.serenity_bdd.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Page Object Base
 *
 * @author Juliano Graciano Pereira Costa Costa
 * @version $Id: $Id
 * @since 1.0.0
 */
public class BasePage extends PageObject {

    protected WebDriver driver;

    protected Duration implicitWaitTimeout;

    protected Duration waitForTimeout;

    protected FluentWait<WebDriver> wait;

    protected EnvironmentVariables env;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.implicitWaitTimeout = getImplicitWaitTimeout();
        this.waitForTimeout = getWaitForTimeout();
        this.wait = new FluentWait<>(this.driver);
        this.wait = wait.withTimeout(waitForTimeout);
        this.wait = wait.pollingEvery(Duration.ofMillis(1000));
        List<Class<? extends Throwable>> types = new ArrayList<>();
        types.add(NoSuchElementException.class);
        types.add(ElementNotVisibleException.class);
        types.add(StaleElementReferenceException.class);
        wait.ignoreAll(types);
    }
}
