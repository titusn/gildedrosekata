package com.gildedrose;

public class Conjured extends Item {
    Conjured(int sellIn, int quality) {
        super("Conjured", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        quality.decrease();
        quality.decrease();

        sellIn.update();

        if (sellIn.hasPassed()) {
            quality.decrease();
            quality.decrease();
        }
    }
}
