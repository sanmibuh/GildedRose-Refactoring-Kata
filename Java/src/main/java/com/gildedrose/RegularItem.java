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

  @Override
  protected void decreaseQuality() {
    super.decreaseQuality();
    if (getSellIn().isNegative()) {
      super.decreaseQuality();
    }
  }

}
