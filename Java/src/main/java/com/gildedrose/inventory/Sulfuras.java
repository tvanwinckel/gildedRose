package com.gildedrose.inventory;

public class Sulfuras implements InventoryUpdate {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private final String name;
    private final int sellIn;
    private final int quality;

    public Sulfuras(final String name, final int sellIn, final int quality) {
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
        // Do nothing
    }
}
