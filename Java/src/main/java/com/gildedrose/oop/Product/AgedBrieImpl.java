package com.gildedrose.oop.Product;

public class AgedBrieImpl extends ProductBase implements Product {
    public AgedBrieImpl(String name, int quality, int sellIn) {
        super(name, quality, sellIn);
    }

    @Override
    public void updateQuality() {

    }
}
