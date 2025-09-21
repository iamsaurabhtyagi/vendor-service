package com.bmt.vendor.controller;

import com.bmt.vendor.service.MenuService;
import com.bmt.vendor.view.request.MenuRequest;
import com.bmt.vendor.view.request.VendorRequest;
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

    @PostMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<MenuResponse>> create(@PathVariable UUID userId,
                                                            @Valid @RequestBody MenuRequest menuRequest) {
        return ResponseEntity.ok(ApiResponse.success("Created", null));
    }
}
