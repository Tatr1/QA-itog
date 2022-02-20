package ru.netology;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTestSql {

    void setup() {
        open("http://localhost:8080");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void clean(){
        Sql.sqlCleanStatus();
    }

    @Test
    void shouldPayActiveCardApproved() throws InterruptedException {
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonPay.click();
        ClientPage.pay(AuthInfo.getNumberApproved(), DataGenerator.generateMounth(1),DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        TimeUnit.SECONDS.sleep(60); //у кого-то тормозной комп
        Sql temp = new Sql();
        String tempStatus = temp.sqlQueryPaymentStatus();
        Integer tempAmount = temp.sqlQueryPaymentAmount();
        assertEquals("APPROVED", tempStatus);
        assertEquals(4500000, tempAmount);
    }

    @Test
    void shouldPayActiveCardDeclined() throws InterruptedException {
    setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonPay.click();
        ClientPage.pay(AuthInfo.getNumberDeclined(),DataGenerator.generateMounth(1),DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        TimeUnit.SECONDS.sleep(60);
        Sql temp = new Sql();
        String tempSql = temp.sqlQueryPaymentStatus();
        assertEquals("DECLINED", tempSql);
    }

    @Test
    void shouldPayFakeCard() throws InterruptedException {
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonPay.click();
        ClientPage.pay(AuthInfo.getNumberFake(),DataGenerator.generateMounth(1),DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        TimeUnit.SECONDS.sleep(60);
        Sql temp = new Sql();
        String tempSql = temp.sqlQueryPaymentStatus();
        assertEquals(null, tempSql);
    }

    @Test
    void shouldCreditActiveCardApproved() throws InterruptedException {
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(), DataGenerator.generateMounth(1),DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        TimeUnit.SECONDS.sleep(60);
        Sql temp = new Sql();
        String tempStatus = temp.sqlQueryCreditStatus();
        assertEquals("APPROVED", tempStatus);
    }

    @Test
    void shouldCreditActiveCardDeclined() throws InterruptedException {
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberDeclined(),DataGenerator.generateMounth(1),DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        TimeUnit.SECONDS.sleep(60);
        Sql temp = new Sql();
        String tempSql = temp.sqlQueryCreditStatus();
        assertEquals("DECLINED", tempSql);
    }

    @Test
    void shouldCreditFakeCard() throws InterruptedException {
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberFake(),DataGenerator.generateMounth(1),DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        TimeUnit.SECONDS.sleep(60);
        Sql temp = new Sql();
        String tempSql = temp.sqlQueryCreditStatus();
        assertEquals(null, tempSql);
    }
}
