package com.elcentr.factory.impl;

import com.elcentr.factory.HibernateSessionFactory;
import com.elcentr.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import static java.util.Objects.isNull;

public class PostgresSessionFactory implements HibernateSessionFactory {

    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getHibernateSessionFactory() {
        if (isNull(sessionFactory)) {
            Configuration configuration = new Configuration();

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            configuration.addAnnotatedClass(Component.class);
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(Enclosure.class);
            configuration.addAnnotatedClass(Order.class);
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(ResidentialComplex.class);

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }
        return sessionFactory;
    }
}
