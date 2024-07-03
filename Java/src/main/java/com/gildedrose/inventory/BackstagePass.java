package com.gildedrose.inventory;

import static java.lang.Math.min;

public class BackstagePass implements InventoryItem {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final int MAX_ITEM_QUALITY = 50;
    private static final int MIN_ITEM_QUALITY = 0;

    private final String name;
    private int sellIn;
    private int quality;

    public BackstagePass(final String name, final int sellIn, final int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    @Override
    public void update() {
        quality = sellIn > 0 ? calculateBackstagePassItemQuality() : MIN_ITEM_QUALITY;
        sellIn = sellIn - 1;
    }

    private int calculateBackstagePassItemQuality() {
        final int qualityIncrease;
        if (sellIn < 6) {
            qualityIncrease = 3;
        } else if (sellIn < 11) {
            qualityIncrease = 2;
        } else {
            qualityIncrease = 1;
        }
        return min(quality + qualityIncrease, MAX_ITEM_QUALITY);
    }
}
