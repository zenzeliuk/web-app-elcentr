package com.elcentr.controller;

import com.elcentr.controller.dto.EnclosureDTO;
import com.elcentr.controller.mapper.EnclosureMapper;
import com.elcentr.dao.EnclosureDAO;
import com.elcentr.dao.ProductDAO;
import com.elcentr.model.Enclosure;
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

        String action = req.getParameter("action");
        ProductService productService = new ProductService(new ProductDAO());
        EnclosureService enclosureService = new EnclosureService(new EnclosureDAO());
        RequestDispatcher dispatcher;

        if (StringUtils.equalsIgnoreCase(action, "product")) {
            String codeProduct = productService.getCodeProduct();
            Product product = Product.builder()
                    .code(codeProduct)
                    .timeRegistration(new Date().getTime())
                    .name(req.getParameter("name"))
                    .amount(Integer.valueOf(req.getParameter("amount")))
                    .nominalCurrent(Integer.valueOf(req.getParameter("current")))
                    .decimalNumber(req.getParameter("decimal"))
                    .build();
            Optional<Product> optProduct = productService.save(product);
            if (optProduct.isPresent()) {
                Product savedProduct = optProduct.get();
                req.setAttribute("productId", savedProduct.getId());
                req.setAttribute("productCode", savedProduct.getCode());
                req.setAttribute("productName", savedProduct.getName());
                req.setAttribute("productIn", savedProduct.getNominalCurrent());
                req.setAttribute("enclosures", toEnclosureDTOList(enclosureService.findAll()));
                dispatcher = req.getRequestDispatcher("/jsp/enclosures.jsp");
                dispatcher.forward(req, resp);
            } else {
                req.setAttribute("message", "Product with such code is present. Try other code please");
                dispatcher = req.getRequestDispatcher("/index.jsp");
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
