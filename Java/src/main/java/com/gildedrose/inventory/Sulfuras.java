package com.gildedrose.inventory;

public class Sulfuras extends InventoryItem {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        // Do nothing
    }
}
