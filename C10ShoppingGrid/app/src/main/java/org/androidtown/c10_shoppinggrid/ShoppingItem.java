package org.androidtown.c10_shoppinggrid;

/**
 * Created by young on 2018-04-03.
 */

public class ShoppingItem {
    String name;
    String price;
    String description;
    int resId;

    public ShoppingItem(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public ShoppingItem(String name, String price, String description, int resId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
