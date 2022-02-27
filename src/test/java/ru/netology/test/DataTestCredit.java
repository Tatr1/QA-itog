package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.Sql;
import ru.netology.page.ClientPage;
import ru.netology.page.PageCredit;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataGenerator.*;

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
        Sql.sqlCleanStatus();
    }

    @Test
    void shouldCreditActiveCardApproved() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getActiveCardApproved());
        PageCredit.getSuccessCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals("APPROVED", temp.sqlQueryCreditStatus());
    }

    @Test
    void shouldCreditActiveCardDeclined() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getActiveCardDeclined());
        PageCredit.getFailureCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals("DECLINED", temp.sqlQueryCreditStatus());
    }

    @Test
    void shouldCreditFakeCard() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getFakeCard());
        PageCredit.getFailureCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryCreditStatus());
    }

    @Test
    void shouldCreditMounth01() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getMounth01());
        PageCredit.getSuccessCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals("APPROVED", temp.sqlQueryCreditStatus());
    }

    @Test
    void shouldCreditMounth12() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getMounth12());
        PageCredit.getSuccessCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals("APPROVED", temp.sqlQueryCreditStatus());
    }

    @Test
    void shouldCreditYearNow() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getYearNow());
        PageCredit.getSuccessCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals("APPROVED", temp.sqlQueryCreditStatus());
    }

    @Test
    void shouldCreditYear5() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getYear5());
        PageCredit.getSuccessCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals("APPROVED", temp.sqlQueryCreditStatus());
    }

    @Test
    void shouldCreditMounth00() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getMounth00());
        PageCredit.getFailureMounthOrYearCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditMounth13() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getMounth13());
        PageCredit.getFailureMounthOrYearCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditYearNegative() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getYearNegative());
        PageCredit.getFailureCardCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditYear6() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getYear6());
        PageCredit.getFailureMounthOrYearCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditHolder1() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getHolder1());
        PageCredit.getFailureCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditHolder2() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getHolder2());
        PageCredit.getFailureCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditFailCVC1() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getFailCVC1());
        PageCredit.getFailureZerofieldCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditFailCVC2() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getFailCVC2());
        PageCredit.getFailureFormatCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditCardNull() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getCardNull());
        PageCredit.getFailureFormatCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditCardFail() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getCardFail());
        PageCredit.getFailureFormatCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditMounthNull() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getMounthNull());
        PageCredit.getFailureFormatCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditYearNull() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getYearNull());
        PageCredit.getFailureFormatCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditHolderNull() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getHolderNull());
        PageCredit.getFailureZerofieldCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditCVCNull() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getCVCNull());
        PageCredit.getFailureZerofieldCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldCreditCurrentData() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PageCredit = new PageCredit();
        ClientPage.buttonCredit();
        PageCredit.credit(getCurrentData());
        PageCredit.getFailureMounthOrYearCredit();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }
}


