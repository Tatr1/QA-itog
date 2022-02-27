package ru.netology.page;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ClientPage {

    public PagePay buttonPay(){
        $(byText("Купить")).click();
        return new PagePay();
    }

    public PageCredit buttonCredit() {
        $(byText("Купить в кредит")).click();
        return new PageCredit();
    }



}