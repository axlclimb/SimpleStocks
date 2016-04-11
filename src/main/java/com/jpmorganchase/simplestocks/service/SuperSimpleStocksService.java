package com.jpmorganchase.simplestocks.service;

import com.jpmorganchase.simplestocks.model.Stock;
import org.springframework.stereotype.Component;

/**
 * Created by axl on 11/04/16.
 */
@Component
public interface SuperSimpleStocksService {

    Stock calculateStock(Stock stock);
}
