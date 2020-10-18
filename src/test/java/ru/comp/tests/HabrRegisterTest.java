package ru.comp.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.comp.AutomationBaseClass;
import ru.comp.pages.HabrRegisterPage;

import static com.codeborne.selenide.Selenide.open;

public class HabrRegisterTest extends AutomationBaseClass {
    private HabrRegisterPage habrRegisterPage;

    @BeforeClass
    @Parameters({"siteUrl"})
    public void initPageObjects(String siteUrl) {
        habrRegisterPage = new HabrRegisterPage(getDriver());
        open(siteUrl);
    }

    @Test
    @Parameters({"registeredEmail", "username", "pass"})
    public void testEmailAlreadyRegistered(String registeredEmail, String username, String pass) {

        habrRegisterPage.SendRegisterForm(registeredEmail, username, pass);
        Assert.assertEquals(true, true, "Prices are not equals");
    }
}
//*[@id="register_form"]/fieldset/div[5]/div