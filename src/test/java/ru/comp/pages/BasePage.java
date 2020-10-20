package ru.comp.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class BasePage {

    protected String coreElementXPath;
    protected String name;

    @Step("Check the page has loaded")
    public void IsPresentedCheck() {
        try {
            $(byXpath(coreElementXPath)).shouldBe(Condition.visible);
        }
        catch (NoSuchElementException e) {
            System.out.println("Page " + name + " didn't present!");
            throw e;
        }
    }
}
