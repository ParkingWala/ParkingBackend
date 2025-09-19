package com.parkingbackend.controller;

import com.parkingbackend.repository.PaymentRecordRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Minimal webhook endpoint for payment gateway callbacks.
 * IMPORTANT: Verify the signature present in the webhook headers/body before trusting.
 */
@RestController
@RequestMapping("/api/webhook")
public class WebhookController {

    private final PaymentRecordRepository paymentRecordRepository;

    public WebhookController(PaymentRecordRepository paymentRecordRepository) {
        this.paymentRecordRepository = paymentRecordRepository;
    }

    @PostMapping("/phonepe")
    public ResponseEntity<String> phonePeWebhook(@RequestBody Map<String, Object> payload,
                                                 @RequestHeader Map<String, String> headers) {
        // TODO: verify webhook signature from PhonePe headers
        // Example: parse payload, find orderId/payment status and update DB
        // This is a placeholder that simply logs and returns 200.
        System.out.println("Received PhonePe webhook: " + payload);
        return ResponseEntity.ok("ok");
    }
}
