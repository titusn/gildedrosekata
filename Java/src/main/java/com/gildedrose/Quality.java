package com.gildedrose;

public class Quality {
    private static final int DEFAULT_MAX_QUALITY = 50;

    private int quality;
    private int maxQuality;

    public Quality(int quality) {
        this.quality = quality;
        maxQuality = DEFAULT_MAX_QUALITY;
    }

    protected void decrease() {
        quality--;
        limit();
    }

    protected void increase() {
        quality++;
        limit();
    }

    private void limit() {
        if (quality < 0) {
            quality = 0;
        }
        if (quality > maxQuality) {
            quality = maxQuality;
        }
    }

    public String toString() {
        return Integer.toString(quality);
    }
}