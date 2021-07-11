package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingTest {
    Booking bookingLed = new Booking(101, 1000, "LED", "MSK", 100);
    @Test
    public void shouldSetId() {
        int expected = 102;
        bookingLed.setId(expected);
        int actual = bookingLed.getId();
        assertEquals(expected, actual);
    }
}
