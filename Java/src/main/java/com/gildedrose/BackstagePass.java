package com.gildedrose;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        quality.increase();

        if (SellInSoon()) {
            quality.increase();
        }

        if (SellInVerySoon()) {
            quality.increase();
        }

        sellIn.update();

        if (sellIn.hasPassed()) {
            quality = new Quality(0);
        }
    }

    private boolean SellInVerySoon() {
        return sellIn.get() < 6;
    }

    private boolean SellInSoon() {
        return sellIn.get() < 11;
    }
}