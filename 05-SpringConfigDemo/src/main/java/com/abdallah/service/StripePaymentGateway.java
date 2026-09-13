package com.abdallah.service;

public class StripePaymentGateway implements PaymentGateway {

    @Override
    public void pay(double amount) {

        System.out.println(
                "Payment of $" + amount +
                        " processed using Stripe."
        );

    }
}