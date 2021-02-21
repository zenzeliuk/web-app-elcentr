package com.elcentr.dao;

import com.elcentr.model.Enclosure;
import com.elcentr.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class EnclosureDAO extends BaseDAO<Enclosure> {

    public List<Enclosure> findAll() {
        SessionFactory sessionFactory = super.getPostgresSessionFactory().getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        String sql = "" +
                "SELECT * " +
                "FROM enclosures";
        Query query = session.createNativeQuery(sql, Product.class);
        List<Enclosure> result = query.getResultList();
        session.close();
        return result;
    }

}
