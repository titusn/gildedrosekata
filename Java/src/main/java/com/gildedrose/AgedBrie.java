package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }

        super.updateSellIn();

        if (sellIn < 0) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }
}
