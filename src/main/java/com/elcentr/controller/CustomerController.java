package com.elcentr.controller;

import com.elcentr.controller.dto.CustomerDTO;
import com.elcentr.controller.mapper.CustomerMapper;
import com.elcentr.model.Customer;
import com.elcentr.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/customer")
public class CustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-store");

        CustomerService customerService = new CustomerService();
        RequestDispatcher dispatcher;

        List<CustomerDTO> customerDTOList = toCustomerDTOList(customerService.findAll());

        req.setAttribute("info", req.getParameter("messageSave"));
        req.setAttribute("messageSave", null);
        req.setAttribute("customers", customerDTOList);
        dispatcher = req.getRequestDispatcher("/jsp/product-order.jsp");
        dispatcher.forward(req, resp);
    }

    private List<CustomerDTO> toCustomerDTOList(List<Customer> customers) {
        return customers
                .stream()
                .map(CustomerMapper::toCustomerDTO)
                .collect(Collectors.toList());
    }
}
