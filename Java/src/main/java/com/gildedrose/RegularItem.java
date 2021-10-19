package com.gildedrose;

public class RegularItem extends Item {

  public RegularItem(final ItemName name, final SellIn sellIn, final Quality quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    decreaseSellIn();
    decreaseQuality();
  }

  protected void decreaseQuality() {
    quality.decrease();

    if (getSellIn().isNegative()) {
      quality.decrease();
    }

  }

}
