package com.parkingbackend.service;

import com.parkingbackend.model.Booking;
import com.parkingbackend.model.Slot;
import com.parkingbackend.repository.BookingRepository;
import com.parkingbackend.repository.SlotRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final SlotRepository slotRepository;

    public BookingService(BookingRepository bookingRepository, SlotRepository slotRepository) {
        this.bookingRepository = bookingRepository;
        this.slotRepository = slotRepository;
    }

    public Slot createSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    public List<Slot> listSlots() {
        return slotRepository.findAll();
    }

    public Booking createBooking(Booking booking) {
        booking.setStatus("PENDING");
        booking.setStartTime(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    public Optional<Booking> getBooking(Long id) {
        return bookingRepository.findById(id);
    }
}
