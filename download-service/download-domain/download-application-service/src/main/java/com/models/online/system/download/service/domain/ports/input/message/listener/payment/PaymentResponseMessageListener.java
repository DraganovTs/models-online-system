package com.models.online.system.download.service.domain.ports.input.message.listener.payment;

import com.models.online.system.download.service.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {

    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}
