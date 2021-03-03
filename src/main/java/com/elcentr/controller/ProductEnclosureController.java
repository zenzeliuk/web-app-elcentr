package com.elcentr.controller;

import com.elcentr.controller.dto.ProductEnclosureDTO;
import com.elcentr.controller.dto.EnclosureDTO;
import com.elcentr.controller.mapper.ProductEnclosureMapper;
import com.elcentr.controller.mapper.EnclosureMapper;
import com.elcentr.model.ProductEnclosure;
import com.elcentr.model.Enclosure;
import com.elcentr.model.Product;
import com.elcentr.service.ProductEnclosureService;
import com.elcentr.service.EnclosureService;
import com.elcentr.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@WebServlet(urlPatterns = "/product-enclosure")
public class ProductEnclosureController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-store");

        ProductService productService = new ProductService();
        ProductEnclosureService productEnclosureService = new ProductEnclosureService();
        EnclosureService enclosureService = new EnclosureService();
        RequestDispatcher dispatcher;

        Product product = productService.getProductByRequestResponse(req, resp);

        List<EnclosureDTO> enclosureDTOList = toEnclosureDTOList(enclosureService.findAll());
        List<ProductEnclosure> productEnclosureList = productEnclosureService.findAllByIdProduct(product.getId());
        List<ProductEnclosureDTO> productEnclosureDTOList = toProductEnclosureDTOList(productEnclosureList);

        req.setAttribute("infoProduct", productService.getInfoProduct(product));
        req.setAttribute("productEnclosures", productEnclosureDTOList);             //List of all enclosures in product
        req.setAttribute("enclosures", enclosureDTOList);                           //List of all enclosures
        dispatcher = req.getRequestDispatcher("/jsp/product-enclosures.jsp");
        dispatcher.forward(req, resp);
    }

    private List<ProductEnclosureDTO> toProductEnclosureDTOList(List<ProductEnclosure> productEnclosures) {
        return productEnclosures
                .stream()
                .map(ProductEnclosureMapper::toProductEnclosureDTO)
                .collect(Collectors.toList());
    }

    private List<EnclosureDTO> toEnclosureDTOList(List<Enclosure> enclosures) {
        return enclosures.stream()
                .map(EnclosureMapper::toEnclosureDTO)
                .collect(Collectors.toList());
    }

}
