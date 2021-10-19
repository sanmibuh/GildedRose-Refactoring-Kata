package com.gildedrose;

public class ConjuredItem extends RegularItem {

  public ConjuredItem(final ItemName name, final int sellIn, final int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    super.updateQuality();
    super.decreaseQuality();
  }

}
