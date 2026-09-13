package com.abdallah.config;

import com.abdallah.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {


    /*
        Bean رقم 1

        Spring هيسجل الـ object
        باسم stripeGateway.
    */

    @Bean("stripeGateway")
    public PaymentGateway stripePaymentGateway() {

        return new StripePaymentGateway();
    }


    /*
        Bean رقم 2

        Spring هيسجل الـ object
        باسم paypalGateway.
    */

    @Bean("paypalGateway")
    @Primary
    public PaymentGateway paypalPaymentGateway() {

        return new PaypalPaymentGateway();
    }


    /*
        هنا عندنا أكثر من PaymentGateway.

        لذلك استخدمنا @Qualifier
        عشان نحدد بالضبط أنهي Bean نستخدم.
    */

    @Bean
    public PaymentService paymentService(

            @Qualifier("stripeGateway")
            PaymentGateway paymentGateway) {

        return new PaymentService(paymentGateway);
    }


    /*
        OrderService يعتمد على PaymentService.
    */

    @Bean
    public OrderService orderService(
            PaymentService paymentService) {

        return new OrderService(paymentService);
    }
}