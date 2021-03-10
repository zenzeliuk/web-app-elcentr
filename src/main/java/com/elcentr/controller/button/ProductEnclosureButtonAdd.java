package com.elcentr.controller.button;

import com.elcentr.model.Enclosure;
import com.elcentr.model.Product;
import com.elcentr.model.ProductEnclosure;
import com.elcentr.service.EnclosureService;
import com.elcentr.service.ProductEnclosureService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/product-enclosure-button-add")
public class ProductEnclosureButtonAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ProductEnclosureService productEnclosureService = new ProductEnclosureService();
        EnclosureService enclosureService = new EnclosureService();

        Product product = (Product) session.getAttribute("product");
        String enclosureId = req.getParameter("enclosureId");
        String amount = req.getParameter("amount");

        if (product != null || enclosureId != null || amount != null) {
            Optional<Enclosure> optEnclosureById = enclosureService.findById(Integer.parseInt(enclosureId));
            optEnclosureById.ifPresent(enclosure -> productEnclosureService.save(ProductEnclosure.builder()
                    .product(product)
                    .enclosure(enclosure)
                    .amountEnclosure(Integer.parseInt(amount))
                    .build()));
        } else {
            String error = "Enclosure could not be added. Try again please";
            session.setAttribute("error", error);
        }
        resp.sendRedirect("/enclosures");
    }
}
