package com.elcentr.service;

import com.elcentr.dao.ResidentialComplexDAO;
import com.elcentr.model.ResidentialComplex;

import java.util.logging.Logger;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ResidentialComplexService {

    private static final Logger LOG = Logger.getLogger(ResidentialComplexService.class.getName());

    public ResidentialComplex save(ResidentialComplex residentialComplex) {
        ResidentialComplexDAO residentialComplexDAO = new ResidentialComplexDAO();
        if (nonNull(residentialComplex.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return residentialComplexDAO.save(residentialComplex);
    }

    public ResidentialComplex update(ResidentialComplex residentialComplex) {
        ResidentialComplexDAO residentialComplexDAO = new ResidentialComplexDAO();
        if (isNull(residentialComplex.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return residentialComplexDAO.update(residentialComplex);
    }

    public ResidentialComplex read(ResidentialComplex residentialComplex) {
        ResidentialComplexDAO residentialComplexDAO = new ResidentialComplexDAO();
        if (isNull(residentialComplex)) {
            throw new RuntimeException("Search is failed!");
        }
        return residentialComplexDAO.findById(residentialComplex.getId());
    }

    public void delete(ResidentialComplex residentialComplex) {
        ResidentialComplexDAO residentialComplexDAO = new ResidentialComplexDAO();
        if (isNull(residentialComplex.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        residentialComplexDAO.delete(residentialComplex);
    }

}
