package ru.netology.page;

import ru.netology.data.AuthInfo;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageCredit {
    public void credit(AuthInfo tempAuthInfo) {
        $$(".input__inner").findBy(text("Номер карты")).$(".input__control").setValue(tempAuthInfo.getNumber());
        $$(".input__inner").findBy(text("Месяц")).$(".input__control").setValue(tempAuthInfo.getMounth());
        $$(".input__inner").findBy(text("Год")).$(".input__control").setValue(tempAuthInfo.getYear());
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue(tempAuthInfo.getHolder());
        $$(".input__inner").findBy(text("CVC/CVV")).$(".input__control").setValue(tempAuthInfo.getCvc());
        $$("[role='button']").find(text("Продолжить")).click();
    }

    public void getSuccessCredit() {
        $(".notification_status_ok").shouldHave(text("Успешно"), Duration.ofSeconds(20));
    }

    public void getFailureCredit() {
        $(".notification_status_error").shouldHave(text("Ошибка"), Duration.ofSeconds(20));
    }

    public void getFailureCardCredit() {
        $(".input__sub").shouldHave(text("Истёк срок действия карты"), Duration.ofSeconds(20));
    }

    public void getFailureMounthOrYearCredit() {
        $(".input__sub").shouldHave(text("Неверно указан срок действия карты"), Duration.ofSeconds(20));
    }

    public void getFailureFormatCredit() {
        $(".input__sub").shouldHave(text("Неверный формат"), Duration.ofSeconds(20));
    }

    public void getFailureZerofieldCredit() {
        $(".input__sub").shouldHave(text("Поле обязательно для заполнения"), Duration.ofSeconds(20));
    }
}
