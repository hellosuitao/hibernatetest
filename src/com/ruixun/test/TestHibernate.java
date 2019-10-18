package com.ruixun.test;

import com.ruixun.bean.Department;
import com.ruixun.bean.Employee;
import com.ruixun.bean.User;
import com.ruixun.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void test4(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User(null, "11", "11");
        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        user.setHobbies(set);
        List<String> list = Arrays.asList("sdf", "123", "yiu");
        user.setWorks(list);
        Map<String,String> map = new HashMap<>();
        map.put("1","上海1");
        map.put("2","上海2");
        map.put("3","上海3");
        user.setCity(map);
        session.save(user);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testOneTwoMany(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        /*Employee employee1 = new Employee(null, "111");
        Employee employee2 = new Employee(null, "222");
        Employee employee3 = new Employee(null, "333");
        Set<Employee> set = new HashSet<>();
        set.add(employee1);
        set.add(employee2);
        set.add(employee3);
        Department department = new Department(null,"ddddd");
        department.setEmployees(set);

        session.save(department);*/

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testManyToOne(){
        /*Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Department department = new Department(null, "111");
        Employee aaa = new Employee(null, "aaa");
        Employee bbb = new Employee(null, "bbb");
        aaa.setDepartment(department);
        bbb.setDepartment(department);

        session.save(aaa);
        session.save(bbb);

        transaction.commit();
        session.close();
        sessionFactory.close();*/
    }

    @Test
    public void manyToMany(){
        /*Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Department department1 = new Department(null,"aaa");
        Department department2 = new Department(null,"bbb");
        Set<Department> set = new HashSet<>();
        set.add(department1);
        set.add(department2);
        Employee zs = new Employee(null, "zs");
        Employee ls = new Employee(null, "ls");
        zs.setDepartments(set);
        ls.setDepartments(set);
        session.save(zs);
        session.save(ls);

        transaction.commit();
        session.close();
        sessionFactory.close();*/
    }

    @Test
    public void testOneToOne(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee zs = new Employee(null, "zs", null);
        Department aaa = new Department(null, "aaa", zs);
        session.save(aaa);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
