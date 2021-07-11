package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Booking;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BookingRepositoryTest {
    private BookingRepository repository = new BookingRepository();
    private Booking coreJava = new Booking();
    private Booking BookingLed = new Booking(101, 1000, "LED", "MSK", 100);

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);
        Booking[] expected = new Booking[]{coreJava};
        Booking[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.save(coreJava);
        repository.save(BookingLed);
        repository.removeById(BookingLed.getId());
        Booking[] expected = new Booking[]{coreJava};
        Booking[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNotExists() {
        repository.save(coreJava);
        repository.save(BookingLed);
        repository.removeById(1000);
        Booking[] expected = new Booking[]{coreJava, BookingLed};
        Booking[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
