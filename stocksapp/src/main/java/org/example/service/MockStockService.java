package org.example.service;

import org.example.model.StockApp;

import java.util.HashMap;
import java.util.Map;

public class MockStockService implements StockService {
    private Map<String, StockApp> mockStocks;

    public MockStockService() {
        mockStocks = new HashMap<>();
        mockStocks.put("AAPL", new StockApp("AAPL", "Apple Inc.", 150.00, 140.00, 0));
        mockStocks.put("GOOGL", new StockApp("GOOGL", "Alphabet Inc.", 2800.00, 2700.00, 0));
        mockStocks.put("AMZN", new StockApp("AMZN", "Amazon.com Inc.", 3400.00, 3300.00, 0));
    }

    @Override
    public void createStock(StockApp stock) {
        mockStocks.put(stock.getStockId(), stock);
    }

    @Override
    public void increase(String stockId, double amount) {
        StockApp stock = mockStocks.get(stockId);
        if (stock != null) {
            stock.setStockPrice(stock.getStockPrice() + amount);
        }
    }

    @Override
    public void decrease(String stockId, double amount) {
        StockApp stock = mockStocks.get(stockId);
        if (stock != null) {
            stock.setStockPrice(stock.getStockPrice() - amount);
        }
    }

    @Override
    public void sell(String stockId, double numOfStock) {
        StockApp stock = mockStocks.get(stockId);
        if (stock != null) {
            stock.setQuantity(stock.getQuantity() - (int) numOfStock);
        }
    }

    @Override
    public StockApp getStock(String stockId) {
        return mockStocks.get(stockId);
    }
}
