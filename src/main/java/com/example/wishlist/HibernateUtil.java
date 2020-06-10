package com.example.wishlist;

import com.example.wishlist.model.ShoppingWishList;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() { //fct singletone
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();

                //configuratii care ma leaga de BD
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/wish");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "postgres");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                //settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                //se steaza configuratiile
                configuration.setProperties(settings);

                //se incarca ob in Hibernate
                configuration.addAnnotatedClass(ShoppingWishList.class);

                //configurare si creeare sessionFactory
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
