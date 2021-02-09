package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        quality++;

        super.updateSellIn();

        if (sellIn < 0) {
            quality++;
        }

        if (quality > 50) {
            quality = 50;
        }
    }
}
