package ru.netology;

public class AuthInfo {
        private String number;
        private String status;
        private String mounth;
        private String year;
        private String holder;
        private String cvc;

    public static String getNumberApproved() { return "4444 4444 4444 4441"; }
    public static String getNumberDeclined() {
        return "4444 4444 4444 4442";
    }
    public static String getNumberFake() {
        return "4444 4444 4444 4443";
    }


//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getMounth() {
//        return mounth;
//    }
//
//    public void setMounth(String mounth) {
//        this.mounth = mounth;
//    }
//
//    public String getYear() {
//        return year;
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }
//
//    public String getHolder() {
//        return holder;
//    }
//
//    public void setHolder(String holder) {
//        this.holder = holder;
//    }
//
//    public String getCvc() {
//        return cvc;
//    }
//
//    public void setCvc(String cvc) {
//        this.cvc = cvc;
//    }

    public AuthInfo() {
    }
  }
