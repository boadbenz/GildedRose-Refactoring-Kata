package com.gildedrose.oop.Product;

public class SulfurasImpl extends ProductBase implements Product {
    public SulfurasImpl(int quality, int sellIn) {
        super(quality, sellIn);
    }

    @Override
    public void updateQuality() {
        throw new RuntimeException("not implement yet");
    }
}
