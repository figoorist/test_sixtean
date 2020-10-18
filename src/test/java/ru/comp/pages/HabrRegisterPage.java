package ru.comp.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Register page
 */
public class HabrRegisterPage extends BasePage {
    private SelenideElement emailInput = $(byXpath("//*[@id=\"email_field\"]"));
    private SelenideElement usernameInput = $(byXpath("//*[@id=\"nickname_field\"]"));
    private SelenideElement passInput = $(byXpath("//*[@id=\"password_field\"]"));
    private SelenideElement repeatPassInput = $(byXpath("//*[@id=\"password_repeat\"]"));
    private SelenideElement userAgreementCheckbox = $(byXpath("//*[@id=\"agree\"]"));
    private SelenideElement notARobotCheckbox = $(byXpath("//*[@id=\"recaptcha-anchor\"]/div[1]"));
    private SelenideElement submitButton = $(byXpath("//*[@id=\"registration_button\"]"));

    public HabrRegisterPage(WebDriver webDriver) {
        super(webDriver);
        this.name = "Entries page";
        this.coreElementXPath = "//h1[contains(text(), 'Выберите entry для изменения')]";
    }

    public void SendRegisterForm(String email, String username, String pass)
    {
        emailInput.sendKeys(email);
        usernameInput.sendKeys(username);
        passInput.sendKeys(pass);
        repeatPassInput.sendKeys(pass);
        userAgreementCheckbox.click();
        notARobotCheckbox.click();
        submitButton.click();
    }

    public boolean containsError(String errorText) {
        boolean isDisplayed = false;

        return isDisplayed;
    }

}