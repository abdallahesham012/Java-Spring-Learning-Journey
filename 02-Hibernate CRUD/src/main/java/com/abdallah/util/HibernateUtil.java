package com.abdallah.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    // Singleton SessionFactory
    private static final SessionFactory sessionFactory =
            new Configuration()
                    .configure()
                    .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}