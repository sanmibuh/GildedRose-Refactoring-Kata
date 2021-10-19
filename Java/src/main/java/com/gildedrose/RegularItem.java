package com.gildedrose;

public class RegularItem extends Item {

  public RegularItem(final ItemName name, final int sellIn, final int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    sellIn--;
    decreaseQuality();
  }

  protected void decreaseQuality() {
    if (quality > MIN_QUALITY) {
      quality--;

      if (sellIn < 0 && quality > MIN_QUALITY) {
        quality--;
      }
    }
  }

}
