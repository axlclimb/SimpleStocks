package com.jpmorganchase.simplestocks.util;

import com.jpmorganchase.simplestocks.model.Stock;
import org.springframework.stereotype.Component;

/**
 * @author Alex Dumitrescu
 */
@Component
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

    public double calculatePriceEarningsRatio(Stock stock) {
        //TODO rethink calculateDividendYield() method call
        return stock.getStockSymbolPrice() / calculateDividendYield(stock);
    }
}
