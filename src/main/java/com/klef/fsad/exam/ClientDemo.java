package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        // INSERT
        session.beginTransaction();

        Product p = new Product();
        p.setName("Laptop");
        p.setDescription("Dell");
        p.setStatus("Available");
        p.setDate(new Date());

        session.save(p);

        session.getTransaction().commit();
        System.out.println("Inserted Successfully");

        // UPDATE
        session.beginTransaction();

        Product p1 = session.get(Product.class, 1);
        p1.setStatus("Sold");

        session.update(p1);

        session.getTransaction().commit();
        System.out.println("Updated Successfully");

        // DELETE (optional if needed)
        session.beginTransaction();

        Product p2 = session.get(Product.class, 1);
        session.delete(p2);

        session.getTransaction().commit();
        System.out.println("Deleted Successfully");

        session.close();
        sf.close();
    }
}