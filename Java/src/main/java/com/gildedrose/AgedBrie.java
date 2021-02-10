package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        quality.increase();

        sellIn.update();

        if (sellIn.hasPassed()) {
            quality.increase();
        }
    }
}
