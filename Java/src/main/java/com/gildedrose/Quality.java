package com.gildedrose;

import java.util.Objects;

public class Quality implements Comparable<Integer> {

  private static final int MIN_QUALITY = 0;

  private int value;

  private Quality(final int value) {
    this.value = value;
  }

  public static Quality of(final int value) {
    return new Quality(value);
  }

  public void increase() {
    value++;
  }

  public void decrease() {
    value--;
  }

  public void reset() {
    value = 0;
  }

  @Override
  public int compareTo(final Integer o) {
    return Integer.compare(value, o);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Quality quality = (Quality) o;
    return value == quality.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
