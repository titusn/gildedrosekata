package com.gildedrose;

public class Item {

    protected String name;

    protected int sellIn;

    protected int quality;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item createItem(String name, int sellIn, int quality) {
        switch (name) {
            case "Aged Brie":
                return new AgedBrie(sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(sellIn, quality);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(sellIn, quality);
            case "Conjured":
                return new Conjured(sellIn, quality);
            default:
                return new Item(name, sellIn, quality);
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    protected void updateQuality() {
        decreaseQuality();

        updateSellIn();

        if (sellInDateHasPassed()) {
            decreaseQuality();
        }

        if (quality < 0) {
            quality = 0;
        }
    }

    private void decreaseQuality() {
        quality--;
    }

    protected void increaseQuality() {
        quality++;
    }

    protected void updateSellIn() {
        sellIn--;
    }

    protected boolean sellInDateHasPassed() {
        return sellIn < 0;
    }
}
