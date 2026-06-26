package com.gildedrose.oop.Product.factory;

import com.gildedrose.oop.Product.*;

public class ProductFactory {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSED = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static Product getProduct(String productName, int quality, int sellIn) {
        switch (productName) {
            case AGED_BRIE:
                return new AgedBrieImpl(productName, quality, sellIn);
            case BACKSTAGE_PASSED:
                return new BackstagePassesImpl(productName, quality, sellIn);
            case SULFURAS:
                return new SulfurasImpl(productName, quality, sellIn);
            default:
                return new CommonProductImpl(productName, quality, sellIn);
        }
    }

}
