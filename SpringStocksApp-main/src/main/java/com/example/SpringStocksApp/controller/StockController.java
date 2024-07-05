package com.example.SpringStocksApp.controller;

import com.example.SpringStocksApp.model.Stock;
import com.example.SpringStocksApp.model.User;
import com.example.SpringStocksApp.service.StockService;
import com.example.SpringStocksApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@CrossOrigin
@RestController
public class StockController {

    @Autowired
    StockService stockService;
    @Autowired
    UserService userService;

    

    @GetMapping("/stock/{id}")
    public Stock getStock(@PathVariable("id") String stockId) {
        return stockService.getStock(stockId);
    }

    @GetMapping("/stocks")
    public List<Stock> getAllStocks() {
        return stockService.getStocks();
    }
    @GetMapping("/user/{userName}")
    public User getUserName(@PathVariable("userName") String userName) {
        return userService.getUser(userName);
    }
}
