package com.gildedrose.inventory;

import static java.lang.Math.min;

public class AgedBrie extends InventoryItem {

    public static final String AGED_BRIE = "Aged Brie";
    private static final int MAX_ITEM_QUALITY = 50;

    public AgedBrie(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        final int qualityIncrease = sellIn > 0 ? 1 : 2;
        quality = min(quality + qualityIncrease, MAX_ITEM_QUALITY);
        sellIn = sellIn - 1;
    }
}
