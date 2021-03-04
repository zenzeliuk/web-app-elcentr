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

        Product productNew = (Product) session.getAttribute("productNew");
        Product product = (Product) session.getAttribute("product");

        if (productNew != null) {
            String info = productService.getInfoProduct(productNew) + "saved";
            session.setAttribute("info", info);
            session.setAttribute("product", productNew);
            session.setAttribute("productNew", null);
            resp.sendRedirect("/jsp/product.jsp");
        } else if (product != null) {
            String info = productService.getInfoProduct(product);
            session.setAttribute("info", info);
            resp.sendRedirect("/jsp/product.jsp");
        } else {
            String error = "The product not found. Try again please";
            session.setAttribute("error", error);
            resp.sendRedirect("/index.jsp");
        }
    }
}
