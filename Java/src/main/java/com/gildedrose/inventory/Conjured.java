package com.gildedrose.inventory;

import static java.lang.Math.max;

public class Conjured extends InventoryItem {

    public static final String CONJURED = "Conjured";
    private static final int MIN_ITEM_QUALITY = 0;

    public Conjured(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        final int qualityDecrease = sellIn > 0 ? 2 : 4;
        quality = max(quality - qualityDecrease, MIN_ITEM_QUALITY);
        sellIn = sellIn - 1;
    }
}
