package com.jpmorganchase.simplestocks.service.handlers;

import com.jpmorganchase.simplestocks.model.Stock;
import com.jpmorganchase.simplestocks.util.StockCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Alex Dumitrescu
 */
@Component
public class CalculateStockHandler {

    @Autowired
    private StockCalculator stockCalculator;

    public double calculateStock(Stock stock) {
        return stockCalculator.calculateDividendYield(stock);
    }

    public double calculatePriceEarningsRatio(Stock stock) {
        return stockCalculator.calculatePriceEarningsRatio(stock);
    }
}
