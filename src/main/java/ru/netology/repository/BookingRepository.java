package ru.netology.repository;

import ru.netology.domain.Booking;

public class BookingRepository {
    private Booking[] items = new Booking[0];

    //позволяющий сохранять
    public void save(Booking item) {
        int length = items.length + 1;
        Booking[] tmp = new Booking[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Booking[] findAll() {
        return items;
    }

    //
    public Booking findById(int id) {
        for (Booking item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    //добавить проверку на отсутствие ID
    public void removeById(int id) {
        if (findById(id) != null) {
            int length = items.length - 1;
            Booking[] tmp = new Booking[length];
            int index = 0;
            for (Booking item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }
}