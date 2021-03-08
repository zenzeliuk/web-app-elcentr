package com.elcentr.controller.button;

import com.elcentr.model.Product;
import com.elcentr.model.ProductEnclosure;
import com.elcentr.service.ProductEnclosureService;

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
        HttpSession session = req.getSession();

        ProductEnclosureService productEnclosureService = new ProductEnclosureService();

        Product product = (Product) session.getAttribute("product");
        String productEnclosureId = req.getParameter("productEnclosureId");

        if (product != null || productEnclosureId != null) {
            Optional<ProductEnclosure> optComponent = productEnclosureService.findById(Integer.parseInt(productEnclosureId));
            optComponent.ifPresent(productEnclosureService::delete);
            resp.sendRedirect("/product-enclosure");
        } else {
            String error = "ProductEnclosure could not be removed. Try again please";
            session.setAttribute("error", error);
            resp.sendRedirect("/index.jsp");
        }
    }
}
