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
import java.util.Optional;

@WebServlet(urlPatterns = "/product")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-store");

        HttpSession session = req.getSession();
        ProductService productService = new ProductService();
        RequestDispatcher dispatcher;

        Optional<Product> optProduct = productService.findById((Integer) session.getAttribute("productId"));
        if (optProduct.isPresent()) {
            Product product = optProduct.get();
            req.setAttribute("messageProduct", String.format("Product %s with code %s", product.getName(), productService.getCodeProduct(product)));
            dispatcher = req.getRequestDispatcher("/jsp/product.jsp");
        } else {
            Optional<Product> optNewProduct = productService.findById((Integer) session.getAttribute("productIdNew"));
            if (optNewProduct.isPresent()) {
                Product savedProduct = optNewProduct.get();
                String code = productService.getCodeProduct(savedProduct);
                req.setAttribute("messageSave", String.format("Product %s with code %s saved", savedProduct.getName(), code));
                session.setAttribute("productId", session.getAttribute("productIdNew"));
                session.setAttribute("productIdNew", null);
                dispatcher = req.getRequestDispatcher("/jsp/product.jsp");
            } else {
                req.setAttribute("error", "The product not found. Try again please");
                session.setAttribute("productIdNew", null);
                session.setAttribute("productId", null);
                dispatcher = req.getRequestDispatcher("/index.jsp");
            }
        }
        dispatcher.forward(req, resp);
    }
}