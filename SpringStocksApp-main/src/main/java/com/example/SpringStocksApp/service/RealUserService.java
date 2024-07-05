package com.example.SpringStocksApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringStocksApp.model.User;

@Service
public class RealUserService implements UserService{
    private List<User> users = new ArrayList<>();
    public RealUserService(){
        users.add(new User("JaneFraser", 20030.56));
        System.out.println(users);
    }

    @Override
    public void createUser(String userName, double amount) {
        User newUser = new User (userName,amount);
        users.add(newUser);

    }

    @Override
    public User getUser(String userName) {
        User user =this.findUser(userName);
        if(user ==null) System.out.println("user not found");
        return user; 
    }

    @Override
    public double getUserAmount(String userName) {
        double amount =this.findUserAmount(userName);
        if(amount ==0) System.out.println("user not have funds");
        return amount; 
    }

    private User findUser(String userName){
        for (User user : users){
            if(user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }
    private double findUserAmount(String userName){
        for (User user : users){
            if(user.getUserName().equals(userName)){
                return user.getUserAmount();
            }
        }
        return 0;
    }
    
}
