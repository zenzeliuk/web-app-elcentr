package com.elcentr.service;

import com.elcentr.dao.ComponentDAO;
import com.elcentr.dao.ProductDAO;
import com.elcentr.model.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ComponentService {

    private static final Logger LOG = Logger.getLogger(ComponentService.class.getName());

    public Component save(Component component) {
        ComponentDAO componentDAO = new ComponentDAO();
        if (nonNull(component.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return componentDAO.save(component);
    }

    public Component update(Component component) {
        ComponentDAO componentDAO = new ComponentDAO();
        if (isNull(component.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return componentDAO.update(component);
    }

    public Component read(Component component) {
        ComponentDAO componentDAO = new ComponentDAO();
        if (isNull(component)) {
            throw new RuntimeException("Search is failed!");
        }
        return componentDAO.findById(component.getId());
    }

    public void delete(Component component) {
        ComponentDAO componentDAO = new ComponentDAO();
        if (isNull(component.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        componentDAO.delete(component);
    }


    public List<Component> findAllByIdProduct(Integer id) {
        ComponentDAO componentDAO = new ComponentDAO();
        try {
            return componentDAO.findAllByIdProduct(id);
        } catch (Exception e) {
            LOG.severe(String.format("Any component with code %d was not found", id));
        }
        return new ArrayList<>();
    }
}
