package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.response.OrderResponseDto;
import com.company.deliverymanagement.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class OrderController_getOrderById_a751eb0e2f_Test {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    public void testGetOrderByIdSuccess() {
        long id = 1L;
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(id);
        when(orderService.findById(id)).thenReturn(orderResponseDto);

        ResponseEntity<OrderResponseDto> responseEntity = orderController.getOrderById(id);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(id, responseEntity.getBody().getId());
        verify(orderService).findById(id);
    }

    @Test
    public void testGetOrderByIdFailure() {
        long id = 2L;
        when(orderService.findById(id)).thenReturn(null);

        ResponseEntity<OrderResponseDto> responseEntity = orderController.getOrderById(id);

        assertEquals(404, responseEntity.getStatusCodeValue());
        assertEquals(null, responseEntity.getBody());
        verify(orderService).findById(id);
    }
}
