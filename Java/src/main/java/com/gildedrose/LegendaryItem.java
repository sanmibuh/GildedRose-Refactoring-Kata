package com.gildedrose;

public class LegendaryItem extends Item {

  public LegendaryItem(final ItemName name, final int sellIn, final int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    //do nothing
  }
}
