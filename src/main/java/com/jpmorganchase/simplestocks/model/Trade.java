package com.jpmorganchase.simplestocks.model;

import com.jpmorganchase.simplestocks.util.StockSymbol;
import com.jpmorganchase.simplestocks.util.TradeIndicator;

import java.util.Date;

/**
 * @author Alex Dumitrescu
 */
public class Trade {
    private Date date;
    private StockSymbol stockSymbol;
    private int sharesQuantity;
    private TradeIndicator tradeIndicator;
    private double price;

    public Trade(TradeBuilder builder) {
        this.stockSymbol = builder.stockSymbol;
        this.sharesQuantity = builder.sharesQuantity;
        this.tradeIndicator = builder.tradeIndicator;
        this.price = builder.price;
    }

    public Date getDate() {
        return date;
    }

    public StockSymbol getStockSymbol() {
        return stockSymbol;
    }

    public int getSharesQuantity() {
        return sharesQuantity;
    }

    public TradeIndicator getTradeIndicator() {
        return tradeIndicator;
    }

    public double getPrice() {
        return price;
    }


    public static class TradeBuilder {
        private StockSymbol stockSymbol;
        private int sharesQuantity;
        private TradeIndicator tradeIndicator;
        private double price;

        public TradeBuilder stockSymbol(StockSymbol stockSymbol) {
            this.stockSymbol = stockSymbol;
            return this;
        }

        public TradeBuilder sharesQuantity(int sharesQuantity) {
            this.sharesQuantity = sharesQuantity;
            return this;
        }

        public TradeBuilder tradeIndicator(TradeIndicator tradeIndicator) {
            this.tradeIndicator = tradeIndicator;
            return this;
        }

        public TradeBuilder price(double price) {
            this.price = price;
            return this;
        }

        public Trade build() {
            return new Trade(this);
        }
    }
}
