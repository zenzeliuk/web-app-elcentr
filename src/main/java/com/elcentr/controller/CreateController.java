package com.elcentr.controller;

import com.elcentr.dao.EnclosureDAO;
import com.elcentr.dao.ProductDAO;
import com.elcentr.model.Product;
import com.elcentr.service.EnclosureService;
import com.elcentr.service.ProductService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@WebServlet(urlPatterns = "/create")
public class CreateController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-store");

        String action = req.getParameter("action");
        ProductService productService = new ProductService(new ProductDAO());
        RequestDispatcher dispatcher;

        if (StringUtils.equalsIgnoreCase(action, "product")) {
            String codeProduct = productService.getCodeProduct();
            Product product = Product.builder()
                    .code(codeProduct)
                    .timeRegistration(new Date().getTime())
                    .name(req.getParameter("name"))
                    .amount(Integer.valueOf(req.getParameter("amount")))
                    .indexProtectionProduct(Integer.valueOf(req.getParameter("ip")))
                    .nominalCurrent(Integer.valueOf(req.getParameter("current")))
                    .decimalNumber(req.getParameter("decimal"))
                    .build();
            Optional<Product> optProduct = productService.save(product);
            if (optProduct.isPresent()) {
                Product savedProduct = optProduct.get();
                req.setAttribute("productId", savedProduct.getId());
                req.setAttribute("productCode", savedProduct.getCode());
                req.setAttribute("productName", savedProduct.getName());
                req.setAttribute("productIP", savedProduct.getIndexProtectionProduct());
                req.setAttribute("productIn", savedProduct.getNominalCurrent());
                dispatcher = req.getRequestDispatcher("/jsp/component.jsp");
                dispatcher.forward(req, resp);
            } else {
                req.setAttribute("message", "Product with such code is present. Try other code please");
                dispatcher = req.getRequestDispatcher("/index.jsp");
                dispatcher.forward(req, resp);
            }
        }
    }
}
