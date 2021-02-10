package com.gildedrose;

public class Conjured extends Item {
    Conjured(int sellIn, int quality) {
        super("Conjured", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        quality.decrease();
        quality.decrease();

        updateSellIn();

        if (sellInDateHasPassed()) {
            quality.decrease();
            quality.decrease();
        }
    }
}
