package com.gildedrose.oop;

import com.gildedrose.oop.Product.Product;
import com.gildedrose.oop.Product.factory.ProductFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Product product = ProductFactory.getProduct(items[i].name, items[i].quality, items[i].sellIn);
            product.updateQuality();
            items[i] = product.convertToItem();
        }
    }
}
