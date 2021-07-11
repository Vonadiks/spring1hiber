package com.flamexander.hibernate.h2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
    private static SessionFactory  sessionFactory;

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            ProductDao productDao = new ProductDao(factory);
            Product oldProduct1 = productDao.findById(1L);
            System.out.println(oldProduct1);
            System.out.println(oldProduct1.getTitle());
            List<Product> productList = productDao.findAll();
            System.out.println(productList + "\n");
            productDao.deleteById(2L);
            List<Product> productList2 = productDao.findAll();
            System.out.println(productList2 + "\n");
            productDao.saveOrUpdate(oldProduct1);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }
}
