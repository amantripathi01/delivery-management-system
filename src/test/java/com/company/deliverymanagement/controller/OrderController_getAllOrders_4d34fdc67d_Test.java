package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.response.OrderResponseDto;
import com.company.deliverymanagement.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OrderController_getAllOrders_4d34fdc67d_Test {

    @InjectMocks
    private OrderController orderController = new OrderController();

    @Mock
    private OrderService orderService = new OrderService();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllOrdersSuccess() {
        OrderResponseDto order1 = new OrderResponseDto();
        OrderResponseDto order2 = new OrderResponseDto();
        List<OrderResponseDto> orders = Arrays.asList(order1, order2);

        when(orderService.findAll()).thenReturn(orders);

        ResponseEntity<List<OrderResponseDto>> response = orderController.getAllOrders();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetAllOrdersNoOrders() {
        when(orderService.findAll()).thenReturn(Arrays.asList());

        ResponseEntity<List<OrderResponseDto>> response = orderController.getAllOrders();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().size());
    }
}
