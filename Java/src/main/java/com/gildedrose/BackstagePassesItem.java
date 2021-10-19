package com.gildedrose;

public class BackstagePassesItem extends Item {

  private static final int DOUBLED_QUALITY_SELL_IN_INDEX = 11;
  private static final int TRIPLED_QUALITY_SELL_IN_INDEX = 6;

  public BackstagePassesItem(final ItemName name, final SellIn sellIn, final Quality quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    increaseQuality();

    if (getSellIn().isLessThan(DOUBLED_QUALITY_SELL_IN_INDEX)) {
      increaseQuality();
    }

    if (getSellIn().isLessThan(TRIPLED_QUALITY_SELL_IN_INDEX)) {
      increaseQuality();
    }

    decreaseSellIn();

    if (getSellIn().isNegative()) {
      resetQuality();
    }
  }
}
