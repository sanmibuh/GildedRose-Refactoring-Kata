package com.gildedrose;

class GildedRose {

  private final Item[] items;

  public GildedRose(final Item[] items) {
    this.items = items;
  }

  public Item[] getItems() {
    return items;
  }

  public void updateQuality() {
    for (final Item item : items) {
      item.updateQuality();
    }
  }
}