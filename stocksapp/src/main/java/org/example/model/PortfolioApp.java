package org.example.model;
import java.util.HashMap;
import java.util.Map;
public class PortfolioApp {
        private Map<String, StockApp> holdings;

        public PortfolioApp() {
            holdings = new HashMap<>();
        }

        public Map<String, StockApp> getHoldings() {
            return holdings;
        }

        public void addStock(StockApp stock, int quantity) {
            if (holdings.containsKey(stock.getStockId())) {
                StockApp existingStock = holdings.get(stock.getStockId());
                existingStock.setQuantity(existingStock.getQuantity() + quantity);
            } else {
                holdings.put(stock.getStockId(), stock);
            }
        }

        public void removeStock(String stockId, int quantity) {
            if (holdings.containsKey(stockId)) {
                StockApp stock = holdings.get(stockId);
                int currentQuantity = stock.getQuantity();
                if (currentQuantity >= quantity) {
                    stock.setQuantity(currentQuantity - quantity);
                    if (stock.getQuantity() == 0) {
                        holdings.remove(stockId);
                    }
                } else {
                    System.out.println("Not enough stock available to remove. Current quantity: " + currentQuantity);
                }
            } else {
                System.out.println("Stock not found in portfolio.");
            }
        }

        @Override
        public String toString() {
            StringBuilder portfolioStr = new StringBuilder("Portfolio:\n");
            holdings.values().forEach(stock -> portfolioStr.append(stock.toString()).append("\n"));
            return portfolioStr.toString();
        }
    }

