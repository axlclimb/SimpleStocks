package com.jpmorganchase.simplestocks.service.handlers;

import com.jpmorganchase.simplestocks.model.Stock;
import com.jpmorganchase.simplestocks.util.DataSource;
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

    @Autowired
    private DataSource dataSource;

    public double calculateStock(Stock stock) {
        dataSource.getStockMap().put(stock.getStockSymbol(), stock);
//        addStockToDataSource(stock);
        return stockCalculator.calculateDividendYield(stock);
    }

    public double calculatePriceEarningsRatio(Stock stock) {
        addStockToDataSource(stock);
        return stockCalculator.calculatePriceEarningsRatio(stock);
    }

    private void addStockToDataSource(Stock stock) {
        dataSource.getStockMap().put(stock.getStockSymbol(), stock);
    }
}
