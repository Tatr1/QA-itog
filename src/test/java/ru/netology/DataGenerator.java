package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {}
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

}
