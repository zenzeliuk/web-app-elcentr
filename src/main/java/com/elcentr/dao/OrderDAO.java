package com.elcentr.dao;

import com.elcentr.model.Component;
import com.elcentr.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

import static java.util.Objects.isNull;

public class OrderDAO extends BaseDAO<Order> {

    public List<Order> findByIdProduct(Integer id) {
        List<Order> result;
        if (isNull(id)) {
            throw new RuntimeException("findByIdProduct is failed!");
        }
        SessionFactory sessionFactory = super.getPostgresSessionFactory().getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createNativeQuery("" +
                "SELECT o.* " +
                "FROM orders o " +
                "JOIN products p ON p.id=o.product_id  " +
                "WHERE product_id=?1 ", Order.class);
        query.setParameter(1, id);
        result = query.getResultList();
        transaction.commit();
        session.close();
        return result;
    }
}
