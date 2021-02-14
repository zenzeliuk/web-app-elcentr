package com.elcentr.service;

import com.elcentr.dao.ResidentialComplexDAO;
import com.elcentr.model.ResidentialComplex;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class ResidentialComplexService {

    private final ResidentialComplexDAO residentialComplexDAO;

    public ResidentialComplex save(ResidentialComplex residentialComplex) {
        if (nonNull(residentialComplex.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return residentialComplexDAO.save(residentialComplex);
    }

    public ResidentialComplex update(ResidentialComplex residentialComplex) {
        if (isNull(residentialComplex.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return residentialComplexDAO.update(residentialComplex);
    }

    public ResidentialComplex read(ResidentialComplex residentialComplex) {
        if (isNull(residentialComplex)) {
            throw new RuntimeException("Search is failed!");
        }
        return residentialComplexDAO.findById(residentialComplex.getId());
    }

    public void delete(ResidentialComplex residentialComplex) {
        if (isNull(residentialComplex.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        residentialComplexDAO.delete(residentialComplex);
    }

}
