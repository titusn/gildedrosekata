package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter(MyIntellijReporter.class)
class GildedRoseTest {

    @Test
    void updateQualityTest() {
        String[] names = {"foo", "Aged Brie", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert"};
        Integer[] sellIns = {0, 11, -1, 2, 6};
        Integer[] qualities = {0, 1, 50, 49};
        CombinationApprovals.verifyAllCombinations(
                this::doUpdateQuality,
                names,
                sellIns,
                qualities
        );
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        String itemString = app.items[0].toString();
        return itemString;
    }


}
