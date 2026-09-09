package com.abdalla.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    /*
     * StudentService محتاج Student.
     *
     * دي اسمها Dependency.
     *
     * بدل ما نعمل:
     *
     * Student student = new Student();
     *
     * هنخلي Spring هو اللي يجيب الـ Student.
     */
    @Autowired
    private Student student;


    public void startStudying() {

        // هنا بنستخدم الـ Student اللي Spring حقنه لنا
        student.study();
    }
}