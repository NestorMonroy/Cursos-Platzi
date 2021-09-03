package org.nestor.javatests.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);
}
