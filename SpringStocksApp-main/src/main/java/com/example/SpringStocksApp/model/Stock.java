package com.example.SpringStocksApp.model;

public class Stock {
    private String stockId;
    private String stockName;
    private double stockPrice;
    private double purchasePrice;
    private int quantity;

    public Stock(String stockId, String stockName, double stockPrice, double purchasePrice, int quantity) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getGainLoss() {
        return (stockPrice - purchasePrice) * quantity;
    }

    @Override
    public String toString() {
        return "Stock ID: " + stockId + " , " +
                "Stock Name: " + stockName + " , " +
                "Current Price: $" + stockPrice + " , " +
                "Purchase Price: $" + purchasePrice + " , " +
                "Quantity: " + quantity + " , " +
                "Gain/Loss: $" + getGainLoss();
    }
}
