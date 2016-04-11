package com.jpmorganchase.simplestocks.util;

import com.jpmorganchase.simplestocks.model.Stock;

/**
 * Created by axl on 11/04/16.
 */
public class StockCalculator {

    public double calculateDividendYield(Stock stock) {
        double dividendYield;
        if (StockType.COMMON == stock.getStockType()) {
            dividendYield = stock.getLastDividend() / stock.getStockSymbolPrice();
        } else {
            dividendYield = (stock.getFixedDividend() * stock.getParValue()) / stock.getStockSymbolPrice();
        }
        return dividendYield;
    }
}
