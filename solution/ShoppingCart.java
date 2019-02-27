package com.intuit.pcg.training;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajendran1 on 6/12/18.
 */
public class ShoppingCart {

    List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Item item : items) {
            int cost = item.calculateCost();
            total += cost;
            System.out.println(cost);
        }
        return total;
    }
}
