package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.dto.request.OrderRequestDto;
import com.company.deliverymanagement.dto.response.ResponseDto;
import com.company.deliverymanagement.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderController_updateOrder_23d9d8bdd2_Test {

    @InjectMocks
    OrderController orderController;

    @Mock
    OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void testUpdateOrderSuccess() {
        Long id = 1L;
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        // TODO: Set orderRequestDto fields

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Order updated successfully");

        when(orderService.updateOrder(id, orderRequestDto)).thenReturn(ResponseEntity.ok(responseDto));

        ResponseEntity<ResponseDto> responseEntity = orderController.updateOrder(id, orderRequestDto);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Order updated successfully", responseEntity.getBody().getMessage());
    }

    @Test
    public void testUpdateOrderFailure() {
        Long id = 1L;
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        // TODO: Set orderRequestDto fields

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Order update failed");

        when(orderService.updateOrder(id, orderRequestDto)).thenReturn(ResponseEntity.badRequest().body(responseDto));

        ResponseEntity<ResponseDto> responseEntity = orderController.updateOrder(id, orderRequestDto);

        assertEquals(400, responseEntity.getStatusCodeValue());
        assertEquals("Order update failed", responseEntity.getBody().getMessage());
    }
}
