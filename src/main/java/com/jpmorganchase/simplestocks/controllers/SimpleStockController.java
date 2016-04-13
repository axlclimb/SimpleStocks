package com.jpmorganchase.simplestocks.controllers;

import com.jpmorganchase.simplestocks.model.Stock;
import com.jpmorganchase.simplestocks.service.SuperSimpleStocksService;
import com.jpmorganchase.simplestocks.util.StockType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by axl on 11/04/16.
 */
@Controller
public class SimpleStockController {

    @Autowired
    private SuperSimpleStocksService superSimpleStocksService;

    @RequestMapping(value = "/calculateStockObject", method = RequestMethod.GET)
    @ResponseBody
    public Stock calculateStockObject(
            @RequestParam String stockSymbol,
            @RequestParam String stockType,
            @RequestParam double lastDividend,
            @RequestParam double fixedDividend,
            @RequestParam double parValue,
            @RequestParam double stockSymbolPrice) {

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

    @RequestMapping(value = "/calculateStock", method = RequestMethod.GET)
    @ResponseBody
    public Stock calculateStock(
            @RequestParam String stockSymbol,
            @RequestParam String stockType,
            @RequestParam double lastDividend,
            @RequestParam double fixedDividend,
            @RequestParam double parValue,
            @RequestParam double stockSymbolPrice) {

        return superSimpleStocksService.calculateStock(stockSymbol, stockType, lastDividend, fixedDividend, parValue, stockSymbolPrice);
    }
}
