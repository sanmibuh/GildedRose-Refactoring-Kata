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

  public void updateQuality() {
    if (!name.equals("Aged Brie")
        && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      if (quality > 0) {
        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
          quality = quality - 1;
        }
      }
    } else {
      if (quality < 50) {
        quality = quality + 1;

        if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (sellIn < 11) {
            if (quality < 50) {
              quality = quality + 1;
            }
          }

          if (sellIn < 6) {
            if (quality < 50) {
              quality = quality + 1;
            }
          }
        }
      }
    }

    if (!name.equals("Sulfuras, Hand of Ragnaros")) {
      sellIn = sellIn - 1;
    }

    if (sellIn < 0) {
      if (!name.equals("Aged Brie")) {
        if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (quality > 0) {
            if (!name.equals("Sulfuras, Hand of Ragnaros")) {
              quality = quality - 1;
            }
          }
        } else {
          quality = quality - quality;
        }
      } else {
        if (quality < 50) {
          quality = quality + 1;
        }
      }
    }
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
