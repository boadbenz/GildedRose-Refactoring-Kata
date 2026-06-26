package com.gildedrose.oop.Product;

public class CommonProductImpl extends ProductBase implements Product {
    public CommonProductImpl(String name, int quality, int sellIn) {
        super(name, quality, sellIn);
    }

    @Override
    public void updateQuality() {
        setQuality(getQuality() - 1);
        setSellIn(getSellIn() - 1);

        if(getSellIn() < 0) {
            setQuality(getQuality() - getQuality());
        }
    }
}
