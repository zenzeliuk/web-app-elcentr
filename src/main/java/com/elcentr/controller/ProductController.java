package com.elcentr.controller;

import com.elcentr.controller.dto.ProductDTO;
import com.elcentr.controller.mapper.ProductMapper;
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
import java.util.List;
import java.util.stream.Collectors;

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

        Product product = (Product) session.getAttribute("product");

        if (product != null) {
            String info = productService.getInfoProduct(product);
            session.setAttribute("info", info);
        }

        List<ProductDTO> productDTOList = toProductDTOList(productService.findAll());
        req.setAttribute("products", productDTOList);
        dispatcher = req.getRequestDispatcher("/jsp/product.jsp");
        dispatcher.forward(req, resp);
    }

    private List<ProductDTO> toProductDTOList(List<Product> products) {
        return products.stream()
                .map(ProductMapper::toProductDTO)
                .collect(Collectors.toList());
    }
}
