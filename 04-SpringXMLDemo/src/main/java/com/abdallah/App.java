package com.abdallah;

import com.abdallah.model.Employee;
import com.abdallah.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {


        /*
            ====================================================
                        STEP 1
            ====================================================

            إنشاء Spring Container

            ApplicationContext هو الـ Container
            اللي Spring من خلاله بيدير الـ Beans.

            إحنا هنا بنقوله:

            اقرأ applicationContext.xml

        */

        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "applicationContext.xml"
                );


        /*
            ====================================================
                        STEP 2
            ====================================================

            Get Bean

            بدل ما نعمل:

            Employee employee =
                    new Employee(...);

            Spring هو اللي عمل الـ Object.

            وإحنا بنطلبه منه باستخدام الـ id.

        */

        Employee employee =
                context.getBean(
                        "employee",
                        Employee.class
                );


        /*
            اطبع الـ Employee
        */

        System.out.println(employee);



        /*
            ====================================================
                        STEP 3
            ====================================================

            Get EmployeeService

            Spring هيكون بالفعل عمل:

            EmployeeService

            وحقن جواه:

            EmployeeRepository

            عن طريق Setter Injection.
        */

        EmployeeService service =
                context.getBean(
                        "employeeService",
                        EmployeeService.class
                );


        /*
            استخدام الـ Service
        */

        service.addEmployee("Mohamed");



        /*
            ====================================================
                        STEP 4
            ====================================================

            إغلاق الـ Context

            مهم خصوصًا لو عندنا Resources
            محتاجة cleanup.

            زي:

            Database connections
            Threads
            Files
            وغيرها.

        */

        ((ClassPathXmlApplicationContext) context).close();

    }
}