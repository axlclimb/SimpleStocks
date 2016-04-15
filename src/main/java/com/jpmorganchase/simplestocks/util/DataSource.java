package com.jpmorganchase.simplestocks.util;

import com.jpmorganchase.simplestocks.model.Stock;
import com.jpmorganchase.simplestocks.model.Trade;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alex Dumitrescu
 */
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class DataSource {

    private Map<Long, Trade> tradeMap;
    private Map<StockSymbol, Stock> stockMap;

    private DataSource() {
        this(new ConcurrentHashMap<>(), new ConcurrentHashMap<>());
    }

    private DataSource(Map<Long, Trade> tradeMap, Map<StockSymbol, Stock> stockMap) {
        this.tradeMap = tradeMap;
        this.stockMap = stockMap;
    }

    public Map<Long, Trade> getTradeMap() {
        return tradeMap;
    }

    public Map<StockSymbol, Stock> getStockMap() {
        return stockMap;
    }

}
