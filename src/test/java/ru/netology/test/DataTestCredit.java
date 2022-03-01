package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.page.ClientPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataGenerator.*;
import static ru.netology.data.Sql.*;

public class DataTestCredit {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @AfterEach
    void clean() {
        sqlCleanStatus();
    }

    @Test
    void shouldCreditActiveCardApproved()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getActiveCardApproved());
        pageCredit.getSuccessCredit();
        assertEquals("APPROVED", sqlQueryCreditStatus());
    }

    @Test
    void shouldCreditActiveCardDeclined()  {
        var ClientPage = new ClientPage();
        var PageCredit = ClientPage.buttonCredit();
        PageCredit.credit(getActiveCardDeclined());
        PageCredit.getFailureCredit();
        assertEquals("DECLINED", sqlQueryCreditStatus());
    }

    @Test
    void shouldCreditFakeCard()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getFakeCard());
        pageCredit.getFailureCredit();
        assertEquals(null, sqlQueryCreditStatus());
    }

    @Test
    void shouldCreditMounth01()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getMounth01());
        pageCredit.getSuccessCredit();
        assertEquals("APPROVED", sqlQueryCreditStatus());
    }

    @Test
    void shouldCreditMounth12()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getMounth12());
        pageCredit.getSuccessCredit();
        assertEquals("APPROVED", sqlQueryCreditStatus());
    }

    @Test
    void shouldCreditYearNow()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getYearNow());
        pageCredit.getSuccessCredit();
        assertEquals("APPROVED", sqlQueryCreditStatus());
    }

    @Test
    void shouldCreditYear5()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getYear5());
        pageCredit.getSuccessCredit();
        assertEquals("APPROVED", sqlQueryCreditStatus());
    }

    @Test
    void shouldCreditMounth00()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getMounth00());
        pageCredit.getFailureMounthOrYearCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditMounth13()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getMounth13());
        pageCredit.getFailureMounthOrYearCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditYearNegative()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getYearNegative());
        pageCredit.getFailureCardCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditYear6()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getYear6());
        pageCredit.getFailureMounthOrYearCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditHolder1()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getHolder1());
        pageCredit.getFailureCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditHolder2()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getHolder2());
        pageCredit.getFailureCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditFailCVC1()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getFailCVC1());
        pageCredit.getFailureZerofieldCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditFailCVC2()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getFailCVC2());
        pageCredit.getFailureFormatCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditCardNull()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getCardNull());
        pageCredit.getFailureFormatCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditCardFail()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getCardFail());
        pageCredit.getFailureFormatCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditMounthNull()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getMounthNull());
        pageCredit.getFailureFormatCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditYearNull()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getYearNull());
        pageCredit.getFailureFormatCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditHolderNull()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getHolderNull());
        pageCredit.getFailureZerofieldCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditCVCNull()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getCVCNull());
        pageCredit.getFailureZerofieldCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditCurrentData()  {
        var clientPage = new ClientPage();
        var pageCredit = clientPage.buttonCredit();
        pageCredit.credit(getCurrentData());
        pageCredit.getFailureMounthOrYearCredit();
        assertEquals(null, sqlQueryOrderEntity());
    }
}


