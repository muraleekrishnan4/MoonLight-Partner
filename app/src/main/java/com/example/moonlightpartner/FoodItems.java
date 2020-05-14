package com.example.moonlightpartner;

import android.content.res.Resources;

import java.util.List;
import java.util.Vector;

public class FoodItems {

    private static List<Product> catalog;

    public static List<Product> getCatalog() {
        if (catalog == null) {
            catalog = new Vector<Product>();

            catalog.add(new Product("0","CHANA MASHALA",
                    "Chana mashala made with diff. spices and shud desi ghee", 120.50));
            catalog.add(new Product("1","CHICKEN KORMA",
                    "Chicken korma ! fav dish of the day", 180.50));
            catalog.add(new Product("2","CHICKEN TIKKA",
                    "spicey chicken tikaa with maa ka pyaar", 250.50));

            catalog.add(new Product("3","PEAS PULAV",
                    "tasty and healty peas pulav", 110.50));
            catalog.add(new Product("4","ZEERA RICE",
                    "tasty tasty Zeera Rice!!!", 100.50));
            catalog.add(new Product("5","STEAM RICE",
                    "Rice with ghar ka taste!", 80.50));

            catalog.add(new Product("6","BUTTER NAAN",
                    "utterly butterly NaaN", 30.50));
            catalog.add(new Product("7","BUTTER KULCHA",
                    "desi kulche with butter", 20.50));
            catalog.add(new Product("8","RUMALI ROTI",
                    "Best Rumali Roti of sharma da dhaba", 50.50));
            catalog.add(new Product("9","PNR_B MASALA",
                    "Delicious paneer butter mashala", 150.50));
            catalog.add(new Product("10","PNR SCHEZWAN",
                    "Hydabadi paneer schezwan ..yammi", 120.50));
        }

        return catalog;
    }
}
