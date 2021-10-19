package com.gildedrose;

import java.util.Objects;

public class Item {

  public final String name;

  public int sellIn;

  public int quality;

  public Item(final String name, final int sellIn, final int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Item item = (Item) o;
    return sellIn == item.sellIn && quality == item.quality && name.equals(item.name);
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
