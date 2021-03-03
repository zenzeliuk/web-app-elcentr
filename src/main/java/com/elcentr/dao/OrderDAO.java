package com.elcentr.dao;

import com.elcentr.model.Order;
import com.elcentr.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;

import static java.util.Objects.isNull;

public class OrderDAO extends BaseDAO<Order> {

    public Order findByProduct(Product product) {
        if (isNull(product)) {
            throw new RuntimeException("findByIdProduct is failed!");
        }
        Integer id = product.getId();
        SessionFactory sessionFactory = super.getPostgresSessionFactory().getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createNativeQuery("" +
                "SELECT o.* " +
                "FROM orders o " +
                "JOIN products p ON p.id=o.product_id  " +
                "WHERE product_id=?1 ", Order.class);
        query.setParameter(1, id);
        Order result = (Order) query.getSingleResult();
        transaction.commit();
        session.close();
        return result;
    }
}
