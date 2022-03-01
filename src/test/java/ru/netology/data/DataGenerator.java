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

    public static String getNumberApproved() {
        return "4444 4444 4444 4441";
    }

    public static String getNumberDeclined() {
        return "4444 4444 4444 4442";
    }

    public static String getNumberFake() {
        return "4444 4444 4444 4443";
    }

    public static AuthInfo getActiveCardApproved() {
        return new AuthInfo(getNumberApproved(), generateMounth(0), generateYear(0), generateName(), generateCvc());
    }

    public static AuthInfo getActiveCardDeclined() {
        return new AuthInfo(getNumberDeclined(), generateMounth(1), generateYear(1), generateName(), generateCvc());
    }

    public static AuthInfo getFakeCard() {
        return new AuthInfo(getNumberFake(), generateMounth(1), generateYear(1), generateName(), generateCvc());
    }

    public static AuthInfo getMounth01() {
        return new AuthInfo(getNumberApproved(), "01", generateYear(1), generateName(), generateCvc());
    }

    public static AuthInfo getMounth12() {
        return new AuthInfo(getNumberApproved(), "12", generateYear(0), generateName(), generateCvc());
    }

    public static AuthInfo getYearNow() {
        return new AuthInfo(getNumberApproved(), generateMounth(1), generateYear(0), generateName(), generateCvc());
    }

    public static AuthInfo getYear5() {
        return new AuthInfo(getNumberApproved(), generateMounth(0), generateYear(5), generateName(), generateCvc());

    }

    public static AuthInfo getMounth00() {
        return new AuthInfo(getNumberApproved(), "00", generateYear(1), generateName(), generateCvc());
    }

    public static AuthInfo getMounth13() {
        return new AuthInfo(getNumberApproved(), "13", generateYear(1), generateName(), generateCvc());
    }

    public static AuthInfo getYearNegative() {
        return new AuthInfo(getNumberApproved(), generateMounth(0), generateYear(-1), generateName(), generateCvc());
    }

    public static AuthInfo getYear6() {
        return new AuthInfo(getNumberApproved(), generateMounth(0), generateYear(6), generateName(), generateCvc());
    }

    public static AuthInfo getHolder1() {
        return new AuthInfo(getNumberApproved(), generateMounth(1), generateYear(1), "пппп", generateCvc());
    }

    public static AuthInfo getHolder2() {
        return new AuthInfo(getNumberApproved(), generateMounth(1), generateYear(1), "1234", generateCvc());
    }

    public static AuthInfo getFailCVC1() {
        return new AuthInfo(getNumberApproved(), generateMounth(1), generateYear(1), generateName(), "ttt");
    }

    public static AuthInfo getFailCVC2() {
        return new AuthInfo(getNumberApproved(), generateMounth(1), generateYear(1), generateName(), "1");
    }

    public static AuthInfo getCardNull() {
        return new AuthInfo("", generateMounth(1), generateYear(1), generateName(), generateCvc());
    }

    public static AuthInfo getCardFail() {
        return new AuthInfo("123456789", generateMounth(1), generateYear(1), generateName(), generateCvc());
    }

    public static AuthInfo getMounthNull() {
        return new AuthInfo(getNumberApproved(), "", generateYear(1), generateName(), generateCvc());
    }

    public static AuthInfo getYearNull() {
        return new AuthInfo(getNumberApproved(), generateMounth(1), "", generateName(), generateCvc());
    }

    public static AuthInfo getHolderNull() {
        return new AuthInfo(getNumberApproved(), generateMounth(1), generateYear(1), "", generateCvc());
    }

    public static AuthInfo getCVCNull() {
        return new AuthInfo(getNumberApproved(), generateMounth(1), generateYear(1), generateName(), "");
    }

    public static AuthInfo getCurrentData() {
        return new AuthInfo(getNumberApproved(), generateMounth(-1), generateYear(0), generateName(), generateCvc());
    }

}
