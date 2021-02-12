package com.gildedrose;

public class Item {

    protected final SellIn sellIn;
    protected Quality quality;
    protected String name;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = new SellIn(sellIn);
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
        return this.name + ", " + this.sellIn.toString() + ", " + this.quality.toString();
    }

    protected void updateQuality() {

        quality.decrease();

        sellIn.update();

        if (sellIn.hasPassed()) {
            quality.decrease();
        }
    }
    }
