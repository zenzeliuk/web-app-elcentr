package com.elcentr.service;

import com.elcentr.dao.ComponentDAO;
import com.elcentr.model.Component;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class ComponentService {

    private final ComponentDAO componentDAO;

    public Component save(Component component) {
        if (nonNull(component.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return componentDAO.save(component);
    }

    public Component update(Component component) {
        if (isNull(component.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return componentDAO.update(component);
    }

    public Component read(Component component) {
        if (isNull(component)) {
            throw new RuntimeException("Search is failed!");
        }
        return componentDAO.findById(component.getId());
    }

    public void delete(Component component) {
        if (isNull(component.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        componentDAO.delete(component);
    }

}
