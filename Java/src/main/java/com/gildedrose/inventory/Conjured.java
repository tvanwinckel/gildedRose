package com.gildedrose.inventory;

import static java.lang.Math.max;

public class Conjured implements InventoryUpdate {

    public static final String CONJURED = "Conjured";
    private static final int MIN_ITEM_QUALITY = 0;

    private final String name;
    private int sellIn;
    private int quality;

    public Conjured(final String name, final int sellIn, final int quality) {
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
        final int qualityDecrease = sellIn > 0 ? 2 : 4;
        quality = max(quality - qualityDecrease, MIN_ITEM_QUALITY);
        sellIn = sellIn - 1;
    }
}
