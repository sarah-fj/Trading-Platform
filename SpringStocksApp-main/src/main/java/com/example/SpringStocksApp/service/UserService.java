package com.example.SpringStocksApp.service;

import com.example.SpringStocksApp.model.User;

public interface UserService {
    void createUser(String userName, double amount);
    User getUser(String userName);
    double getUserAmount(String userName );
}


// public interface StockService {
// //create the map here, stock repository
//     void createStock(Stock stockId);
//     void increase(String stockId,double amount);
//     void decrease(String stockId, double amount);
//     void sell(String stockId, double numOfStock);
//     Stock getStock(String stockId);
//     List<Stock> getStocks();


// }
