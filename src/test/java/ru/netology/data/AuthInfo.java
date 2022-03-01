package ru.netology.data;

import lombok.Value;

@Value
public class AuthInfo {
    String number;
    String mounth;
    String year;
    String holder;
    String cvc;
}
