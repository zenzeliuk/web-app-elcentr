package com.elcentr.controller;

import com.elcentr.controller.dto.ComplexDTO;
import com.elcentr.controller.dto.CustomerDTO;
import com.elcentr.controller.dto.OrderCustomerAndComplexDTO;
import com.elcentr.controller.mapper.ComplexMapper;
import com.elcentr.controller.mapper.CustomerMapper;
import com.elcentr.controller.mapper.OrderCustomerAndComplexMapper;
import com.elcentr.model.Customer;
import com.elcentr.model.Order;
import com.elcentr.model.Product;
import com.elcentr.model.ResidentialComplex;
import com.elcentr.service.CustomerService;
import com.elcentr.service.OrderService;
import com.elcentr.service.ProductService;
import com.elcentr.service.ResidentialComplexService;
import org.apache.commons.lang3.StringUtils;

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

@WebServlet(urlPatterns = "/product-order")
public class ProductOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-store");

        HttpSession session = req.getSession();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        CustomerService customerService = new CustomerService();
        ResidentialComplexService complexService = new ResidentialComplexService();
        RequestDispatcher dispatcher;

        Optional<Product> optProduct = productService.findById((Integer) session.getAttribute("productId"));
        if (optProduct.isPresent()) {
            Product product = optProduct.get();
            List<Order> orders = orderService.findByIdProduct(product.getId());

            String nameCustomerInOrder = "";
            String nameComplexInOrder = "";
            String idCustomerInOrder = "";
            String idComplexInOrder = "";

            if (orders != null) {
                if (orders.get(0).getCustomer() != null) {
                    nameCustomerInOrder = String.format("Customer: %s", orders.get(0).getCustomer().getName());
                    idCustomerInOrder = String.format("ResidentialComplex: %s", orders.get(0).getCustomer().getId());
                }
                if (orders.get(0).getResidentialComplex() != null) {
                    nameComplexInOrder = String.format("Customer: %s", orders.get(0).getResidentialComplex().getName());
                    idComplexInOrder = String.format("ResidentialComplex: %s", orders.get(0).getResidentialComplex().getId());
                }
            }

            req.setAttribute("productId", product.getId());
            req.setAttribute("messageProduct", String.format("Product %s with code %s", product.getName(), productService.getCodeProduct(product)));

            req.setAttribute("nameCustomerInOrder", nameCustomerInOrder);
            req.setAttribute("nameComplexInOrder", nameComplexInOrder);
            req.setAttribute("idCustomerInOrder", idCustomerInOrder);
            req.setAttribute("idComplexInOrder", idComplexInOrder);

            req.setAttribute("customers", toCustomerDTOList(customerService.findAll()));
            req.setAttribute("complex", toComplexDTOList(complexService.findAll()));
            dispatcher = req.getRequestDispatcher("/jsp/product-order.jsp");
        } else {
            req.setAttribute("error", "The product not found. Try again please");
            session.setAttribute("productIdNew", null);
            session.setAttribute("productId", null);
            dispatcher = req.getRequestDispatcher("/index.jsp");
        }
        dispatcher.forward(req, resp);

    }

    private List<OrderCustomerAndComplexDTO> toOrderCustomerAndComplexDTOList(List<Order> orders) {
        return orders
                .stream()
                .map(OrderCustomerAndComplexMapper::toOrderCustomerAndComplexDTO)
                .collect(Collectors.toList());
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
