package com.elcentr.controller;

import com.elcentr.model.Product;
import com.elcentr.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import static java.util.Objects.nonNull;

@WebServlet(urlPatterns = "/create-product")
public class CreateProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-store");

        HttpSession session = req.getSession();
        ProductService productService = new ProductService();
        RequestDispatcher dispatcher;

        Long timeRegistration = new Date().getTime();
        String name = req.getParameter("name");
        String amount = req.getParameter("amount");
        String current = req.getParameter("current");
        String decimal = req.getParameter("decimal");
        String error;

        if (name == null || amount == null || current == null || name.isBlank() || amount.isBlank() || current.isBlank()) {
            error = "One of more of the input boxes were blank. Try again.";
            req.setAttribute("error", error);
            dispatcher = req.getRequestDispatcher("/jsp/create-product.jsp");
            dispatcher.forward(req, resp);
        } else {
            Product product = Product.builder()
                    .code(productService.createCodeProduct())
                    .timeRegistration(timeRegistration)
                    .name(name)
                    .amount(Integer.parseInt(amount))
                    .nominalCurrent(Integer.parseInt(current))
                    .decimalNumber(decimal)
                    .build();

            Optional<Product> optProduct = productService.save(product);
            if (optProduct.isPresent()) {
                session.setAttribute("productIdNew", optProduct.get().getId());
                session.setAttribute("productId", null);
                resp.sendRedirect("/product");
            } else {
                req.setAttribute("error", "The product could not be saved. Try again please");
                dispatcher = req.getRequestDispatcher("/index.jsp");
                dispatcher.forward(req, resp);
            }


        }
    }
}
