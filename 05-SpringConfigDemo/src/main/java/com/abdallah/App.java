package com.abdallah;

import com.abdallah.config.AppConfig;
import com.abdallah.model.Product;
import com.abdallah.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
            هنا بنعمل Spring Container.

            AnnotationConfigApplicationContext
            هو ApplicationContext
            مخصص للـ Java configuration.
        */

        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        AppConfig.class
                );


        /*
            Spring قرأ AppConfig.

            وبعد كده عمل الـ Beans:

            PaymentGateway
                    ↓
            PaymentService
                    ↓
            OrderService
        */


        /*
            نطلب OrderService من Spring.

            مهم:

            إحنا مش بنعمل:

            new OrderService(...)

            Spring هو اللي أنشأ الـ object.
        */

        OrderService orderService =
                context.getBean(OrderService.class);


        /*
            Create Product
        */

        Product product =
                new Product(
                        1,
                        "Laptop",
                        1500
                );


        /*
            Place Order
        */

        orderService.placeOrder(product);


        /*
            Close Spring Container

            عشان نقفل الـ context
            ونحرر resources المستخدمة.
        */

        ((AnnotationConfigApplicationContext) context)
                .close();
    }
}
