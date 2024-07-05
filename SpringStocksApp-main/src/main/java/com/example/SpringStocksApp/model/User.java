package com.example.SpringStocksApp.model;

public class User {
    private String userName;
    private double avalivleTradesNum;

    public User(String userName, double avalivleTradesNum) {
        this.userName = userName;
        this.avalivleTradesNum = avalivleTradesNum;
    }

    public String getUserName() {
        return userName;
    }
    public double getUserAmount(){
        return avalivleTradesNum;
    }

}
