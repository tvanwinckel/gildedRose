package com.gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ItemUpdater {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured";
    public static final int MAX_ITEM_QUALITY = 50;
    public static final int MIN_ITEM_QUALITY = 0;
    public static final int DEADLINE = 0;

    public static void update(final Item item) {
        if (isAgedBrie(item)) {
            updateBrie(item);
        } else if (isBackstagePass(item)) {
            updateBackstagePass(item);
        } else if (isSulfuras(item)) {
            // nothing applies here
        } else if (isConjured(item)) {
            updateConjured(item);
        } else {
            final RegularItemUpdater riu = new RegularItemUpdater();
            riu.update(item);
        }
    }

    private static void updateBrie(final Item item) {
        final int quality = item.sellIn > DEADLINE ? 1 : 2;
        item.quality = min(item.quality + quality, MAX_ITEM_QUALITY);
        item.sellIn = item.sellIn - 1;
    }

    private static void updateBackstagePass(final Item item) {
        item.quality = item.sellIn > DEADLINE ? calculateBackstagePassItemQuality(item) : MIN_ITEM_QUALITY;
        item.sellIn = item.sellIn - 1;
    }

    private static int calculateBackstagePassItemQuality(final Item item) {
        final int quality;
        if (item.sellIn < 6) {
            quality = 3;
        } else if (item.sellIn < 11) {
            quality = 2;
        } else {
            quality = 1;
        }
        return min(item.quality + quality, MAX_ITEM_QUALITY);
    }

    private static void updateConjured(final Item item) {
        final int quality = item.sellIn > DEADLINE ? 2 : 4;
        item.quality = max(item.quality - quality, MIN_ITEM_QUALITY);
        item.sellIn = item.sellIn - 1;
    }

    private static boolean isSulfuras(final Item item) {
        return item.name.equals(SULFURAS);
    }

    private static boolean isBackstagePass(final Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private static boolean isAgedBrie(final Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private static boolean isConjured(final Item item) {
        return item.name.contains(CONJURED);
    }
}
