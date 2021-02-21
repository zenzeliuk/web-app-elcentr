package com.elcentr.dao;

import com.elcentr.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class ProductDAO extends BaseDAO<Product> {

    public List<Product> findAll() {
        SessionFactory sessionFactory = super.getPostgresSessionFactory().getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        String sql = "" +
                "SELECT * " +
                "FROM products";
        Query query = session.createNativeQuery(sql, Product.class);
        List<Product> result = query.getResultList();
        session.close();
        return result;
    }

    public List<Product> findAllByCode(String code) {
        SessionFactory sessionFactory = super.getPostgresSessionFactory().getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        String sql = "" +
                "SELECT * " +
                "FROM products " +
                "WHERE code=?1";
        Query query = session.createNativeQuery(sql, Product.class);
        query.setParameter(1, code);
        List<Product> result = query.getResultList();
        session.close();
        return result;
    }

}
