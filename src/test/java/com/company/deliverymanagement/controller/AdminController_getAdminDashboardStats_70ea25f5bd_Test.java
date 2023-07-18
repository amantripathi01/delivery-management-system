package com.company.deliverymanagement.controller;

import com.company.deliverymanagement.entity.model.Company;
import com.company.deliverymanagement.service.impl.DashboardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AdminController_getAdminDashboardStats_70ea25f5bd_Test {

    @InjectMocks
    private AdminController adminController;

    @Mock
    private DashboardService dashboardService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAdminDashboardStats_success() {
        Company company = new Company();
        company.setId(1);
        company.setName("Test Company");
        // TODO: Set other necessary fields for the company object

        when(dashboardService.getAdminDashboardStats()).thenReturn(company);

        Company result = adminController.getAdminDashboardStats();

        assertEquals(company, result);
    }

    @Test
    public void testGetAdminDashboardStats_failure() {
        when(dashboardService.getAdminDashboardStats()).thenReturn(null);

        Company result = adminController.getAdminDashboardStats();

        assertEquals(null, result);
    }
}
