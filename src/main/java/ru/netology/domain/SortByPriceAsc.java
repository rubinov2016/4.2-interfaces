package ru.netology.domain;

import java.util.Comparator;

public class SortByPriceAsc implements Comparator<Booking> {
    // Used for sorting in ascending order of
    // roll number
    public int compare(Booking a, Booking b)
    {
        return a.getPrice() - b.getPrice();
    }
}