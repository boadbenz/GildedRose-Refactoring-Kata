package com.gildedrose.function;

import java.util.Arrays;
import java.util.Comparator;

class GildedRose {
    Item[] items;

    interface SpecialItem<T extends SpecialItem> {
        T[] values();
        String name();
    }

    private enum LegendaryItem {
        SULFURAS("Sulfuras, Hand of Ragnaros");

        private final String name;

        private LegendaryItem(String name) {
            this.name = name;
        }

        static boolean findItemByName(String name) {
            return Arrays.stream(values()).anyMatch(item -> (item.name().equals(name)));
        }

        static Item processItem(Item item) {
            // Legendary Item Quality & Sell In will not modify
            if(findItemByName(item.name)) {
                // Legendary Item Quality & Sell In will not modify
            }
            return item;
        }
    }

    private enum ItemIncreaseQuality {
        AGE_BRIE("Aged Brie");

        private final String name;

        private ItemIncreaseQuality(String name) {
            this.name = name;
        }

        static boolean findItemByName(String name) {
            return Arrays.stream(values()).anyMatch(item -> (item.name().equals(name)));
        }

        static Item processItem(Item item) {
            if(findItemByName(item.name)) {

            }
            return item;
        }
    }

    private enum ItemIncreaseQualityDependSellIn{
        BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert");

        private final String name;

        private ItemIncreaseQualityDependSellIn(String name) {
            this.name = name;
        }

        static boolean findItemByName(String name) {
            return Arrays.stream(values()).anyMatch(item -> (item.name().equals(name)));
        }

        static Item processItem(Item item) {
            if(findItemByName(item.name)) {

            }
            return item;
        }
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            if (items[i].name.equals("Aged Brie")) {
                increaseQuality(items[i]);
            }

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseQuality(items[i]);
                increaseQualityDependSellIns(items[i], 6, 11);
            }

            if (items[i].quality > 0 && !(items[i].name.equals("Aged Brie")
                || items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"))) {
                items[i].quality = items[i].quality - 1;
            }

            items[i].sellIn = items[i].sellIn - 1;

            if (items[i].sellIn >= 0) {
                continue;
            }

            if (items[i].name.equals("Aged Brie") && items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
            }

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                items[i].quality = items[i].quality - items[i].quality;
            }

            if (!(items[i].name.equals("Aged Brie") || items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"))
                && items[i].quality > 0) {
                items[i].quality = items[i].quality - 1;
            }
        }
    }

    public void increaseQualityDependSellIns(Item item, Integer... sellIns) {
        Arrays.sort(sellIns, Comparator.reverseOrder());

        for(int i = 0; i < sellIns.length; i++) {
            if(item.sellIn < sellIns[i]) {
                increaseQuality(item);
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
