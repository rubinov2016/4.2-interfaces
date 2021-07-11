package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    private Ticket[] items = new Ticket[0];

    //позволяющий сохранять
    public void save(Ticket item) {
        int length = items.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Ticket[] findAll() {
        return items;
    }

    //
    public Ticket findById(int id) {
        for (Ticket item : items) {
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
            Ticket[] tmp = new Ticket[length];
            int index = 0;
            for (Ticket item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }
}