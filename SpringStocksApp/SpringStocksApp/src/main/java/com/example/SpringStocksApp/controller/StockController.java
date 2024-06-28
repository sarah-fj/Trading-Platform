package com.example.SpringStocksApp.controller;

import com.example.SpringStocksApp.model.Stock;
import com.example.SpringStocksApp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@CrossOrigin
@RestController
public class StockController {

    @Autowired
    StockService stockService;
//    @GetMapping("/stock")
//    public Stock getStock( List<Stock> stocks){
//        return stockService.getStocks(stocks);
//
////    //@PostMapping("/product")
////    public String Portfolio(@RequestBody final PortfolioApp portfolioApp){
////
////        System.out.println("portolio readings:");
////        return "12345";
//    }

    @GetMapping("/stock/{id}")
    public Stock getStock(@PathVariable("id") String stockId){
        return stockService.getStock(stockId);

    }
}
