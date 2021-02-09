package com.gildedrose;

public class Conjured extends Item {
    Conjured(int sellIn, int quality) {
        super("Conjured", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        quality = quality - 2;

        updateSellIn();

        if (sellInDateHasPassed()) {
            quality = quality - 2;
        }

        if (quality < 0) {
            quality = 0;
        }
    }
}
