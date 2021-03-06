package com.jpmorganchase.simplestocks.service;

import com.jpmorganchase.simplestocks.model.Stock;
import com.jpmorganchase.simplestocks.model.Trade;
import com.jpmorganchase.simplestocks.util.StockSymbol;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Alex Dumitrescu
 */
@Component
public interface SuperSimpleStocksService {

    double calculateDividendYield(Stock stock);

    double calculatePriceEarningsRatio(Stock stock);

    String recordTrade(Trade trade);

    double calculateStockPrice(StockSymbol stockSymbol, Integer startingLimitInMilliseconds);

    double calculateGBCEAllShareIndex();
}
