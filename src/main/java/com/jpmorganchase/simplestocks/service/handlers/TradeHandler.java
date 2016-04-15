package com.jpmorganchase.simplestocks.service.handlers;

import com.jpmorganchase.simplestocks.model.Stock;
import com.jpmorganchase.simplestocks.model.Trade;
import com.jpmorganchase.simplestocks.util.DataSource;
import com.jpmorganchase.simplestocks.util.StockSymbol;
import org.apache.commons.math3.stat.StatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Alex Dumitrescu
 */
@Component
public class TradeHandler {

    @Autowired
    private DataSource dataSource;

    public String recordTrade(Trade trade) {
        dataSource.getTradeMap().put(Instant.now().toEpochMilli(), trade);
        return "SUCCESS";
    }

    public double calculateStockPrice(StockSymbol stockSymbol, Integer startingLimitInMilliseconds) {
        double totalStockPrice = 0;
        double totalStockQuantity = 0;
        for (Map.Entry<Long, Trade> trade : dataSource.getTradeMap().entrySet()) {
            if (Instant.now().minusMillis(startingLimitInMilliseconds).toEpochMilli() < trade.getKey()
                    && stockSymbol.equals(trade.getValue().getStockSymbol())) {
                totalStockPrice += trade.getValue().getPrice();
                totalStockQuantity += trade.getValue().getSharesQuantity();
            }
            if (startingLimitInMilliseconds == 0 && stockSymbol.equals(trade.getValue().getStockSymbol())) {
                totalStockPrice += trade.getValue().getPrice();
                totalStockQuantity += trade.getValue().getSharesQuantity();
            }
        }
        return totalStockPrice / totalStockQuantity;
    }

    public double calculateGBCEAllShareIndex() {
        List<Double> stockValuesList = new ArrayList<>();
        for (Stock stock : dataSource.getStockMap().values()) {
            Double calculatedStock = calculateStockPrice(stock.getStockSymbol(), 0);
            if (!calculatedStock.isNaN()) {
                stockValuesList.add(calculatedStock);
            }
        }
        double[] stockPrices = new double[stockValuesList.size()];
        for (int i = 0; i < stockValuesList.size(); i++) {
            stockPrices[i] = stockValuesList.get(i);
        }
        return StatUtils.geometricMean(stockPrices);
    }
}
