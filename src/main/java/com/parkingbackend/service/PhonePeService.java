package com.parkingbackend.service;

import com.parkingbackend.dto.CreateOrderRequest;
import com.parkingbackend.dto.CreateOrderResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PhonePeService {

    @Value("${phonepe.merchant.id}")
    private String merchantId;

    @Value("${phonepe.salt}")
    private String salt;

    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        // If using dummy values, return mock response
        if ("YOUR_MERCHANT_ID".equals(merchantId)) {
            CreateOrderResponse mock = new CreateOrderResponse();
            mock.setOrderId(UUID.randomUUID().toString());
            mock.setPaymentToken("MOCK_PAYMENT_TOKEN");
            mock.setAmount(request.getAmount());
            return mock;
        }

        // TODO: add real PhonePe API call here later
        throw new UnsupportedOperationException("Real PhonePe integration not implemented yet");
    }
}
