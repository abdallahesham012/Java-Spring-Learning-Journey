package com.abdallah.service;


import com.abdallah.model.Product;

public class OrderService {

    private final PaymentService paymentService;


    /*
        OrderService يعتمد على PaymentService.

        Spring هيعمل injection
        للـ PaymentService هنا.
    */

    public OrderService(PaymentService paymentService) {

        this.paymentService = paymentService;

    }


    public void placeOrder(Product product) {

        System.out.println(
                "Placing order for: "
                        + product.getName()
        );


        System.out.println(
                "Product price: $"
                        + product.getPrice()
        );


        // Process payment

        paymentService.processPayment(
                product.getPrice()
        );


        System.out.println(
                "Order placed successfully!"
        );
    }
}