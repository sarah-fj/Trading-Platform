package org.example;

import org.example.service.*;

public class Main {
    public static void main(String[] args) {
        StockService stockService = new MockStockService();

        // Using MockPortfolioService
        PortfolioService mockPortfolioService = new MockPortfolioService(stockService);
        testPortfolioService(mockPortfolioService);

        // Using RealPortfolioService
        PortfolioService realPortfolioService = new RealPortfolioService(stockService);
        testPortfolioService(realPortfolioService);
    }

    private static void testPortfolioService(PortfolioService portfolioService) {
        // Adding stocks to the portfolio
        portfolioService.addStock("AAPL", 10);
        portfolioService.addStock("GOOGL", 5);
        portfolioService.addStock("AMZN", 3);

        // Display portfolio
        portfolioService.displayPortfolio();

        // Remove stock from the portfolio
        portfolioService.removeStock("GOOGL", 2);

        // Display updated portfolio
        portfolioService.displayPortfolio();
    }
}
