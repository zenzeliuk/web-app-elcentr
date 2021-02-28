package com.elcentr.dao;

import com.elcentr.model.ResidentialComplex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class ResidentialComplexDAO extends BaseDAO<ResidentialComplex> {

    public List<ResidentialComplex> findAll() {
        SessionFactory sessionFactory = super.getPostgresSessionFactory().getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        String sql = "" +
                "SELECT * " +
                "FROM residential_complexes";
        Query query = session.createNativeQuery(sql, ResidentialComplex.class);
        List<ResidentialComplex> result = query.getResultList();
        session.close();
        return result;
    }
}
