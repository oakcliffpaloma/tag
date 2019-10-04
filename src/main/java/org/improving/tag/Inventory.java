package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.ItemComparator;
import org.improving.tag.items.UniqueItems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);
    }


    public String getInventoryDisplay() {
        String displayString = "You have these Items: ";


        for (Item item : items) {
            displayString += "\n" + item;
        }
        return displayString;
    /*   return items.stream().sorted(new ItemComparator()).map(i -> "\n" +i)
            .reduce(displayString, (answer, itemVale) -> answer+= itemVale);*/

    }

    public Item getItem() {
        return items.get(0);}
    }

