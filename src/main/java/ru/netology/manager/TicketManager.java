package ru.netology.manager;


import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] ticket = repository.findAll();
        //TODO add logic

        return ticket;
    }

    public Ticket findById(int id) {
        Ticket ticket = repository.findById(id);
        return ticket;
    }
}