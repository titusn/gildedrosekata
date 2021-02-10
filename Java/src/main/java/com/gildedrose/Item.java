package com.gildedrose;

public class Item {

    protected Quality quality;
    protected String name;

    protected int sellIn;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = new Quality(quality);
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
        return this.name + ", " + this.sellIn + ", " + this.quality.toString();
    }

    protected void updateQuality() {

        quality.decrease();

        updateSellIn();

        if (sellInDateHasPassed()) {
            quality.decrease();
        }
    }

    protected void updateSellIn() {
        sellIn--;
    }

    protected boolean sellInDateHasPassed() {
        return sellIn < 0;
    }
}
