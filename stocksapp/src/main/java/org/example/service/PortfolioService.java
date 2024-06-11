package org.example.service;

import org.example.model.StockApp;

public interface PortfolioService {
    void addStock(String stockId, int quantity);
    void removeStock(String stockId, int quantity);
    double calculateTotalValue();
    double calculateGainsLosses();
    void displayPortfolio();
}
