package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    static private Faker faker = new Faker(new Locale("en"));


    public static String generateMounth(int mounthTest) {
        return LocalDate.now().plusMonths(mounthTest).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateYear(int yearTest) {
        return LocalDate.now().plusYears(yearTest).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateName() {
        String name = faker.name().fullName();
        return name;
    }

    public static String generateCvc() {
        String cvc = faker.numerify("###");
        return cvc;
    }
    public static String getNumberApproved() { return "4444 4444 4444 4441"; }

    public static String getNumberDeclined() {
        return "4444 4444 4444 4442";
    }

    public static String getNumberFake() {
        return "4444 4444 4444 4443";
    }

    public static AuthInfo getActiveCardApproved() {
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = generateMounth(0);
        tempAuthInfo.year = generateYear(0);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
}
    public static AuthInfo getActiveCardDeclined() {
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberDeclined();
        tempAuthInfo.mounth = generateMounth(1);
        tempAuthInfo.year = generateYear(1);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getFakeCard(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberFake();
        tempAuthInfo.mounth = generateMounth(1);
        tempAuthInfo.year = generateYear(1);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getMounth01(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = "01";
        tempAuthInfo.year = generateYear(1);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getMounth12(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = "12";
        tempAuthInfo.year = generateYear(0);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
     }
    public static AuthInfo getYearNow(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = generateMounth(1);
        tempAuthInfo.year = generateYear(0);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getYear5(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = generateMounth(0);
        tempAuthInfo.year = generateYear(5);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getMounth00(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = "00";
        tempAuthInfo.year = generateYear(1);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getMounth13(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = "13";
        tempAuthInfo.year = generateYear(1);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getYearNegative(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = generateMounth(0);
        tempAuthInfo.year = generateYear(-1);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
     }
    public static AuthInfo getYear6(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = generateMounth(0);
        tempAuthInfo.year = generateYear(6);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getHolder1(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = generateMounth(1);
        tempAuthInfo.year = generateYear(1);
        tempAuthInfo.holder = "пппп";
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getHolder2(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = generateMounth(1);
        tempAuthInfo.year = generateYear(1);
        tempAuthInfo.holder = "1234";
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getFailCVC1(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = generateMounth(1);
        tempAuthInfo.year = generateYear(1);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = "ttt";
        return tempAuthInfo;
    }
    public static AuthInfo getFailCVC2(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = generateMounth(1);
        tempAuthInfo.year = generateYear(1);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = "1";
        return tempAuthInfo;
    }
    public static AuthInfo getCardNull(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = "";
        tempAuthInfo.mounth = generateMounth(1);
        tempAuthInfo.year = generateYear(1);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getCardFail(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = "123456789";
        tempAuthInfo.mounth = generateMounth(1);
        tempAuthInfo.year = generateYear(1);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getMounthNull(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = "";
        tempAuthInfo.year = generateYear(1);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getYearNull(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = generateMounth(1);
        tempAuthInfo.year = "";
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getHolderNull(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = generateMounth(1);
        tempAuthInfo.year = generateYear(1);
        tempAuthInfo.holder = "";
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
    public static AuthInfo getCVCNull(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = generateMounth(1);
        tempAuthInfo.year = generateYear(1);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = "";
        return tempAuthInfo;
    }
    public static AuthInfo getCurrentData(){
        AuthInfo tempAuthInfo = new AuthInfo();
        tempAuthInfo.number = getNumberApproved();
        tempAuthInfo.mounth = generateMounth(-1);
        tempAuthInfo.year = generateYear(0);
        tempAuthInfo.holder = generateName();
        tempAuthInfo.cvc = generateCvc();
        return tempAuthInfo;
    }
}
