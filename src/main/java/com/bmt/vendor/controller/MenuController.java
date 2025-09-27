package com.bmt.vendor.controller;

import com.bmt.vendor.service.MenuService;
import com.bmt.vendor.view.request.MenuRequest;
import com.bmt.vendor.view.response.MenuResponse;
import com.common.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/menu")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/{vendorId}")
    public ResponseEntity<ApiResponse<MenuResponse>> create(@PathVariable UUID vendorId,
                                                            @Valid @RequestBody MenuRequest menuRequest) {
        MenuResponse response = menuService.create(vendorId, menuRequest);
        return ResponseEntity.ok(ApiResponse.success("Menu Item Created", response));
    }

    @PutMapping("/{menuItemId}")
    public ResponseEntity<ApiResponse<MenuResponse>> update(@PathVariable UUID menuItemId,
                                                            @Valid @RequestBody MenuRequest menuRequest) {
        MenuResponse response = menuService.update(menuItemId, menuRequest);
        return ResponseEntity.ok(ApiResponse.success("Menu Item Updated", response));
    }
}
