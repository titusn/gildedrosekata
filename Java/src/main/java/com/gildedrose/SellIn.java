package com.gildedrose;

public class SellIn {
    public int get() {
        return sellIn;
    }

    private int sellIn;

    public SellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    protected void update() {
        sellIn--;
    }

    protected boolean hasPassed() {
        return sellIn < 0;
    }

    @Override
    public String toString() {
        return Integer.toString(sellIn);
    }
}