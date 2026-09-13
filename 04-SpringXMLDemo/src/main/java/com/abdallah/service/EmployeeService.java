package com.abdallah.service;

import com.abdallah.repository.EmployeeRepository;

public class EmployeeService {

    /*
        دي Dependency.

        EmployeeService محتاج
        EmployeeRepository عشان يشتغل.

        بدل ما نعمل:

        private EmployeeRepository repository =
                new EmployeeRepository();

        هنخلي Spring هو اللي يحقنها.
    */
    private EmployeeRepository employeeRepository;


    /*
        Constructor

        Spring هيستخدم الـ constructor ده
        لو عملنا Constructor Injection.

        لكن في المثال الأساسي هنستخدم Setter Injection
        عشان نشرح الطريقتين.
    */
    public EmployeeService() {

    }


    /*
        Setter Injection

        Spring هيستدعي الـ setter ده
        ويحقن EmployeeRepository.

        XML:

        <property
            name="employeeRepository"
            ref="employeeRepository"/>
    */
    public void setEmployeeRepository(
            EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }


    public void addEmployee(String name) {

        System.out.println(
                "EmployeeService: Adding employee..."
        );

        employeeRepository.save(name);
    }
}