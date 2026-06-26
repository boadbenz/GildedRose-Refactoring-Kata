package com.gildedrose.oop.Product;

public class CommonProductImpl extends ProductBase implements Product {
    public CommonProductImpl(int quality, int sellIn) {
        super(quality, sellIn);
    }

    @Override
    public void updateQuality() {
        throw new RuntimeException("not implement yet");
    }
}
