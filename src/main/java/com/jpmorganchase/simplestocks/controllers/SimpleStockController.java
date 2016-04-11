package com.jpmorganchase.simplestocks.controllers;

import com.jpmorganchase.simplestocks.model.Stock;
import com.jpmorganchase.simplestocks.service.SuperSimpleStocksService;
import com.jpmorganchase.simplestocks.util.StockType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by axl on 11/04/16.
 */
@Controller
public class SimpleStockController {

    @Autowired
    private SuperSimpleStocksService superSimpleStocksService;


    public Stock calculateStock(String stockSymbol, String stockType, double lastDividend, double fixedDividend, double parValue, double stockSymbolPrice) {
        return superSimpleStocksService.calculateStock(
                new Stock.StockBuilder()
                        .stockSymbol(stockSymbol)
                        .stockType(Enum.valueOf(StockType.class, stockType))
                        .lastDividend(lastDividend)
                        .fixedDividend(fixedDividend)
                        .parValue(parValue)
                        .stockSymbolPrice(stockSymbolPrice)
                        .build());
    }
}
