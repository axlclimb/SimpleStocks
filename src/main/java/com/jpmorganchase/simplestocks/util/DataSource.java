package com.jpmorganchase.simplestocks.util;

import com.jpmorganchase.simplestocks.model.Stock;
import com.jpmorganchase.simplestocks.model.Trade;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alex Dumitrescu
 */
@Component
public class DataSource {

    private Map<Long, Trade> tradeMap = new ConcurrentHashMap<>();
    private Map<StockType, Stock> stockMap = new ConcurrentHashMap<>();

    private DataSource() {
        new DataSource(this.tradeMap, stockMap);
    }

    private DataSource(Map<Long, Trade> tradeMap, Map<StockType, Stock> stockMap) {
        this.tradeMap = tradeMap;
        this.stockMap = stockMap;
    }

    public Map<Long, Trade> getTradeMap() {
        return tradeMap;
    }

    public Map<StockType, Stock> getStockMap() {
        return stockMap;
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public DataSource getDataSource() {
        return new DataSource();

    }
}
