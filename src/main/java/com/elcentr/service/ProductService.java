package com.elcentr.service;

import com.elcentr.dao.ProductDAO;
import com.elcentr.model.Product;

import java.util.*;
import java.util.logging.Logger;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ProductService {

    private static final Logger LOG = Logger.getLogger(ProductService.class.getName());

    public Optional<Product> save(Product product) {
        ProductDAO productDAO = new ProductDAO();
        if (nonNull(product.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        if (findAllByCode(product.getCode()).isEmpty()) {
            return Optional.of(productDAO.save(product));
        }
        return Optional.empty();
    }

    public Product update(Product product) {
        ProductDAO productDAO = new ProductDAO();
        if (isNull(product.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return productDAO.update(product);
    }

    public Product read(Product product) {
        ProductDAO productDAO = new ProductDAO();
        if (isNull(product)) {
            throw new RuntimeException("Search is failed!");
        }
        return productDAO.findById(product.getId());
    }

    public void delete(Product product) {
        ProductDAO productDAO = new ProductDAO();
        if (isNull(product.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        productDAO.delete(product);
    }

    public List<Product> findAll() {
        try {
            ProductDAO productDAO = new ProductDAO();
            return productDAO.findAll();
        } catch (Exception e) {
            LOG.severe("Any product was not found");
        }
        return new ArrayList<>();
    }

    public List<Product> findAllByCode(String code) {
        ProductDAO productDAO = new ProductDAO();
        try {
            return productDAO.findAllByCode(code);
        } catch (Exception e) {
            LOG.severe(String.format("Any product with code %s was not found", code));
        }
        return new ArrayList<>();
    }

    public Optional<Product> findById(Integer id) {
        ProductDAO productDAO = new ProductDAO();
        try {
            return Optional.of(productDAO.findById(id));
        } catch (Exception e) {
            LOG.severe(String.format("Product with id %d was not found", id));
        }
        return Optional.empty();
    }

    public String createCodeProduct() {
        ProductService productService = new ProductService();
        List<Product> products = productService.findAll();
        List<String> codesProduct = new ArrayList<>();
        for (Product product : products) {
            codesProduct.add(product.getCode());
        }

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Integer year = cal.get(Calendar.YEAR);
        Integer month = cal.get(Calendar.MONTH) + 1;
        Integer day = cal.get(Calendar.DAY_OF_MONTH);

        Integer maxNumberByDate = 0;

        for (String codeProduct : codesProduct) {
            String[] codeStr = codeProduct.split(" ");
            if (codeStr.length == 4) {
                if (Integer.parseInt(codeStr[0]) == year && Integer.parseInt(codeStr[1]) == month && Integer.parseInt(codeStr[2]) == day) {
                    Integer num = Integer.parseInt(codeStr[3]);
                    if (num >= maxNumberByDate) {
                        maxNumberByDate = num;
                    }
                }
            }
        }

        String newCode = year + " " + ProductService.checkFormat(month) + " " + ProductService.checkFormat(day) + " " + ProductService.checkFormat(maxNumberByDate + 1);

        return newCode;
    }

    public static String checkFormat(Integer num) {
        String checkNum;
        if (Integer.toString(num).length() == 1) {
            checkNum = "0" + num;
        } else {
            checkNum = String.valueOf(num);
        }
        return checkNum;
    }

    public String getCodeProduct(Product product) {
        String[] codeArr = product.getCode().split(" ");
        String code = codeArr[0] + codeArr[1] + codeArr[2] + codeArr[3];
        return code;
    }
}


