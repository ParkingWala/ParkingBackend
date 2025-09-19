package com.parkingbackend.controller;

import com.parkingbackend.dto.CreateOrderRequest;
import com.parkingbackend.dto.CreateOrderResponse;
import com.parkingbackend.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create-order")
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest req) {
        CreateOrderResponse resp = paymentService.createOrder(req);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/verify")
    public ResponseEntity<Map<String, Object>> verify(@RequestBody Map<String, String> body) {
        String orderId = body.get("orderId");
        String paymentId = body.get("paymentId");
        boolean ok = paymentService.verifyPayment(orderId, paymentId);
        return ResponseEntity.ok(Map.of("success", ok));
    }
}
