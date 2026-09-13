package com.abdallah.model;

public class Employee {

    private int id;

    private String name;

    private double salary;

    private Address address;


    /*
        Constructor Injection

        Spring هيستخدم الـ constructor ده
        أثناء إنشاء الـ Bean.

        يعني بدل ما نعمل:

        Employee employee = new Employee();

        Spring هيعمل تقريبًا:

        Employee employee =
                new Employee(id, name, salary, address);
    */
    public Employee(
            int id,
            String name,
            double salary,
            Address address) {

        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public double getSalary() {
        return salary;
    }


    public Address getAddress() {
        return address;
    }


    @Override
    public String toString() {

        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }
}