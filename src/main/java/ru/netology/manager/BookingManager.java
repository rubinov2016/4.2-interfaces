
package ru.netology.manager;


import ru.netology.domain.Booking;
import ru.netology.domain.SortByPriceAsc;
import ru.netology.repository.BookingRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BookingManager {
    private BookingRepository repository;

    public BookingManager(BookingRepository repository) {
        this.repository = repository;
    }

    public void save(Booking item) {
        repository.save(item);
    }

    public Booking findById(int id) {
        Booking booking = repository.findById(id);
        return booking;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Booking[] findAll(String from, String to, Comparator<Booking> comparator) {
        Booking[] items = repository.findAll();
        //TODO check on null
        Booking[] foundItems = new Booking[0];
        for (Booking item : items) {
            if ((item.getFrom() == from) && (item.getTo() == to)) {
                int length = foundItems.length + 1;
                Booking[] tmp = new Booking[length];
                System.arraycopy(foundItems, 0, tmp, 0, foundItems.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = item;
                foundItems = tmp;
            }
        }
        if (foundItems.length > 0) {
            Arrays.sort(foundItems, new SortByPriceAsc());
            return foundItems;
        } else {
            return null;
        }
    }

}