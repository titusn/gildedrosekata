package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQualityTest() {
        CombinationApprovals.verifyAllCombinations(
                this::doUpdateQuality,
                new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
                new Integer[]{-1, 0, 5, 6, 11},
                new Integer[]{0, 1, 50, 49}
        );
    }

    @Test
    void createConjuredItem() {
        Item conjuredItem = new Item("Conjured", 1, 2);
        assertNotNull(conjuredItem);
        assertTrue(conjuredItem.toString().startsWith("Conjured"));
        assertEquals(conjuredItem.sellIn, 1);
        assertEquals(conjuredItem.quality, 2);
    }

    @Test
    void createConjuredItemQualityShouldDegradeTwiceAsFast() {
        Item conjuredItem = Item.createItem("Conjured", 1, 2);
        conjuredItem.updateQuality();
        assertEquals(0, conjuredItem.sellIn, "SellIn should be lowered by 1");
        assertEquals(0, conjuredItem.quality, "Quality should degrade twice as fast as normal item");
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[]{Item.createItem(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        String itemString = app.items[0].toString();
        return itemString;
    }

}
