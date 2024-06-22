package com.gildedrose;

public class ItemUpdater {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final int MAX_ITEM_QUALITY = 50;
    public static final int MIN_ITEM_QUALITY = 0;

    public static void update(final Item item) {
        if (!isAgedBrie(item) && !isBackstagePass(item)) {
            if (item.quality > MIN_ITEM_QUALITY) {
                if (!isSulfuras(item)) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < MAX_ITEM_QUALITY) {
                item.quality = item.quality + 1;

                if (isBackstagePass(item)) {
                    if (item.sellIn < 11) {
                        if (item.quality < MAX_ITEM_QUALITY) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < MAX_ITEM_QUALITY) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!isSulfuras(item)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!isAgedBrie(item)) {
                if (!isBackstagePass(item)) {
                    if (item.quality > MIN_ITEM_QUALITY) {
                        if (!isSulfuras(item)) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = MIN_ITEM_QUALITY;
                }
            } else {
                if (item.quality < MAX_ITEM_QUALITY) {
                    item.quality = item.quality + 1;
                }
            }
        }
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
}
