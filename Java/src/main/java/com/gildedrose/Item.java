package com.gildedrose;

import java.util.Objects;

public abstract class Item {

  private final ItemName name;

  protected final SellIn sellIn;

  protected final Quality quality;

  protected Item(final ItemName name, final SellIn sellIn, final Quality quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public abstract void updateQuality();

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Item item = (Item) o;
    return Objects.equals(name, item.name)
        && Objects.equals(sellIn, item.sellIn)
        && Objects.equals(quality, item.quality);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, sellIn, quality);
  }

  @Override
  public String toString() {
    return name + ", " + sellIn + ", " + quality;
  }
}
