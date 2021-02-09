package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();

        super.updateSellIn();

        if (sellIn < 0) {
            increaseQuality();
        }

        if (quality > 50) {
            quality = 50;
        }
    }

    private void increaseQuality() {
        quality++;
    }
}
