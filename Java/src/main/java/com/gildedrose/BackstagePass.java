package com.gildedrose;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();

        if (sellIn < 11) {
            increaseQuality();
        }

        if (sellIn < 6) {
            increaseQuality();
        }

        super.updateSellIn();

        limitQuality();
    }

    @Override
    protected void limitQuality() {
        if (sellInDateHasPassed()) {
            quality = 0;
        }

        if (quality > 50) {
            quality = 50;
        }
    }
}
