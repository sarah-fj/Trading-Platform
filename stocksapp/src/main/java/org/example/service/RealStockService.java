package org.example.service;

import org.example.model.StockApp;

import java.util.ArrayList;
import java.util.List;

public class RealStockService implements StockService{

    private List<StockApp> stocks = new ArrayList<>();

    @Override
    public void createStock(StockApp stock) {
        stocks.add(stock);
        System.out.println("created " + stock);
    }

    @Override
    public void increase(String stockId, double amount) {
        StockApp stock = this.getStock(stockId);
        if (stock!=null){
            stock.setStockPrice(stock.getStockPrice()+amount);
            System.out.println(" stock "+ stockId +" price increased by : " +amount);
        }
        else{
            System.out.println("Account is not found!");
        }
    }

    @Override
    public void decrease(String stockId, double amount) {
        StockApp stock = this.getStock(stockId);
        if (stock!=null){
            stock.setStockPrice(stock.getStockPrice()-amount);
            System.out.println(" stock "+ stockId +" price decreased by : " +amount);
        }
        else{
            System.out.println("Account is not found!");
        }
    }

    @Override
    public void sell(String stockId, double numOfStock) {
        StockApp stock =this.findStock(stockId);
        if(stock != null){
            stock.setStockPrice(stock.getStockPrice()/numOfStock);
            System.out.println("new stock price of " + stockId + " is now : $"+ stock.getStockPrice());
        }
    }

    @Override
    public StockApp getStock(String stockId) {
        StockApp stock =this.findStock(stockId);
        if(stock ==null) System.out.println("stock not found");
        return stock;
    }
    private StockApp findStock(String stockId){
        for (StockApp stock : stocks){
            if(stock.getStockId().equals(stockId)){
                return stock;
            }
        }
        return null;
    }
}
