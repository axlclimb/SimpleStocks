package com.jpmorganchase.simplestocks.model;

import com.jpmorganchase.simplestocks.util.StockSymbol;
import com.jpmorganchase.simplestocks.util.StockType;

/**
 * @author Alex Dumitrescu
 */
public class Stock {
    private final StockSymbol stockSymbol;
    private final StockType stockType;
    private final double lastDividend;
    private final double fixedDividend;
    private final double parValue;
    private final double stockSymbolPrice; //ticker price

    public Stock(StockBuilder builder) {
        this.stockSymbol = builder.stockSymbol;
        this.stockType = builder.stockType;
        this.lastDividend = builder.lastDividend;
        this.fixedDividend = builder.fixedDividend;
        this.parValue = builder.parValue;
        this.stockSymbolPrice = builder.stockSymbolPrice;
    }

    public StockSymbol getStockSymbol() {
        return stockSymbol;
    }

    public StockType getStockType() {
        return stockType;
    }

    public double getLastDividend() {
        return lastDividend;
    }

    public double getFixedDividend() {
        return fixedDividend;
    }

    public double getParValue() {
        return parValue;
    }

    public double getStockSymbolPrice() {
        return stockSymbolPrice;
    }

    public static class StockBuilder {
        private StockSymbol stockSymbol;
        private StockType stockType;
        private double lastDividend;
        private double fixedDividend;
        private double parValue;
        private double stockSymbolPrice;

        public StockBuilder stockSymbol(StockSymbol stockSymbol) {
            this.stockSymbol = stockSymbol;
            return this;
        }

        public StockBuilder stockType(StockType stockType) {
            this.stockType = stockType;
            return this;
        }

        public StockBuilder lastDividend(double lastDividend) {
            this.lastDividend = lastDividend;
            return this;
        }

        public StockBuilder fixedDividend(double fixedDividend) {
            this.fixedDividend = fixedDividend;
            return this;
        }

        public StockBuilder parValue(double parValue) {
            this.parValue = parValue;
            return this;
        }
        public StockBuilder stockSymbolPrice(double stockSymbolPrice) {
            this.stockSymbolPrice = stockSymbolPrice;
            return this;
        }

        public Stock build() {
            return new Stock(this);
        }
    }
}
