package com.elcentr.controller;

import com.elcentr.controller.dto.EnclosureDTO;
import com.elcentr.controller.mapper.EnclosureMapper;
import com.elcentr.model.Enclosure;
import com.elcentr.model.Product;
import com.elcentr.service.EnclosureService;
import com.elcentr.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/create")
public class CreateController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-store");

        ProductService productService = new ProductService();
        EnclosureService enclosureService = new EnclosureService();
        RequestDispatcher dispatcher;

        String codeProduct = productService.createCodeProduct();
        Long timeRegistration = new Date().getTime();
        String name = req.getParameter("name");
        String amount = req.getParameter("amount");
        String current =req.getParameter("current");
        String decimal = req.getParameter("decimal");

        String error;

        if (name == null || amount == null || current == null || name.isBlank() || amount.isBlank() || current.isBlank()) {
            error = "One of more of the input boxes were blank. Try again.";
            req.setAttribute("error", error);
            dispatcher = req.getRequestDispatcher("/create.jsp");
            dispatcher.forward(req, resp);
        } else {
            Product product = Product.builder()
                    .code(codeProduct)
                    .timeRegistration(timeRegistration)
                    .name(name)
                    .amount(Integer.parseInt(amount))
                    .nominalCurrent(Integer.parseInt(current))
                    .decimalNumber(decimal)
                    .build();

            Optional<Product> optProduct = productService.save(product);
            if (optProduct.isPresent()) {
                Product savedProduct = optProduct.get();
                req.setAttribute("id", savedProduct.getId());
                req.setAttribute("code", savedProduct.getCode());
                req.setAttribute("name", savedProduct.getName());
                req.setAttribute("current", savedProduct.getNominalCurrent());
                req.setAttribute("enclosures", toEnclosureDTOList(enclosureService.findAll()));
                dispatcher = req.getRequestDispatcher("/jsp/components-product.jsp");
                dispatcher.forward(req, resp);
            } else {
                req.setAttribute("error", "The product could not be saved. Try again please");
                dispatcher = req.getRequestDispatcher("/create.jsp");
                dispatcher.forward(req, resp);
            }

        }
    }

    private List<EnclosureDTO> toEnclosureDTOList(List<Enclosure> enclosures) {
        return enclosures.stream()
                .map(EnclosureMapper::toEnclosureDTO)
                .collect(Collectors.toList());
    }
}
