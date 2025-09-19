package com.parkingbackend.controller;

import com.parkingbackend.model.Booking;
import com.parkingbackend.model.Slot;
import com.parkingbackend.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/slot")
    public ResponseEntity<Slot> createSlot(@RequestBody Slot slot) {
        return ResponseEntity.ok(bookingService.createSlot(slot));
    }

    @GetMapping("/slots")
    public ResponseEntity<List<Slot>> listSlots() {
        return ResponseEntity.ok(bookingService.listSlots());
    }

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking b = bookingService.createBooking(booking);
        return ResponseEntity.ok(b);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        return bookingService.getBooking(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
