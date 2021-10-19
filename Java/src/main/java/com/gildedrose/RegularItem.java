package com.gildedrose;

public class RegularItem extends Item {

  public RegularItem(final ItemName name, final SellIn sellIn, final Quality quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    sellIn.decrease();
    decreaseQuality();
  }

  protected void decreaseQuality() {
    if (quality.compareTo(MIN_QUALITY) > 0) {
      quality.decrease();

      if (sellIn.isNegative() && quality.compareTo(MIN_QUALITY) > 0) {
        quality.decrease();
      }
    }
  }

}
