package com.gildedrose;

import java.util.Objects;

public final class ItemName {

  final String value;

  private ItemName(final String value) {
    this.value = value;
  }

  public static ItemName of(final String value) {
    return new ItemName(value);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final ItemName itemName = (ItemName) o;
    return Objects.equals(value, itemName.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return value;
  }
}
