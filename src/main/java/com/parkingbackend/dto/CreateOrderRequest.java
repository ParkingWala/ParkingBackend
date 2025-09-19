package com.parkingbackend.dto;

import lombok.Data;

@Data
public class CreateOrderRequest {
    private Long bookingId;
    private Double amount;
    private String currency = "INR";
}
