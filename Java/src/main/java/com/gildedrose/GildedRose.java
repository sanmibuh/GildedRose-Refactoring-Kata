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
    for (int i = 0; i < items.length; i++) {
      items[i].updateQuality();
    }
  }
}