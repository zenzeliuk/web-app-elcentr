package com.elcentr.controller;

import com.elcentr.controller.dto.ComponentEnclosureDTO;
import com.elcentr.controller.dto.EnclosureDTO;
import com.elcentr.controller.mapper.ComponentEnclosureMapper;
import com.elcentr.controller.mapper.EnclosureMapper;
import com.elcentr.model.Enclosure;
import com.elcentr.model.Product;
import com.elcentr.service.ComponentService;
import com.elcentr.service.ProductService;

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

import static java.util.Objects.isNull;

@WebServlet(urlPatterns = "/add-product-enclosure")
public class AddProductEnclosure extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-store");

        ProductService productService = new ProductService();
        ComponentService componentService = new ComponentService();
        RequestDispatcher dispatcher;

        String productId = req.getParameter("productId");

        Optional<Product> optProduct = Optional.ofNullable(productService.findById(Integer.parseInt(productId)))
                .orElseThrow(() -> new RuntimeException(String.format("Product with id %s was not found", productId)));

        List<ComponentEnclosureDTO> componentEnclosureDTOList = componentService.findAllByIdProduct(optProduct.get().getId())
                .stream()
                .map(ComponentEnclosureMapper::toComponentEnclosureDTO)
                .collect(Collectors.toList());

        req.setAttribute("productId", productId);
        req.setAttribute("messageInfoProduct", String.format("%s, code:%s, In:%d,\n%s", optProduct.get().getName(), optProduct.get().getCode(), optProduct.get().getNominalCurrent(), getMessage(componentEnclosureDTOList)));
        req.setAttribute("componentEnclosures", componentEnclosureDTOList);
        dispatcher = req.getRequestDispatcher("/jsp/product-enclosures.jsp");
        dispatcher.forward(req, resp);

        System.out.println(componentEnclosureDTOList.get(0));
        System.out.println(componentEnclosureDTOList.get(1));

        //        if (optProduct.isPresent()) {
//            error = "Product was not found";
//            req.setAttribute("error", error);
//            dispatcher = req.getRequestDispatcher("/jsp/index.jsp");
//            dispatcher.forward(req, resp);
//        } else {
//
//            req.setAttribute("productCode", code);
//            req.setAttribute("productName", savedProduct.getName());
//            req.setAttribute("enclosures", toEnclosureDTOList(enclosureService.findAll()));
//        }
//
//    }
//

    }

//    private List<EnclosureDTO> toEnclosureDTOList(List<Enclosure> enclosures) {
//        return enclosures.stream()
//                .map(EnclosureMapper::toEnclosureDTO)
//                .collect(Collectors.toList());
//    }


    private String getMessage(List<ComponentEnclosureDTO> componentEnclosureDTOList) {
        if (isNull(componentEnclosureDTOList) || componentEnclosureDTOList.isEmpty()) {
            return "You have 0 enclosure in product.";
        }
        return String.format("You have %d enclosure in product.", componentEnclosureDTOList.size());
    }
}
