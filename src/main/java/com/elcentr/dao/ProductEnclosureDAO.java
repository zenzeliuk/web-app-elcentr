package com.elcentr.dao;

import com.elcentr.model.ProductEnclosure;
import com.elcentr.model.Enclosure;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

import static java.util.Objects.isNull;

public class ProductEnclosureDAO extends BaseDAO<ProductEnclosure> {

    public List<ProductEnclosure> findAllProductWhereEnclosureIs(Enclosure enclosure) {
        List<ProductEnclosure> result;
        if (isNull(enclosure.getId())) {
            throw new RuntimeException("Search is failed!");
        }
        SessionFactory sessionFactory = super.getPostgresSessionFactory().getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createNativeQuery("" +
                "SELECT c.* " +
                "FROM product_enclosures c " +
                "JOIN products p ON p.id=c.product_id  " +
                "WHERE enclosure_id=?1 ", ProductEnclosure.class);
        query.setParameter(1, enclosure.getId());
        result = query.getResultList();
        transaction.commit();
        session.close();
        return result;
    }

    public List<ProductEnclosure> findAllByIdProduct(Integer id) {
        List<ProductEnclosure> result;
        if (isNull(id)) {
            throw new RuntimeException("findAllByIdProduct is failed!");
        }
        SessionFactory sessionFactory = super.getPostgresSessionFactory().getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createNativeQuery("" +
                "SELECT c.* " +
                "FROM product_enclosures c " +
                "JOIN products p ON p.id=c.product_id  " +
                "WHERE product_id=?1 ", ProductEnclosure.class);
        query.setParameter(1, id);
        result = query.getResultList();
        transaction.commit();
        session.close();
        return result;
    }
}
