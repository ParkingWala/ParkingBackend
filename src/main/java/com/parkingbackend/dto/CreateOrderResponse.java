package com.parkingbackend.dto;

import lombok.Data;

@Data
public class CreateOrderResponse {
    private String orderId;
    private String paymentToken;
    private Double amount;
}
