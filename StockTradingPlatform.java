import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Stock {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

class Portfolio {
    HashMap<String, Integer> stocks; // Maps stock symbol to quantity

    Portfolio() {
        stocks = new HashMap<>();
    }

    void buyStock(String symbol, int quantity) {
        stocks.put(symbol, stocks.getOrDefault(symbol, 0) + quantity);
    }

    void sellStock(String symbol, int quantity) {
        if (stocks.containsKey(symbol)) {
            int currentQuantity = stocks.get(symbol);
            if (currentQuantity >= quantity) {
                stocks.put(symbol, currentQuantity - quantity);
            } else {
                System.out.println("Not enough shares to sell.");
            }
        } else {
            System.out.println("Stock not in portfolio.");
        }
    }

    void displayPortfolio() {
        System.out.println("Your Portfolio:");
        for (String symbol : stocks.keySet()) {
            System.out.println(symbol + ": " + stocks.get(symbol));
        }
    }
}

class StockMarket {
    HashMap<String, Stock> marketData;

    StockMarket() {
        marketData = new HashMap<>();
        loadMarketData();
    }

    void loadMarketData() {
        // Simulated stock data
        marketData.put("AAPL", new Stock("AAPL", 150.00));
        marketData.put("GOOGL", new Stock("GOOGL", 2800.00));
        marketData.put("AMZN", new Stock("AMZN", 3400.00));
        // Add more stocks as needed
    }

    void displayMarket() {
        System.out.println("Current Market Data:");
        for (Stock stock : marketData.values()) {
            System.out.println(stock.symbol + ": $" + stock.price);
        }
    }

    Stock getStock(String symbol) {
        return marketData.get(symbol);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockMarket stockMarket = new StockMarket();
        Portfolio portfolio = new Portfolio();
        String command;

        do {
            System.out.println("\nOptions: \n1. View Market \n2. Buy Stock \n3. Sell Stock \n4. View Portfolio \n5. Exit");
            System.out.print("Enter a command: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    stockMarket.displayMarket();
                    break;
                case "2":
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int buyQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    portfolio.buyStock(buySymbol, buyQuantity);
                    break;
                case "3":
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int sellQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    portfolio.sellStock(sellSymbol, sellQuantity);
                    break;
                case "4":
                    portfolio.displayPortfolio();
                    break;
                case "5":
                    System.out.println("Exiting the platform.");
                    break;
                default:
                    System.out.println("Invalid command, please try again.");
            }
        } while (!command.equals("5"));

        scanner.close();
    }
}
