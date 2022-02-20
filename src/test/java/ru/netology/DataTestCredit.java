package ru.netology;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

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

    @Test
    void shouldPayActiveCardApproved(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),DataGenerator.generateMounth(1),DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getSuccessPay();
    }

    @Test
    void shouldPayActiveCardDeclined(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberDeclined(),DataGenerator.generateMounth(1),DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getFailurePay();
    }

    @Test
    void shouldPayFakeCard(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberFake(),DataGenerator.generateMounth(1),DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getFailurePay();
    }

    @Test
    void shouldPayMounth01(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),"01",DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getSuccessPay();
    }

    @Test
    void shouldPayMounth12(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),"12",DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getSuccessPay();
    }

    @Test
    void shouldPayYearNow(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),DataGenerator.generateMounth(1),DataGenerator.generateYear(5),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getSuccessPay();
    }
    @Test
    void shouldPayYear5(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),DataGenerator.generateMounth(1),DataGenerator.generateYear(5),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getSuccessPay();
    }

    @Test
    void shouldPayCvc(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),DataGenerator.generateMounth(1),DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getSuccessPay();
    }

    @Test
    void shouldPayMounth00(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),"00",DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getFailureMounthOrYear();
    }

    @Test
    void shouldPayMounth13(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),"13",DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getFailureMounthOrYear();
    }

    @Test
    void shouldPayYearN(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),DataGenerator.generateMounth(1),DataGenerator.generateYear(-1),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getFailureCard(); }

    @Test
    void shouldPayYear6(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),DataGenerator.generateMounth(1),DataGenerator.generateYear(6),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getFailureMounthOrYear();
    }

    @Test
    void shouldPayHolder1(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),DataGenerator.generateMounth(1),DataGenerator.generateYear(1),"Вася",DataGenerator.generateCvc());
        ClientPage.getFailurePay();
    }

    @Test
    void shouldPayHolder2(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),DataGenerator.generateMounth(1),DataGenerator.generateYear(1),"d123",DataGenerator.generateCvc());
        ClientPage.getFailurePay();
    }

    @Test
    void shouldFailCVC(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),DataGenerator.generateMounth(1),DataGenerator.generateYear(1),DataGenerator.generateName(),"trt");
        ClientPage.getFailureZerofield();   }

    @Test
    void shouldCardNull(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay("",DataGenerator.generateMounth(1),DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getFailureFormat();  }

    @Test
    void shouldCardFail(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay("1234567890",DataGenerator.generateMounth(1),DataGenerator.generateYear(1),DataGenerator.generateName(),"gtr");
        ClientPage.getFailureFormat();  }

    @Test
    void shouldMounthNull(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),"",DataGenerator.generateYear(1),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getFailureFormat();   }

    @Test
    void shouldYearNull(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),DataGenerator.generateMounth(1),"",DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getFailureFormat();  }

    @Test
    void shouldHolderNull(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),DataGenerator.generateMounth(1),DataGenerator.generateYear(1),"",DataGenerator.generateCvc());
        ClientPage.getFailureZerofield();  }

    @Test
    void shouldCVCNull(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),DataGenerator.generateMounth(1),DataGenerator.generateYear(1),DataGenerator.generateName(),"");
          ClientPage.getFailureZerofield();  }

    @Test
    void shouldCreditCurrentData(){
        setup();
        var ClientPage = new ClientPage();
        ClientPage.buttonCredit.click();
        ClientPage.pay(AuthInfo.getNumberApproved(),DataGenerator.generateMounth(-1),DataGenerator.generateYear(0),DataGenerator.generateName(),DataGenerator.generateCvc());
        ClientPage.getFailureMounthOrYear();
    }
}


