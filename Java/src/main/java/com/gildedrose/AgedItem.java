package com.gildedrose;

public class AgedItem extends Item {

  public AgedItem(final ItemName name, final SellIn sellIn, final Quality quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    decreaseSellIn();
    increaseQuality();

    if (getSellIn().isNegative()) {
      increaseQuality();
    }

  }
}
