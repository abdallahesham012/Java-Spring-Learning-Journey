package com.abdallah.repository;

public class EmployeeRepository {


    /*
        Method بسيطة تمثل Database operation.

        في مشروع حقيقي ممكن تكون هنا:

        save()
        findById()
        findAll()
        delete()

        وتتصل بقاعدة البيانات.
    */
    public void save(String employeeName) {

        System.out.println(
                "Saving employee: " + employeeName
        );
    }
}