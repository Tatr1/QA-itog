package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.page.ClientPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataGenerator.*;
import static ru.netology.data.Sql.*;

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
    void clean() {sqlCleanStatus();
    }

    @Test
    void shouldPayActiveCardApproved() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getActiveCardApproved());
        pagePay.getSuccessPay();
        assertEquals("APPROVED", sqlQueryPaymentStatus());
    }

    @Test
    void shouldPayActiveCardDeclined() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getActiveCardDeclined());
        pagePay.getFailurePay();
        assertEquals("DECLINED", sqlQueryPaymentStatus());
    }

    @Test
    void shouldPayFakeCard() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getFakeCard());
        pagePay.getFailurePay();
        assertEquals(null, sqlQueryPaymentStatus());
    }

    @Test
    void shouldPayMounth01() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getMounth01());
        pagePay.getSuccessPay();
        assertEquals("APPROVED", sqlQueryPaymentStatus());
    }

    @Test
    void shouldPayMounth12() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getMounth12());
        pagePay.getSuccessPay();
        assertEquals("APPROVED", sqlQueryPaymentStatus());
    }

    @Test
    void shouldPayYearNow() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getYearNow());
        pagePay.getSuccessPay();
        assertEquals("APPROVED", sqlQueryPaymentStatus());
    }

    @Test
    void shouldPayYear5() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getYear5());
        pagePay.getSuccessPay();
        assertEquals("APPROVED", sqlQueryPaymentStatus());
    }

    @Test
    void shouldPayMounth00() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getMounth00());
        pagePay.getFailureMounthOrYearPay();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldPayMounth13() {
        var ClientPage = new ClientPage();
        var PagePay = ClientPage.buttonPay();
        PagePay.pay(getMounth13());
        PagePay.getFailureMounthOrYearPay();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldPayYearNegative() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getYearNegative());
        pagePay.getFailureCardPay();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldPayYear6() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getYear6());
        pagePay.getFailureMounthOrYearPay();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldPayHolder1() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getHolder1());
        pagePay.getFailurePay();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldPayHolder2() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getHolder2());
        pagePay.getFailurePay();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldPayFailCVC1() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getFailCVC1());
        pagePay.getFailureZerofieldPay();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldPayFailCVC2() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getFailCVC2());
        pagePay.getFailureFormatPay();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldPayCardNull() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getCardNull());
        pagePay.getFailureFormatPay();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldPayCardFail() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getCardFail());
        pagePay.getFailureFormatPay();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldPayMounthNull() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getMounthNull());
        pagePay.getFailureFormatPay();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldPayYearNull() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getYearNull());
        pagePay.getFailureFormatPay();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldPayHolderNull() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getHolderNull());
        pagePay.getFailureZerofieldPay();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldPayCVCNull() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getCVCNull());
        pagePay.getFailureZerofieldPay();
        assertEquals(null, sqlQueryOrderEntity());
    }

    @Test
    void shouldPayCurrentData() {
        var clientPage = new ClientPage();
        var pagePay = clientPage.buttonPay();
        pagePay.pay(getCurrentData());
        pagePay.getFailureMounthOrYearPay();
        assertEquals(null, sqlQueryOrderEntity());
    }
}




