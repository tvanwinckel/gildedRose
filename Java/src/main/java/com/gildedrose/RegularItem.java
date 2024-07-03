package com.gildedrose;

public class RegularItem implements InventoryItem {

    private String name;
    private int sellIn;
    private int quality;

    public RegularItem(final String name, final int sellIn, final int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    @Override
    public void update() {

    }
}
