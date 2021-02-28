package com.elcentr.controller.button;

import com.elcentr.model.Component;
import com.elcentr.model.Enclosure;
import com.elcentr.model.Product;
import com.elcentr.service.ComponentService;
import com.elcentr.service.EnclosureService;
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

@WebServlet(urlPatterns = "/product-enclosure-button-delete")
public class ProductEnclosureButtonDelete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-store");
        HttpSession session = req.getSession();

        ProductService productService = new ProductService();
        ComponentService componentService = new ComponentService();
        RequestDispatcher dispatcher;

        Integer productSessionId = (Integer) session.getAttribute("productId");
        String productId = req.getParameter("productId");
        String componentId = req.getParameter("componentId");

        Optional<Product> optProduct = productService.findById(Integer.parseInt(productId));
        Optional<Component> optComponent = componentService.findById(Integer.parseInt(componentId));

        if (optProduct.isPresent() || optComponent.isPresent() || productId.equals(productSessionId.toString())) {
            componentService.delete(optComponent.get());
            session.setAttribute("productId", productSessionId);
            resp.sendRedirect("/product-enclosure");
        } else {
            req.setAttribute("error","Component could not be removed. Try again please");
            session.setAttribute("productId", productSessionId);
            dispatcher = req.getRequestDispatcher("/product-enclosure");
            dispatcher.forward(req, resp);
        }
    }
}
