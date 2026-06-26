package com.gildedrose.oop.Product;

public class BackstagePassesImpl extends ProductBase implements Product {

    public BackstagePassesImpl(int quality, int sellIn) {
        super(quality, sellIn);
    }

    @Override
    public void updateQuality() {
        throw new RuntimeException("not implement yet");

    }
}
