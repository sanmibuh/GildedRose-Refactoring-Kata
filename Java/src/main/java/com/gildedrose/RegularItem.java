package com.gildedrose;

public class RegularItem extends Item {

  public RegularItem(final ItemName name, final SellIn sellIn, final int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    sellIn.decrease();
    decreaseQuality();
  }

  protected void decreaseQuality() {
    if (quality > MIN_QUALITY) {
      quality--;

      if (sellIn.isNegative() && quality > MIN_QUALITY) {
        quality--;
      }
    }
  }

}
