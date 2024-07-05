package com.example.SpringStocksApp.service;

import com.example.SpringStocksApp.model.Stock;

import java.util.List;

public interface StockService {
//create the map here, stock repository
    void createStock(Stock stockId);
    void increase(String stockId,double amount);
    void decrease(String stockId, double amount);
    void sell(String stockId, double numOfStock);
    Stock getStock(String stockId);
    List<Stock> getStocks();


}
