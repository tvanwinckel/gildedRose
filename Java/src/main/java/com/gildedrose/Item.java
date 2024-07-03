package com.gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Item {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final int MAX_ITEM_QUALITY = 50;
    public static final int MIN_ITEM_QUALITY = 0;


    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void update() {
        if (isAgedBrie()) {
            final int qualityIncrease = sellIn > 0 ? 1 : 2;
            quality = min(quality + qualityIncrease, MAX_ITEM_QUALITY);
            sellIn = sellIn - 1;
        } else if (isBackstagePass()) {
            quality = sellIn > 0 ? calculateBackstagePassItemQuality() : MIN_ITEM_QUALITY;
            sellIn = sellIn - 1;
        } else if (isSulfuras()) {
            // sulfuras does nothing
        } else {
            final int qualityDecrease = sellIn > 0 ? 1 : 2;
            quality = max(quality - qualityDecrease, MIN_ITEM_QUALITY);
            sellIn = sellIn - 1;
        }


    }

    private int calculateBackstagePassItemQuality() {
        final int qualityIncrease;
        if (sellIn < 6) {
            qualityIncrease = 3;
        } else if (sellIn < 11){
            qualityIncrease = 2;
        } else {
            qualityIncrease = 1;
        }
        return min(quality + qualityIncrease, MAX_ITEM_QUALITY);
    }

    private boolean isSulfuras() {
        return name.equals(SULFURAS);
    }

    private boolean isBackstagePass() {
        return name.equals(BACKSTAGE_PASSES);
    }

    private boolean isAgedBrie() {
        return name.equals(AGED_BRIE);
    }
}
