package com.gildedrose.oop.Product;

public class AgedBrieImpl extends ProductBase implements Product {
    public AgedBrieImpl(String name, int quality, int sellIn) {
        super(name, quality, sellIn);
    }

    @Override
    public void updateQuality() {
        if(getQuality() >= 50) {
            return;
        }

        setQuality(getQuality() + 1);
        setSellIn(getSellIn() - 1);

        if(getSellIn() < 0) {
            setQuality(getQuality() + 1);
        }
    }
}
