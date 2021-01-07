package com.boson.assessment.orders;

import com.boson.assessment.items.Item;

public class Order {
    private Item item;
    private String sellerId;
    private String buyerId;

    public Item getItem() {
        return item;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
}
