package com.abdallah;


import com.abdallah.entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.abdallah.util.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {

 //       insertStudent();

 //      getStudentById(1L);
//
       getAllStudents();
//
//        updateStudent(1L);
//
//        deleteStudent(2L);
//
//        searchUsingHQL();
//
//        pagination();
//
//        criteriaQueryExample();
    }

    /*
     ========================================
                INSERT
     ========================================
     */
    static void insertStudent() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        Student student = new Student(
                "Nada",
                23,
                "nody@gmail.com"
        );

        session.persist(student);

        transaction.commit();

        session.close();

        System.out.println("Student Inserted Successfully");
    }

    /*
     ========================================
             SELECT BY ID
     ========================================
     */
    static void getStudentById(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Student student = session.get(Student.class, id);

        System.out.println(student);

        session.close();
    }

    /*
     ========================================
               SELECT ALL
     ========================================
     */
    static void getAllStudents() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Student> students = session
                .createQuery("FROM Student", Student.class)
                .list();

        students.forEach(System.out::println);

        session.close();
    }

    /*
     ========================================
                 UPDATE
     ========================================
     */
    static void updateStudent(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, id);

        if (student != null) {

            student.setAge(30);

            student.setEmail("updated@gmail.com");

            transaction.commit();

            System.out.println("Updated Successfully");

        } else {

            transaction.rollback();

            System.out.println("Student Not Found");
        }

        session.close();
    }

    /*
     ========================================
                  DELETE
     ========================================
     */
    static void deleteStudent(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, id);

        if (student != null) {

            session.remove(student);

            transaction.commit();

            System.out.println("Deleted Successfully");

        } else {

            transaction.rollback();

            System.out.println("Student Not Found");
        }

        session.close();
    }

    /*
     ========================================
                  HQL
     ========================================
     */
    static void searchUsingHQL() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Student> students = session
                .createQuery(
                        "FROM Student WHERE age > :age",
                        Student.class
                )
                .setParameter("age", 20)
                .list();

        students.forEach(System.out::println);

        session.close();
    }

    /*
     ========================================
               Pagination
     ========================================
     */
    static void pagination() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Student> students = session
                .createQuery("FROM Student", Student.class)
                .setFirstResult(0)
                .setMaxResults(5)
                .list();

        students.forEach(System.out::println);

        session.close();
    }

    /*
     ========================================
              Criteria API
     ========================================
     */
    static void criteriaQueryExample() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<Student> cq =
                cb.createQuery(Student.class);

        Root<Student> root = cq.from(Student.class);

        cq.select(root)
                .where(cb.greaterThan(root.get("age"), 20));

        List<Student> students =
                session.createQuery(cq).list();

        students.forEach(System.out::println);

        session.close();
    }
}