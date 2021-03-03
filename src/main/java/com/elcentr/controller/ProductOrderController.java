package com.elcentr.controller;

import com.elcentr.controller.dto.ComplexDTO;
import com.elcentr.controller.dto.CustomerDTO;
import com.elcentr.controller.dto.ProductOrderDTO;
import com.elcentr.controller.mapper.ComplexMapper;
import com.elcentr.controller.mapper.CustomerMapper;
import com.elcentr.controller.mapper.ProductOrderMapper;
import com.elcentr.model.Customer;
import com.elcentr.model.Order;
import com.elcentr.model.Product;
import com.elcentr.model.ResidentialComplex;
import com.elcentr.service.CustomerService;
import com.elcentr.service.OrderService;
import com.elcentr.service.ProductService;
import com.elcentr.service.ResidentialComplexService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/product-order")
public class ProductOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-store");

        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        CustomerService customerService = new CustomerService();
        ResidentialComplexService complexService = new ResidentialComplexService();
        RequestDispatcher dispatcher;

        Product product = productService.getProductByRequestResponse(req, resp);
        Order order = orderService.findByProductOrCreateNew(product);
        ProductOrderDTO productOrderDTO = ProductOrderMapper.toProductOrderDTO(order);

        List<CustomerDTO> customerDTOList = toCustomerDTOList(customerService.findAll());
        List<ComplexDTO> complexDTOList = toComplexDTOList(complexService.findAll());

        req.setAttribute("infoProduct", productService.getInfoProduct(product));
        req.setAttribute("order", productOrderDTO);
        req.setAttribute("customers", customerDTOList);
        req.setAttribute("complexes", complexDTOList);
        dispatcher = req.getRequestDispatcher("/jsp/product-order.jsp");
        dispatcher.forward(req, resp);
    }


    private List<CustomerDTO> toCustomerDTOList(List<Customer> customers) {
        return customers
                .stream()
                .map(CustomerMapper::toCustomerDTO)
                .collect(Collectors.toList());
    }

    private List<ComplexDTO> toComplexDTOList(List<ResidentialComplex> complexes) {
        return complexes
                .stream()
                .map(ComplexMapper::toComplexDTO)
                .collect(Collectors.toList());
    }
}
