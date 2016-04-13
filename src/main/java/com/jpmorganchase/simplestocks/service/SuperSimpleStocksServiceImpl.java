package com.jpmorganchase.simplestocks.service;

import com.jpmorganchase.simplestocks.model.Stock;
import com.jpmorganchase.simplestocks.service.handlers.CalculateStockHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by axl on 11/04/16.
 */
@Component
public class SuperSimpleStocksServiceImpl implements SuperSimpleStocksService {

    @Autowired
    private CalculateStockHandler calculateStockHandler;

    @Override
    public Stock calculateStock(Stock stock) {
        return calculateStockHandler.calculateStock(stock);
    }

    @Override
    public Stock calculateStock(String stockSymbol, String stockType, double lastDividend, double fixedDividend, double parValue, double stockSymbolPrice) {
        return calculateStockHandler.calculateStock(stockSymbol, stockType, lastDividend, fixedDividend, parValue, stockSymbolPrice);
    }
}
