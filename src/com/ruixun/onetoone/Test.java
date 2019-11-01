package com.ruixun.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

    /*单向主键person（card）*/
    @org.junit.Test
    public void test1(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        Card card = new Card(null, 1234);
        Person zs = new Person(null, "zs");
        zs.setCard(card);
        session.save(zs);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    /*双向主键关联*/
    @org.junit.Test
    public void test2(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        /*Card card = new Card(null, 1234);
        Person zs = new Person(null, "zs");
        card.setPerson(zs);
        session.save(card);*/  /*card插入成功，person插入失败*/   /*缺点：card，才能有person*/

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    /*单向外键关联*/
    @org.junit.Test
    public void test3(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        Card card = new Card(null, 1111);
        Person zs = new Person(null, "zs");
        zs.setCard(card);
        session.save(zs);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    /*双向外键关联*/
    @org.junit.Test
    public void test4(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();


        Card card = new Card(null, 1111);
        Person zs = new Person(null, "zs");
        zs.setCard(card);
        session.save(zs);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
