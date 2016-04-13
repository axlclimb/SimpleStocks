package com.jpmorganchase.simplestocks.service.handlers;

import com.jpmorganchase.simplestocks.model.Stock;
import com.jpmorganchase.simplestocks.util.StockCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by axl on 11/04/16.
 */
@Component
public class CalculateStockHandler {

    @Autowired
    private StockCalculator stockCalculator;

    public Stock calculateStock(Stock stock) {

        return null;
    }

    public Stock calculateStock(String stockSymbol, String stockType, double lastDividend, double fixedDividend, double parValue, double stockSymbolPrice) {

        stockCalculator.calculateDividendYield(stockType, lastDividend, fixedDividend, parValue, stockSymbolPrice);
//        stockCalculator.calculatePriceEarningsRatio(stockSymbolPrice, getDividendYield() );


//        return superSimpleStocksService.calculateStock(
//                new Stock.StockBuilder()
//                        .stockSymbol(stockSymbol)
//                        .stockType(Enum.valueOf(StockType.class, stockType))
//                        .lastDividend(lastDividend)
//                        .fixedDividend(fixedDividend)
//                        .parValue(parValue)
//                        .stockSymbolPrice(stockSymbolPrice)
//                        .build());
        return null;
    }
}
