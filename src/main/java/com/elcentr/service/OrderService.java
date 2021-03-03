package com.elcentr.service;

import com.elcentr.controller.dto.ProductOrderDTO;
import com.elcentr.controller.mapper.ProductOrderMapper;
import com.elcentr.dao.OrderDAO;
import com.elcentr.model.Order;
import com.elcentr.model.Product;

import java.util.Optional;
import java.util.logging.Logger;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class OrderService {

    private static final Logger LOG = Logger.getLogger(OrderService.class.getName());

    public Order save(Order order) {
        OrderDAO orderDAO = new OrderDAO();
        if (nonNull(order.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return orderDAO.save(order);
    }

    public Order update(Order order) {
        OrderDAO orderDAO = new OrderDAO();
        if (isNull(order.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return orderDAO.update(order);
    }

    public Order read(Order order) {
        OrderDAO orderDAO = new OrderDAO();
        if (isNull(order)) {
            throw new RuntimeException("Search is failed!");
        }
        return orderDAO.findById(order.getId());
    }

    public void delete(Order order) {
        OrderDAO orderDAO = new OrderDAO();
        if (isNull(order.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        orderDAO.delete(order);
    }

    public Order findByProductOrCreateNew(Product product) {
        OrderDAO orderDAO = new OrderDAO();
        try {
            Optional<Order> optionalOrder = Optional.ofNullable(orderDAO.findByProduct(product));
            if (optionalOrder.isPresent())
                return optionalOrder.get();

        } catch (Exception e) {
            LOG.severe(String.format("Order with id product %d was not found", product.getId()));
        }
        return save(Order.builder().product(product).build());
    }
}
