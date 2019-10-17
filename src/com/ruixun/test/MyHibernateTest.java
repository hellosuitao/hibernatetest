package com.ruixun.test;

import com.ruixun.bean.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

public class MyHibernateTest {
    @Test
    public void myAdd(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        /*在实际开发中，往往使用getCurrentSession多，因为一般是处理同一个事务（即是使用一个数据库的情况）
         * 使用SessionFactory.getCurrentSession()需要在hibernate.cfg.xml中如下配置
         * 如果采用jdbc独立引用程序配置如下：
         * <property name="hibernate.current_session_context_class">thread</property>
         * 如果采用了JTA事务配置如下
         * <property name="hibernate.current_session_context_class">jta</property>
         * */
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        /*hql*/
        /*session.save(new User(null,"张三","印度"));*/
        /*sql*/
        /*String sql = "insert User(name,address) values('李四','四川')";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.executeUpdate();*/
        /*criteria*/
        /*没有insert方法*/
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void myDelete(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        /*sql*/
        /*String sql = "delete from user where id = 6";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        //返回影响胡行数
        int i = sqlQuery.executeUpdate();
        System.out.println(i);*/
        /*hql*/
        /*session.delete(new User(6,null,null));*/
        /*criteria 没有删除方法*/
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void myUpdate(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        /*sql*/
        /*String sql = "update user set name = '王五' where id = 1";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.executeUpdate();*/
        /*hql*/
        /*session.update(new User(1,"老大","北京"));*/
        /*criteria  没有修改*/
        /*User user = session.get(User.class, 1);
        System.out.println(user);
        user.setAddress("上海");*//*这样可以直接更新数据库*/
        transaction.commit();
//        System.out.println(user);
        session.close();
        sessionFactory.close();
    }

    @Test
    public void mySelect(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        /*sql*/
        /*String sql = "select * from user where id = 1";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        List list = sqlQuery.list();
        System.out.println(list);*/
        /*String sql = "select * from user";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(User.class);//可以toString()
        List<User> list = sqlQuery.list();
        System.out.println(list);*/
        /*String sql = "select * from user";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
//        sqlQuery.addEntity(User.class);
        List list = sqlQuery.list();
        System.out.println(list);//不可以toString()*/
        /*hql*/
        /*String sql = "from User where id = ?";
        Query query = session.createQuery(sql);
        query.setParameter(0,1);
        User user = (User) query.uniqueResult();
        System.out.println(user);*/
        /*String sql = "from User";
        Query query = session.createQuery(sql);
        List list = query.list();
        System.out.println(list);*/

        /*criteria*/
        Criteria criteria = session.createCriteria(User.class);
        /*criteria.add(Restrictions.like("name","张%"));
        User user = (User) criteria.uniqueResult();
        System.out.println(user);*/
        /*criteria.add(Restrictions.like("name","老%"));
        List<User> list = criteria.list();
        System.out.println(list);*/
        criteria.add(Restrictions.like("name","老%"));
        criteria.add(Restrictions.eq("id",1));
        User user = (User) criteria.uniqueResult();
        System.out.println(user);

        session.close();
        sessionFactory.close();
    }
}
