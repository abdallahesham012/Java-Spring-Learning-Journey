package com.abdallah.service;

public class PaymentService {

    /*
        PaymentService يعتمد على PaymentGateway.

        لاحظ إننا بنستخدم interface
        مش implementation معين.

        يعني PaymentService مش عارف
        هل هنستخدم Stripe ولا PayPal.

        وده اسمه Dependency Injection.
    */

    private final PaymentGateway paymentGateway;


    /*
        Constructor Injection

        Spring هيبعت الـ PaymentGateway
        هنا أثناء إنشاء PaymentService.
    */

    public PaymentService(PaymentGateway paymentGateway) {

        this.paymentGateway = paymentGateway;

    }


    public void processPayment(double amount) {

        paymentGateway.pay(amount);

    }
}