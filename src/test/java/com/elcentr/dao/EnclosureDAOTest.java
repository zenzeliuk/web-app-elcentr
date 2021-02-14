package com.elcentr.dao;

import com.elcentr.model.Enclosure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnclosureDAOTest {

    @Test
    void save() {
        Enclosure enclosure = Enclosure.builder()
                .name("test-name")
                .build();
        Enclosure savedEnclosure = new EnclosureDAO().save(enclosure);
        assertNotNull(savedEnclosure);
    }

    @Test
    void findById() {
        Enclosure enclosure = Enclosure.builder()
                .name("test-name")
                .build();
        EnclosureDAO enclosureDAO = new EnclosureDAO();
        Enclosure savedEnclosure = enclosureDAO.save(enclosure);
        assertNotNull(savedEnclosure.getId());

        Enclosure foundEnclosure = enclosureDAO.findById(savedEnclosure.getId());
        assertNotNull(foundEnclosure);
    }

    @Test
    void delete() {
        Enclosure enclosure = Enclosure.builder()
                .name("test-name")
                .build();
        EnclosureDAO enclosureDAO = new EnclosureDAO();
        Enclosure savedEnclosure = enclosureDAO.save(enclosure);
        assertNotNull(savedEnclosure.getId());

        enclosureDAO.delete(savedEnclosure);
        Enclosure afterDelete = enclosureDAO.findById(savedEnclosure.getId());
        assertNull(afterDelete);
    }

    @Test
    void update() {
        Enclosure enclosure = Enclosure.builder()
                .name("test-name")
                .build();
        EnclosureDAO enclosureDAO = new EnclosureDAO();
        Enclosure savedEnclosure = enclosureDAO.save(enclosure);
        assertNotNull(savedEnclosure.getId());
        String nameBeforeUpdate = savedEnclosure.getName();

        savedEnclosure.setName("new-test-name");
        enclosureDAO.update(savedEnclosure);
        String nameAfterUpdate = savedEnclosure.getName();

        assertFalse(nameBeforeUpdate.equals(nameAfterUpdate));
    }
}