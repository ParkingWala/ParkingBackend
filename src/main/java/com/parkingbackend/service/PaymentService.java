package com.parkingbackend.service;

import com.parkingbackend.dto.CreateOrderRequest;
import com.parkingbackend.dto.CreateOrderResponse;
import com.parkingbackend.model.PaymentRecord;
import com.parkingbackend.repository.PaymentRecordRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Minimal PaymentService with placeholders for PhonePe integration.
 * Replace HTTP calls with PhonePe API endpoints & signature logic when ready.
 */
@Service
public class PaymentService {

    private final PaymentRecordRepository paymentRecordRepository;

    @Value("${phonepe.merchant.id:YOUR_MERCHANT_ID}")
    private String merchantId;

    @Value("${phonepe.salt:YOUR_SECRET}")
    private String merchantSalt;

    public PaymentService(PaymentRecordRepository paymentRecordRepository) {
        this.paymentRecordRepository = paymentRecordRepository;
    }

    public CreateOrderResponse createOrder(CreateOrderRequest req) {
        String orderId = "ORD-" + UUID.randomUUID().toString();
        // In a real implementation: call PhonePe create order API, sign request, parse token
        String paymentToken = "PHONEPE_TOKEN_PLACEHOLDER";

        PaymentRecord record = PaymentRecord.builder()
                .orderId(orderId)
                .bookingId(req.getBookingId())
                .amount(req.getAmount())
                .status("CREATED")
                .createdAt(LocalDateTime.now())
                .build();

        paymentRecordRepository.save(record);

        CreateOrderResponse resp = new CreateOrderResponse();
        resp.setOrderId(orderId);
        resp.setPaymentToken(paymentToken);
        resp.setAmount(req.getAmount());
        return resp;
    }

    public boolean verifyPayment(String orderId, String paymentId) {
        // In real implementation: call PhonePe verify API with merchant secret and paymentId
        PaymentRecord rec = paymentRecordRepository.findByOrderId(orderId);
        if (rec == null) return false;
        rec.setPaymentId(paymentId);
        rec.setStatus("SUCCESS");
        paymentRecordRepository.save(rec);
        return true;
    }
}
