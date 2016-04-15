package com.jpmorganchase.simplestocks.service;

import com.jpmorganchase.simplestocks.model.Stock;
import com.jpmorganchase.simplestocks.model.Trade;
import org.springframework.stereotype.Component;

/**
 * Created by axl on 11/04/16.
 */
@Component
public interface SuperSimpleStocksService {

    double calculateDividendYield(Stock stock);

    double calculatePriceEarningsRatio(Stock stock);

    double recordTrade(Trade trade);
}
