package com.jpmorganchase.simplestocks.model;

import com.jpmorganchase.simplestocks.util.StockSimbol;
import com.jpmorganchase.simplestocks.util.TradeIndicator;

import java.util.Date;

/**
 * Created by axl on 14/04/16.
 */
public class Trade {
    private Date date;
    private StockSimbol stockSimbol;
    private int sharesQuantity;
    private TradeIndicator tradeIndicator;
    private double price;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StockSimbol getStockSimbol() {
        return stockSimbol;
    }

    public void setStockSimbol(StockSimbol stockSimbol) {
        this.stockSimbol = stockSimbol;
    }

    public int getSharesQuantity() {
        return sharesQuantity;
    }

    public void setSharesQuantity(int sharesQuantity) {
        this.sharesQuantity = sharesQuantity;
    }

    public TradeIndicator getTradeIndicator() {
        return tradeIndicator;
    }

    public void setTradeIndicator(TradeIndicator tradeIndicator) {
        this.tradeIndicator = tradeIndicator;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
