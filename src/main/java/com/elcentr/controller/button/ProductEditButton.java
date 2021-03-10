package com.elcentr.controller.button;

import com.elcentr.model.Product;
import com.elcentr.service.ProductService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/product-edit")
public class ProductEditButton extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ProductService productService = new ProductService();
        RequestDispatcher dispatcher;

        String productId = req.getParameter("productId");

        if (StringUtils.isNumeric(productId)) {
            Optional<Product> optionalProduct = productService.findById(Integer.parseInt(productId));
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                session.setAttribute("product", product);
            }
        }

        dispatcher = req.getRequestDispatcher("/product");
        dispatcher.forward(req, resp);

    }
}
