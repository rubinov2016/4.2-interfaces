package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Booking;
import ru.netology.domain.SortByPriceAsc;
import ru.netology.repository.BookingRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BookingManagerTest {
    private BookingRepository repository = new BookingRepository();
    private BookingManager manager = new BookingManager(repository);
    private Booking bookingLed = new Booking(101, 1000, "LED", "MSK", 100);
    private Booking bookingLed2 = new Booking(102, 1001, "LED", "MSK", 100);
    private Booking bookingLed3 = new Booking(103, 1002, "LED", "MSK", 100);
    private Booking bookingFru = new Booking(103, 1002, "FRU", "MSK", 100);

    @Test
    public void shouldSort() {
        manager.save(bookingLed2);
        manager.save(bookingLed);
        manager.save(bookingLed3);
        Booking[] expected = new Booking[]{bookingLed,bookingLed2,bookingLed3};
        Booking[] actual = manager.findAll("LED","MSK",new SortByPriceAsc());
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveById() {
        manager.save(bookingLed);
        manager.save(bookingLed2);
        manager.removeById(bookingLed.getId());
        Booking[] expected = new Booking[]{bookingLed2};
        Booking[] actual = manager.findAll("LED","MSK",new SortByPriceAsc());
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindById() {
        manager.save(bookingLed);
        Booking[] expected = new Booking[]{bookingLed};
        Booking[] actual = {manager.findById(101)};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindAllNotExist() {
        manager.save(bookingLed);
        Booking[] actual = manager.findAll("MSK","MSK",new SortByPriceAsc());
        assertArrayEquals(null, actual);
        actual = manager.findAll("LED","LED",new SortByPriceAsc());
        assertArrayEquals(null, actual);
        actual = manager.findAll("FRU","FRU",new SortByPriceAsc());
        assertArrayEquals(null, actual);
    }
    @Test
    public void shouldFindAll() {
        manager.save(bookingLed);
        manager.save(bookingFru);
        Booking[] expected = new Booking[]{bookingLed};
        Booking[] actual = manager.findAll("LED","MSK",new SortByPriceAsc());
        assertArrayEquals(expected, actual);
    }
}
