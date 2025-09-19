package com.parkingbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long slotId;
    private String userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String status; // PENDING, CONFIRMED, CANCELLED

    private String paymentId; // Payment gateway payment id
}
