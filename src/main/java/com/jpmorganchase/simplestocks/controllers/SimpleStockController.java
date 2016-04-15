package com.jpmorganchase.simplestocks.controllers;

import com.jpmorganchase.simplestocks.model.Stock;
import com.jpmorganchase.simplestocks.model.Trade;
import com.jpmorganchase.simplestocks.service.SuperSimpleStocksService;
import com.jpmorganchase.simplestocks.util.StockSymbol;
import com.jpmorganchase.simplestocks.util.StockType;
import com.jpmorganchase.simplestocks.util.TradeIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author Alex Dumitrescu
 */
@Controller
public class SimpleStockController {

    @Autowired
    private SuperSimpleStocksService superSimpleStocksService;

    @RequestMapping(value = "/calculateDividendYield", method = RequestMethod.GET)
    @ResponseBody
    public double calculateStockObject(
            @RequestParam StockSymbol stockSymbol,
            @RequestParam StockType stockType,
            @RequestParam double lastDividend,
            @RequestParam double fixedDividend,
            @RequestParam double parValue,
            @RequestParam double stockSymbolPrice) {

        return superSimpleStocksService.calculateDividendYield(
                new Stock.StockBuilder()
                        .stockSymbol(stockSymbol)
                        .stockType(stockType)
                        .lastDividend(lastDividend)
                        .fixedDividend(fixedDividend)
                        .parValue(parValue)
                        .stockSymbolPrice(stockSymbolPrice)
                        .build());

    }

    @RequestMapping(value = "/calculatePriceEarningsRatio", method = RequestMethod.GET)
    @ResponseBody
    public double calculateStock(
            @RequestParam StockSymbol stockSymbol,
            @RequestParam String stockType,
            @RequestParam double lastDividend,
            @RequestParam double fixedDividend,
            @RequestParam double parValue,
            @RequestParam double stockSymbolPrice) {

        return superSimpleStocksService.calculatePriceEarningsRatio(new Stock.StockBuilder()
                .stockSymbol(stockSymbol)
                .stockType(Enum.valueOf(StockType.class, stockType))
                .lastDividend(lastDividend)
                .fixedDividend(fixedDividend)
                .parValue(parValue)
                .stockSymbolPrice(stockSymbolPrice)
                .build());
    }


    @RequestMapping(value = "/recordTrade", method = RequestMethod.GET)
    @ResponseBody
    public String recordTrade(
            @RequestParam StockSymbol stockSymbol,
            @RequestParam int sharesQuantity,
            @RequestParam TradeIndicator tradeIndicator,
            @RequestParam double price) {

        return superSimpleStocksService.recordTrade(new Trade.TradeBuilder()
                .stockSymbol(stockSymbol)
                .sharesQuantity(sharesQuantity)
                .tradeIndicator(tradeIndicator)
                .price(price)
                .build());
    }

    @RequestMapping(value = "/calculateStockPrice", method = RequestMethod.GET)
    @ResponseBody
    public double calculateStockPrice(
            @RequestParam StockSymbol stockSymbol,
            @RequestParam Integer startingLimitInMilliseconds) {

        return superSimpleStocksService.calculateStockPrice(stockSymbol, startingLimitInMilliseconds);
    }
    @RequestMapping(value = "/calculateGBCEAllShareIndex", method = RequestMethod.GET)
    @ResponseBody
    public double calculateGBCEAllShareIndex() {
        return superSimpleStocksService.calculateGBCEAllShareIndex();
    }
}
