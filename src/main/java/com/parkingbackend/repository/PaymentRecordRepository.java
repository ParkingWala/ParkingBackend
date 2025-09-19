package com.parkingbackend.repository;

import com.parkingbackend.model.PaymentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRecordRepository extends JpaRepository<PaymentRecord, Long> {
    PaymentRecord findByOrderId(String orderId);
}
