package com.bmt.vendor.controller;

import com.bmt.vendor.service.MenuService;
import com.bmt.vendor.view.request.MenuRequest;
import com.bmt.vendor.view.response.MenuResponse;
import com.common.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/menu")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MenuResponse>> create(@Valid @RequestBody MenuRequest menuRequest) {
        MenuResponse response = menuService.create(menuRequest);
        return ResponseEntity.ok(ApiResponse.success("Created", response));
    }
}
