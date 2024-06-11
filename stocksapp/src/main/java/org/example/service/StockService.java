package org.example.service;

import org.example.model.StockApp;

public interface StockService {

    void createStock(StockApp stockId);
    void increase(String stockId,double amount);
    void decrease(String stockId, double amount);
    void sell(String stockId, double numOfStock);
    StockApp getStock(String stockId);


}
