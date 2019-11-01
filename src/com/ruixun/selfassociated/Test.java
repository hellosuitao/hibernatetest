package com.ruixun.selfassociated;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

    @org.junit.Test
    public void test(){
        Configuration configure = new Configuration().configure("com/ruixun/resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Category foodCategory = new Category(null,"food");/*食品*/
        Category fruitCategory = new Category(null,"fruit");/*水果*/
        Category vegetableCategory = new Category(null,"vegetable");/*蔬菜*/
        Category appleCategory = new Category(null,"apple");/*苹果*/
        Category orangeCategory = new Category(null,"orange");/*橘子*/
        Category tomatoCategory = new Category(null,"tomato");/*番茄*/

        foodCategory.getChilds().add(fruitCategory);
        foodCategory.getChilds().add(vegetableCategory);

        fruitCategory.getChilds().add(appleCategory);
        fruitCategory.getChilds().add(orangeCategory);
        fruitCategory.setParent(foodCategory);

        vegetableCategory.getChilds().add(tomatoCategory);
        vegetableCategory.setParent(foodCategory);

        appleCategory.setParent(fruitCategory);
        orangeCategory.setParent(fruitCategory);
        tomatoCategory.setParent(vegetableCategory);

        session.save(foodCategory);

        transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
