package com.gildedrose;

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
            if (quality < MAX_ITEM_QUALITY) {
                quality = quality + 1;

                if (sellIn < 11) {
                    if (quality < MAX_ITEM_QUALITY) {
                        quality = quality + 1;
                    }
                }

                if (sellIn < 6) {
                    if (quality < MAX_ITEM_QUALITY) {
                        quality = quality + 1;
                    }
                }
            }

            sellIn = sellIn - 1;

            if (sellIn < 0) {
                quality = MIN_ITEM_QUALITY;
            }
        } else if (isSulfuras()) {
            // sulfuras does nothing
        } else {
            if (quality > MIN_ITEM_QUALITY) {
                quality = quality - 1;
            }

            sellIn = sellIn - 1;

            if (sellIn < 0) {
                if (quality > MIN_ITEM_QUALITY) {
                    quality = quality - 1;
                }
            }
        }


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
