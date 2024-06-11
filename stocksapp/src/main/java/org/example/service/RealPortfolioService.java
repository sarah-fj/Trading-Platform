package org.example.service;

import org.example.model.PortfolioApp;
import org.example.model.StockApp;

public class RealPortfolioService implements PortfolioService {
    private PortfolioApp portfolio;
    private StockService stockService;

    public RealPortfolioService(StockService stockService) {
        this.portfolio = new PortfolioApp();
        this.stockService = stockService;
    }

    @Override
    public void addStock(String stockId, int quantity) {
        StockApp stock = stockService.getStock(stockId);
        if (stock != null) {
            stock.setQuantity(quantity); // Update quantity in stock
            portfolio.addStock(stock, quantity);
            System.out.println(quantity + " units of " + stock.getStockName() + " added to the portfolio.");
        } else {
            System.out.println("Stock with ID " + stockId + " not found.");
        }
    }

    @Override
    public void removeStock(String stockId, int quantity) {
        portfolio.removeStock(stockId, quantity);
        System.out.println(quantity + " units of stock with ID " + stockId + " removed from the portfolio.");
    }

    @Override
    public double calculateTotalValue() {
        return portfolio.getHoldings().values().stream()
                .mapToDouble(stock -> stock.getStockPrice() * stock.getQuantity())
                .sum();
    }

    @Override
    public double calculateGainsLosses() {
        return portfolio.getHoldings().values().stream()
                .mapToDouble(StockApp::getGainLoss)
                .sum();
    }

    @Override
    public void displayPortfolio() {
        System.out.println(portfolio);
        System.out.println("Total value: $" + calculateTotalValue());
        System.out.println("Gains/Losses: $" + calculateGainsLosses());
    }
}
