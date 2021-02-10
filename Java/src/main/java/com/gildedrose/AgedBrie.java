package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        quality.increase();

        super.updateSellIn();

        if (sellInDateHasPassed()) {
            quality.increase();
        }
    }
}
