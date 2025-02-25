package com.co.primeraAutomatizacion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WaitElement implements Task {
    private final Target target;
    private final ExpectedConditionType conditionType;
    private final int timeoutInSeconds;

    public enum ExpectedConditionType {
        VISIBLE,
        CLICKABLE,
        PRESENT
    }

    public WaitElement (Target target, ExpectedConditionType conditionType, int timeoutInSeconds) {
        this.target = target;
        this.conditionType = conditionType;
        this.timeoutInSeconds = timeoutInSeconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = SerenityWebdriverManager.inThisTestThread().getCurrentDriver();
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

        switch (conditionType) {
            case VISIBLE:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(target.getCssOrXPathSelector())));
                break;
            case CLICKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(target.getCssOrXPathSelector())));
                break;
            case PRESENT:
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(target.getCssOrXPathSelector())));
                break;
            default:
                throw new IllegalArgumentException("Unsupported condition type: " + conditionType);
        }
    }

    public static WaitElement elementIsVisible(Target target, int seconds) {
        return instrumented(WaitElement.class, target, ExpectedConditionType.VISIBLE, seconds);
    }

    public static WaitElement elementIsClickable(Target target, int seconds) {
        return instrumented(WaitElement.class, target, ExpectedConditionType.CLICKABLE, seconds);
    }

    public static WaitElement elementIsPresent(Target target, int seconds) {
        return instrumented(WaitElement.class, target, ExpectedConditionType.PRESENT, seconds);
    }
}

