package com.elcentr.service;

import com.elcentr.dao.CustomerDAO;
import com.elcentr.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    private static CustomerService customerService;
    private static CustomerDAO customerDAO;

    @BeforeAll
    public static void setData() {
        customerService = new CustomerService(customerDAO);
        customerDAO = Mockito.mock(CustomerDAO.class);
    }

    @Test
    void save_SUCCESS() {

        Customer mockedCustomer = Customer.builder()
                .name("test-name")
                .notes("bad-guy")
                .build();
        mockedCustomer.setId(1);

        when(customerDAO.save(any(Customer.class))).thenReturn(mockedCustomer);

        Customer testCustomer = customerDAO.save(Customer.builder()
                .name("test-name")
                .notes("bad-guy")
                .build());
        assertNotNull(testCustomer.getId());
        verify(customerDAO, times(1)).save(any(Customer.class));

    }

    @Test
    void save_WITH_EXCEPTION() {

        Customer testCustomer = Customer.builder()
                .name("test-name")
                .notes("bad-guy")
                .build();
        testCustomer.setId(1);

        Assertions.assertThrows(RuntimeException.class, () -> customerService.save(testCustomer));
        verifyZeroInteractions(customerDAO);

    }
}