package com.elcentr.controller.button;

import com.elcentr.model.Customer;
import com.elcentr.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/customer-button-create")
public class CustomerButtonCreate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-store");

        CustomerService customerService = new CustomerService();
        RequestDispatcher dispatcher;

        String name = req.getParameter("name");
        String notes = req.getParameter("notes");
        String error;

        if (name == null || name.isBlank()) {
            error = "One of more of the input boxes were blank. Try again.";
            req.setAttribute("error", error);
            dispatcher = req.getRequestDispatcher("/jsp/customer.jsp");
            dispatcher.forward(req, resp);
        } else {
            Customer customer = Customer.builder()
                    .name(name)
                    .notes(notes)
                    .build();
            Optional<Customer> optionalCustomer = customerService.save(customer);
            if (optionalCustomer.isPresent()) {
                String messageSave = "One of more of the input boxes were blank. Try again.";
                req.setAttribute("messageSave", messageSave);
                dispatcher = req.getRequestDispatcher("/customer");
            } else {
                req.setAttribute("error", "The customer could not be saved. Try again please");
                dispatcher = req.getRequestDispatcher("/jsp/customer.jsp");
            }
            dispatcher.forward(req, resp);
        }

    }
}
