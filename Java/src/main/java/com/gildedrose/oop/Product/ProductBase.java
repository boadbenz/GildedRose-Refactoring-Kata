package com.gildedrose.oop.Product;

import com.gildedrose.oop.Item;

public class ProductBase {
    private int quality;
    private int sellIn;
    private String name;

    public ProductBase(String name, int quality, int sellIn) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public Item convertToItem() {
        return new Item(name, sellIn, quality);
    }
}
