package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GildedRoseTest {

  @Test
  void should_decrease_the_quality_and_sellin() {
    final Item[] items = new Item[]{new RegularItem("foo", 10, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new RegularItem("foo", 9, 4);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_decrease_the_quality_twice_fast_when_negative_sellin() {
    final Item[] items = new Item[]{new RegularItem("foo", -1, 6)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new RegularItem("foo", -2, 4);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_not_decrease_the_quality_if_is_zero() {
    final Item[] items = new Item[]{new RegularItem("foo", 0, 0)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new RegularItem("foo", -1, 0);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_increase_the_quality_with_aged_brie_item() {
    final Item[] items = new Item[]{new AgedItem("Aged Brie", 10, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new AgedItem("Aged Brie", 9, 6);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_not_increase_the_quality_if_is_fifty() {
    final Item[] items = new Item[]{new AgedItem("Aged Brie", 10, 50)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new AgedItem("Aged Brie", 9, 50);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_sulfuras_item_never_decreases_quality_nor_sellin() {
    final Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new Item("Sulfuras, Hand of Ragnaros", 10, 5);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_backstages_increases_quality_with_selling_more_than_ten() {
    final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 6);
    assertEquals(expected, app.getItems()[0]);
  }

  @ParameterizedTest
  @ValueSource(ints = {10, 9, 8, 7, 6})
  void should_backstages_increases_by_two_quality_with_selling_between_ten_and_six(final int sellin) {
    final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", sellin, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new Item("Backstage passes to a TAFKAL80ETC concert", sellin - 1, 7);
    assertEquals(expected, app.getItems()[0]);
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 4, 3, 2, 1})
  void should_backstages_increases_by_three_quality_with_selling_less_than_five(final int sellin) {
    final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", sellin, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new Item("Backstage passes to a TAFKAL80ETC concert", sellin - 1, 8);
    assertEquals(expected, app.getItems()[0]);
  }

  @Test
  void should_backstages_drop_quality_to_zero_with_selling_zero() {
    final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5)};
    final GildedRose app = new GildedRose(items);
    app.updateQuality();
    final Item expected = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0);
    assertEquals(expected, app.getItems()[0]);
  }
  
}
