package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void defaultItemShouldLowerSellInAndQualityAtTheEndOfEachDay() {
        Item[] items = new Item[] {
            new Item("classic sofa brown color", 20, 50),
            new Item("bed red color modern style", 30, 20),
            new Item("macbook 15 air pink color", 40, 30)
        };

        GildedRose app = new GildedRose(items);
        for(int i = 0; i < 16 ; i++) {
            app.updateQuality();
        }

        assertEquals(items[0].quality, 34);
        assertEquals(items[0].sellIn, 4);

        assertEquals(items[1].quality, 4);
        assertEquals(items[1].sellIn, 14);

        assertEquals(items[2].quality, 14);
        assertEquals(items[2].sellIn, 24);
    }

    @Test
    void itemQualityShouldNeverNegative() {
        Item[] items = new Item[] {
            new Item("Aged Brie", 10, 50),
            new Item("Sulfuras, Hand of Ragnaros", 6, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 8, 30),
            new Item("Default Item", 8, 30),

        };

        GildedRose app = new GildedRose(items);
        for(int i = 0; i < 80 ; i++) {
            app.updateQuality();
        }

        assertTrue(items[0].quality >= 0);
        assertTrue(items[1].quality >= 0);
        assertTrue(items[2].quality >= 0);
        assertTrue(items[3].quality >= 0);
    }

    @Test
    void agedBrieQualityShouldIncreasesTheOlder() {
        Item[] items = new Item[] {
            new Item("Aged Brie", 10, 5),
        };

        GildedRose app = new GildedRose(items);
        for(int i = 0; i < 20 ; i++) {
            app.updateQuality();
        }

        assertEquals(items[0].quality, 35);
        assertEquals(items[0].sellIn, -10);
    }

    @Test
    void qualityShouldNeverMoreThan50() {
        Item[] items = new Item[] {
            new Item("Aged Brie", 10, 40),
            new Item("Backstage passes to a TAFKAL80ETC concert", 60, 30),
        };

        GildedRose app = new GildedRose(items);
        for(int i = 0; i < 50 ; i++) {
            app.updateQuality();
        }

        assertEquals(items[0].quality, 50);
        assertEquals(items[1].quality, 50);
    }

    @Test
    void sulfurasShouldNeverHasSoldOrDecreaseQuality() {
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 30, 40)
        };

        GildedRose app = new GildedRose(items);
        for(int i = 0; i < 50 ; i++) {
            app.updateQuality();
        }
        assertEquals(items[0].quality, 40);
        assertEquals(items[0].sellIn, 30);
    }

    @Test
    void backstagePassesShouldDynamicQualityDependOnSellIn() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 20, 5)
        };

        GildedRose app = new GildedRose(items);
        for(int i = 0; i < 18 ; i++) {
            app.updateQuality();
        }
        assertEquals(items[0].quality, 34);
    }
}
