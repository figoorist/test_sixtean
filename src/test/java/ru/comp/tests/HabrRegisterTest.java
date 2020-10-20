package ru.comp.tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.comp.pages.HabrRegisterPage;

import static com.codeborne.selenide.Selenide.open;

public class HabrRegisterTest {
    private HabrRegisterPage habrRegisterPage;

    @BeforeClass
    @Parameters({"siteUrl"})
    public void initPageObjects(String siteUrl) {
        habrRegisterPage = new HabrRegisterPage();
        open(siteUrl);
    }

    @Test
    @Parameters({"registeredEmail", "username", "pass"})
    public void testEmailAlreadyRegistered(String registeredEmail, String username, String pass) {

        habrRegisterPage.SendRegisterForm(registeredEmail, username, pass);
        habrRegisterPage.ErrorMessage("Please enter correct email").shouldBe(Condition.visible);
    }
}