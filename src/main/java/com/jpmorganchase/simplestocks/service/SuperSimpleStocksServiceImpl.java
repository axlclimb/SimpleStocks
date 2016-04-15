package com.jpmorganchase.simplestocks.service;

import com.jpmorganchase.simplestocks.model.Stock;
import com.jpmorganchase.simplestocks.model.Trade;
import com.jpmorganchase.simplestocks.service.handlers.CalculateStockHandler;
import com.jpmorganchase.simplestocks.service.handlers.TradeHandler;
import com.jpmorganchase.simplestocks.util.StockSymbol;
import org.apache.commons.math3.stat.StatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Alex Dumitrescu
 */
@Component
public class SuperSimpleStocksServiceImpl implements SuperSimpleStocksService {

    @Autowired
    private CalculateStockHandler calculateStockHandler;

    @Autowired
    private TradeHandler tradeHandler;

    @Override
    public double calculateDividendYield(Stock stock) {
        return calculateStockHandler.calculateStock(stock);
    }

    @Override
    public double calculatePriceEarningsRatio(Stock stock) {
        return calculateStockHandler.calculatePriceEarningsRatio(stock);
    }

    @Override
    public String recordTrade(Trade trade) {
        return tradeHandler.recordTrade(trade);
    }

    @Override
    public double calculateStockPrice(StockSymbol stockSymbol, Integer startingLimitInMilliseconds) {
        return tradeHandler.calculateStockPrice(stockSymbol, startingLimitInMilliseconds);
    }

    @Override
    public double calculateGBCEAllShareIndex() {
        return tradeHandler.calculateGBCEAllShareIndex();
    }

}
