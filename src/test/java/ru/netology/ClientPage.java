package ru.netology;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ClientPage {
    final SelenideElement buttonPay = $(byText("Купить"));
    final SelenideElement buttonCredit = $(byText("Купить в кредит"));


    public void pay(String number, String mounth, String year, String holder, String cvc) {
        $$(".input__inner").findBy(text("Номер карты")).$(".input__control").setValue(number);
        $$(".input__inner").findBy(text("Месяц")).$(".input__control").setValue(mounth);
        $$(".input__inner").findBy(text("Год")).$(".input__control").setValue(year);
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue(holder);
        $$(".input__inner").findBy(text("CVC/CVV")).$(".input__control").setValue(cvc);
        $$("[role='button']").find(text("Продолжить")).click();

    }

    public void getSuccessPay() {
        $(".notification_status_ok").shouldHave(text("Успешно"), Duration.ofSeconds(60));
    }

    public void getFailurePay() {
        $(".notification_status_error").shouldHave(text("Ошибка"), Duration.ofSeconds(60));
    }

    public void getFailureCard() {
        $(".input__sub").shouldHave(text("Истёк срок действия карты"), Duration.ofSeconds(60));
    }

    public void getFailureMounthOrYear() {
        $(".input__sub").shouldHave(text("Неверно указан срок действия карты"), Duration.ofSeconds(60));
    }

    public void getFailureFormat() {
        $(".input__sub").shouldHave(text("Неверный формат"), Duration.ofSeconds(60));
    }

    public void getFailureZerofield() {
        $(".input__sub").shouldHave(text("Поле обязательно для заполнения"), Duration.ofSeconds(60));
    }
}