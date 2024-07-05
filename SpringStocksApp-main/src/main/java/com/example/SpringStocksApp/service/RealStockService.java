package com.example.SpringStocksApp.service;

import com.example.SpringStocksApp.model.Stock;

import org.springframework.stereotype.Service;


import java.util.ArrayList;

import java.util.List;

@Service
//this tell that it is a service delaration
public class RealStockService implements StockService{

//this is out 'data base'
    private List<Stock> stocks = new ArrayList<>();

    public RealStockService(){
        stocks.add(new Stock( "GOOGL", "Alphabet Inc.", 183.88, 1, 23));
        stocks.add(new Stock("AMZN", "Amazon.com Inc.", 194.84, 3.00, 46));
        stocks.add(new Stock("AAPL", "Apple, Inc", 213.98, 1, 4));
        stocks.add(new Stock("NVDA", "NVIDIA, Corp", 123.91, 2, 12));
        stocks.add(new Stock("VFV", "Vanguard S&P 500 Index ETF", 132.80, 1, 4));
        
        System.out.println(stocks);
    }

    @Override
    public void createStock(Stock stock) {
        stocks.add(stock);
        System.out.println("created " + stock);
    }

    @Override
    public void increase(String stockId, double amount) {
        Stock stock = this.getStock(stockId);
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
        Stock stock = this.getStock(stockId);
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
        Stock stock =this.findStock(stockId);
        if(stock != null){
            stock.setStockPrice(stock.getStockPrice()/numOfStock);
            System.out.println("new stock price of " + stockId + " is now : $"+ stock.getStockPrice());
        }
    }

    @Override
    public Stock getStock(String stockId) {
        Stock stock =this.findStock(stockId);
        if(stock ==null) System.out.println("stock not found");
        return stock;
    }
    @Override
    public List<Stock> getStocks() {
        return new ArrayList<>(stocks); // Return a copy to avoid external modification
    }
    private Stock findStock(String stockId){
        for (Stock stock : stocks){
            if(stock.getStockId().equals(stockId)){
                return stock;
            }
        }
        return null;
    }
}
