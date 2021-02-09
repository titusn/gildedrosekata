package com.gildedrose;

public class Conjured extends Item {
    Conjured(int sellIn, int quality) {
        super("Conjured", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        quality = quality - 2;

        super.updateSellIn();

        if (sellIn < 0) {
            quality = quality - 2;
        }

        if (quality < 0) {
            quality = 0;
        }
    }
}
