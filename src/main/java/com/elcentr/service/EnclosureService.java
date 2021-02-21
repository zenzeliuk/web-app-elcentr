package com.elcentr.service;

import com.elcentr.dao.EnclosureDAO;
import com.elcentr.dao.ProductDAO;
import com.elcentr.model.Enclosure;
import com.elcentr.model.Product;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class EnclosureService {

    private static final Logger LOG = Logger.getLogger(EnclosureService.class.getName());
    private final EnclosureDAO enclosureDAO;

    public Enclosure save(Enclosure enclosure) {
        if (nonNull(enclosure.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return enclosureDAO.save(enclosure);
    }

    public Enclosure update(Enclosure enclosure) {
        if (isNull(enclosure.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return enclosureDAO.update(enclosure);
    }

    public Enclosure read(Enclosure enclosure) {
        if (isNull(enclosure)) {
            throw new RuntimeException("Search is failed!");
        }
        return enclosureDAO.findById(enclosure.getId());
    }

    public void delete(Enclosure enclosure) {
        if (isNull(enclosure.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        enclosureDAO.delete(enclosure);
    }


    public List<Enclosure> findAll() {
        try {
            EnclosureDAO enclosureDAO = new EnclosureDAO();
            return enclosureDAO.findAll();
        } catch (Exception e) {
            LOG.severe("Any enclosure was not found");
        }
        return new ArrayList<>();
    }
}
