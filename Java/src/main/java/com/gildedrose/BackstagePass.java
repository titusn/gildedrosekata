package com.gildedrose;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        quality.increase();

        if (sellIn.get() < 11) {
            quality.increase();
        }

        if (sellIn.get() < 6) {
            quality.increase();
        }

        sellIn.update();

        if (sellIn.hasPassed()) {
            quality = new Quality(0);
        }
    }
}