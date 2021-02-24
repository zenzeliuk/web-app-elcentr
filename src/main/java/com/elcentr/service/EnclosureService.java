package com.elcentr.service;

import com.elcentr.dao.EnclosureDAO;
import com.elcentr.model.Enclosure;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class EnclosureService {

    private static final Logger LOG = Logger.getLogger(EnclosureService.class.getName());

    public Enclosure save(Enclosure enclosure) {
        EnclosureDAO enclosureDAO = new EnclosureDAO();
        if (nonNull(enclosure.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return enclosureDAO.save(enclosure);
    }

    public Enclosure update(Enclosure enclosure) {
        EnclosureDAO enclosureDAO = new EnclosureDAO();
        if (isNull(enclosure.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return enclosureDAO.update(enclosure);
    }

    public Enclosure read(Enclosure enclosure) {
        EnclosureDAO enclosureDAO = new EnclosureDAO();
        if (isNull(enclosure)) {
            throw new RuntimeException("Search is failed!");
        }
        return enclosureDAO.findById(enclosure.getId());
    }

    public void delete(Enclosure enclosure) {
        EnclosureDAO enclosureDAO = new EnclosureDAO();
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
