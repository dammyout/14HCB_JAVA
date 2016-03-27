/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Songkute
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory.isClosed()){
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        try {
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
