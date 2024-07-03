package com.gildedrose.inventory;

public abstract class InventoryItem implements InventoryUpdate {

    protected final String name;
    protected int sellIn;
    protected int quality;

    protected InventoryItem(final String name, final int sellIn, final int quality) {
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
    public abstract void update();
}
