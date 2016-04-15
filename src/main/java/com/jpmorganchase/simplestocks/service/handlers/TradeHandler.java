package com.jpmorganchase.simplestocks.service.handlers;

import com.jpmorganchase.simplestocks.model.Stock;
import com.jpmorganchase.simplestocks.model.Trade;
import com.jpmorganchase.simplestocks.util.DataSource;
import com.jpmorganchase.simplestocks.util.StockSymbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

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

    public List<Stock> calculateStockPrice(StockSymbol stockSymbol, Integer startingLimitInMinutes) {
        return null;
    }
}
