package com.abdalla.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        /*
         * هنا Spring Boot بيبدأ التطبيق.
         *
         * Spring بيعمل ApplicationContext
         *
         * والـ ApplicationContext هو الـ IoC Container
         * المسؤول عن إنشاء وإدارة الـ Beans.
         */
        ApplicationContext context =
                SpringApplication.run(DemoApplication.class, args);


        /*
         * هنا بنطلب Student Bean من Spring.
         *
         * Spring مش بيعمل Student جديد كل مرة.
         *
         * لأن الـ default scope للـ Bean هو Singleton.
         */
        Student student1 = context.getBean(Student.class);

        /*
         * بنطلب Student مرة تانية.
         *
         * هل Spring هيعمل Object جديد؟
         *
         * لا.
         *
         * هيجيب نفس الـ Bean الموجودة بالفعل.
         */
        Student student2 = context.getBean(Student.class);


        /*
         * بنختبر هل الاتنين نفس الـ Object.
         */
        System.out.println(student1 == student2);


        /*
         * المتوقع:
         *
         * true
         *
         * لأن Student Bean لها Singleton scope
         * بشكل افتراضي.
         */


        /*
         * دلوقتي ناخد StudentService من Spring.
         */
        StudentService service =
                context.getBean(StudentService.class);


        /*
         * StudentService جواه:
         *
         * @Autowired
         * private Student student;
         *
         * Spring قام بحقن Student داخل StudentService
         * تلقائيًا.
         */
        service.startStudying();
	}

}
