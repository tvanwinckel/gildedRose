package com.gildedrose;

import static java.lang.Math.min;

public class AgedBrie implements InventoryItem {

    public static final String AGED_BRIE = "Aged Brie";
    private static final int MAX_ITEM_QUALITY = 50;

    private final String name;
    private int sellIn;
    private int quality;
    public AgedBrie(final String name, final int sellIn, final int quality) {
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
        final int qualityIncrease = sellIn > 0 ? 1 : 2;
        quality = min(quality + qualityIncrease, MAX_ITEM_QUALITY);
        sellIn = sellIn - 1;
    }
}
