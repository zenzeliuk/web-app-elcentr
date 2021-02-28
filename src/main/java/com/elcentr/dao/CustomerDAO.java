package com.elcentr.dao;

import com.elcentr.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class CustomerDAO extends BaseDAO<Customer> {

    public List<Customer> findAll() {
        SessionFactory sessionFactory = super.getPostgresSessionFactory().getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        String sql = "" +
                "SELECT * " +
                "FROM customers";
        Query query = session.createNativeQuery(sql, Customer.class);
        List<Customer> result = query.getResultList();
        session.close();
        return result;
    }
}
