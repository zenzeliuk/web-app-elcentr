package com.elcentr.dao;

import com.elcentr.model.Component;
import com.elcentr.model.Enclosure;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

import static java.util.Objects.isNull;

public class ComponentDAO extends BaseDAO<Component> {

    public List<Component> findAllProductWhereEnclosureIs(Enclosure enclosure) {
        List<Component> result;

        if (isNull(enclosure.getId())) {
            throw new RuntimeException("Search is failed!");
        }
        SessionFactory sessionFactory = postgresSessionFactory.getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createNativeQuery("" +
                "SELECT c.* " +
                "FROM components c " +
                "JOIN products p ON p.id=c.product_id  " +
                "WHERE enclosure_id=?1 ", Component.class);
        query.setParameter(1, enclosure.getId());
        result = query.getResultList();
        transaction.commit();
        session.close();
        return result;
    }
}
