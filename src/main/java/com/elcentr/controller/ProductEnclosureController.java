package com.elcentr.controller;

import com.elcentr.controller.dto.ComponentEnclosureDTO;
import com.elcentr.controller.dto.EnclosureDTO;
import com.elcentr.controller.mapper.ComponentEnclosureMapper;
import com.elcentr.controller.mapper.EnclosureMapper;
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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@WebServlet(urlPatterns = "/product-enclosure")
public class ProductEnclosureController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-store");

        HttpSession session = req.getSession();
        ProductService productService = new ProductService();
        ComponentService componentService = new ComponentService();
        EnclosureService enclosureService = new EnclosureService();
        RequestDispatcher dispatcher;

        Optional<Product> optProduct = productService.findById((Integer) session.getAttribute("productId"));
        if (optProduct.isPresent()) {
            Product product = optProduct.get();
            List<Component> allComponentsByIdProduct = componentService.findAllByIdProduct(product.getId());
            req.setAttribute("productId", product.getId());
            req.setAttribute("infoProduct", productService.getInfoProduct(product));
            req.setAttribute("messageProductEnclosure", getMessage(toComponentEnclosureDTOList(allComponentsByIdProduct)));
            req.setAttribute("componentEnclosures", toComponentEnclosureDTOList(allComponentsByIdProduct));
            req.setAttribute("enclosures", toEnclosureDTOList(enclosureService.findAll()));
            dispatcher = req.getRequestDispatcher("/jsp/product-enclosures.jsp");
        } else {
            req.setAttribute("error", "The product not found. Try again please");
            session.setAttribute("productIdNew", null);
            session.setAttribute("productId", null);
            dispatcher = req.getRequestDispatcher("/index.jsp");
        }
        dispatcher.forward(req, resp);

    }

    private List<ComponentEnclosureDTO> toComponentEnclosureDTOList(List<Component> components) {
        return components
                .stream()
                .map(ComponentEnclosureMapper::toComponentEnclosureDTO)
                .collect(Collectors.toList());
    }

    private List<EnclosureDTO> toEnclosureDTOList(List<Enclosure> enclosures) {
        return enclosures.stream()
                .map(EnclosureMapper::toEnclosureDTO)
                .collect(Collectors.toList());
    }

    private String getMessage(List<ComponentEnclosureDTO> componentEnclosureDTOList) {
        if (isNull(componentEnclosureDTOList) || componentEnclosureDTOList.isEmpty()) {
            return "You have 0 enclosure in product.";
        }
        return String.format("You have %d enclosure in product.", componentEnclosureDTOList.size());
    }
}
