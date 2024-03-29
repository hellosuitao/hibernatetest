package com.ruixun.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        sessionFactory = configure.buildSessionFactory();
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }

    public static Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public static void closeSessionFactory(){
        sessionFactory.close();;
    }
}
