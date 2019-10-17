package com.ruixun.test;

import com.ruixun.bean.User;
import com.ruixun.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

public class TestHibernate {
/*hql*/
    @Test
    public void add() {
//        String path = TestHibernate.class.getClassLoader().getResource("com/ruixun/resources/hibernate.cfg.xml").getFile();
        /*System.out.println(path);/D:/IDEA/workspace/hibernate/out/production/hibernate/com/ruixun/resources/hibernate.cfg.xml*/
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(new User(null, "老二", "上海"));
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void delete(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(new User(3,null,null));
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void update(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(new User(1,"老大大","上海"));
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void find(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, 1);
        user.setAddress("北京");/*这样可以直接更新数据库*/
        transaction.commit();
        System.out.println(user);
        session.close();
        sessionFactory.close();
    }

/*sql*/
    @Test
    public void add1(){
        Session session = HibernateUtil.getSession();
        String addSql = "insert into User(name,address) values('张三','成都')";
        SQLQuery sqlQuery = session.createSQLQuery(addSql);
        Transaction transaction = session.beginTransaction();
        sqlQuery.executeUpdate();
        transaction.commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
    @Test
    public void get1(){
        Session session = HibernateUtil.getSession();
        String sql = "select * from User";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(User.class);
        List<User> list = sqlQuery.list();
        System.out.println(list);
        session.close();
        HibernateUtil.closeSessionFactory();
    }

/*hql*/
    @Test
    public void get2(){
        Session session = HibernateUtil.getSession();
        String hql = "from User where id = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,5);
        User user = (User) query.uniqueResult();
        System.out.println(user);
        session.close();
        HibernateUtil.closeSessionFactory();
    }

/*criteria*/
    @Test
    public void test3(){
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(User.class);
        /*criteria.add(Restrictions.like("name","张%"));
        User user = (User) criteria.uniqueResult();*/
        criteria.add(Restrictions.like("name","老%"));
        criteria.add(Restrictions.eq("id",1));
//        List<User> list = criteria.list();
//        System.out.println(list);
        User user = (User) criteria.uniqueResult();
        System.out.println(user);
        session.close();
        HibernateUtil.closeSessionFactory();

    }

}
