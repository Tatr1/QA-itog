package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.Sql;
import ru.netology.page.ClientPage;
import ru.netology.page.PagePay;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataGenerator.*;

public class DataTest {

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
    void shouldPayActiveCardApproved() throws InterruptedException {
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getActiveCardApproved());
        PagePay.getSuccessPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals("APPROVED", temp.sqlQueryPaymentStatus());
        assertEquals(4500000, temp.sqlQueryPaymentAmount());
    }

    @Test
    void shouldPayActiveCardDeclined() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getActiveCardDeclined());
        PagePay.getFailurePay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals("DECLINED", temp.sqlQueryPaymentStatus());
    }

    @Test
    void shouldPayFakeCard() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getFakeCard());
        PagePay.getFailurePay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryPaymentStatus());
    }

    @Test
    void shouldPayMounth01() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getMounth01());
        PagePay.getSuccessPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals("APPROVED", temp.sqlQueryPaymentStatus());
    }

    @Test
    void shouldPayMounth12() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getMounth12());
        PagePay.getSuccessPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals("APPROVED", temp.sqlQueryPaymentStatus());
    }

    @Test
    void shouldPayYearNow() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getYearNow());
        PagePay.getSuccessPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals("APPROVED", temp.sqlQueryPaymentStatus());
    }

    @Test
    void shouldPayYear5() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getYear5());
        PagePay.getSuccessPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals("APPROVED", temp.sqlQueryPaymentStatus());
    }

    @Test
    void shouldPayMounth00() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getMounth00());
        PagePay.getFailureMounthOrYearPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldPayMounth13() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getMounth13());
        PagePay.getFailureMounthOrYearPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldPayYearNegative() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getYearNegative());
        PagePay.getFailureCardPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        var tempSql = temp.sqlQueryOrderEntity();
        assertEquals(null, tempSql);
    }

    @Test
    void shouldPayYear6() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getYear6());
        PagePay.getFailureMounthOrYearPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldPayHolder1() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getHolder1());
        PagePay.getFailurePay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldPayHolder2() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getHolder2());
        PagePay.getFailurePay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldPayFailCVC1() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getFailCVC1());
        PagePay.getFailureZerofieldPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldPayFailCVC2() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getFailCVC2());
        PagePay.getFailureFormatPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldPayCardNull() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getCardNull());
        PagePay.getFailureFormatPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldPayCardFail() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getCardFail());
        PagePay.getFailureFormatPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldPayMounthNull() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getMounthNull());
        PagePay.getFailureFormatPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldPayYearNull() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getYearNull());
        PagePay.getFailureFormatPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldPayHolderNull() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getHolderNull());
        PagePay.getFailureZerofieldPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }

    @Test
    void shouldPayCVCNull() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getCVCNull());
        PagePay.getFailureZerofieldPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        var tempSql = temp.sqlQueryOrderEntity();
        assertEquals(null, tempSql);
    }

    @Test
    void shouldPayCurrentData() throws InterruptedException{
        var ClientPage = new ClientPage();
        var PagePay = new PagePay();
        ClientPage.buttonPay();
        PagePay.pay(getCurrentData());
        PagePay.getFailureMounthOrYearPay();
        TimeUnit.SECONDS.sleep(30);
        Sql temp = new Sql();
        assertEquals(null, temp.sqlQueryOrderEntity());
    }
}




