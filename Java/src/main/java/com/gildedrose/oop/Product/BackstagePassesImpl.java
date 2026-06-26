package com.gildedrose.oop.Product;

public class BackstagePassesImpl extends ProductBase implements Product {

    public BackstagePassesImpl(String name, int quality, int sellIn) {
        super(name, quality, sellIn);
    }

    @Override
    public void updateQuality() {
        if(getQuality() >= 50) {
            return;
        }

        if(getSellIn() <= 0) {
            setQuality(getQuality() - getQuality());
            return;
        }

        if(getSellIn() <= 5) {
            setQuality(getQuality() + 3);
        } else if(getSellIn() <= 10) {
            setQuality(getQuality() + 2);
        } else {
            setQuality(getQuality() + 1);
        }

        setSellIn(getSellIn() - 1);
    }
}
