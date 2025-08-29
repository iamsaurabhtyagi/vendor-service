package com.bmt.vendor.controller;

import com.bmt.vendor.service.VendorService;
import com.bmt.vendor.view.request.VendorRequest;
import com.bmt.vendor.view.response.VendorResponse;
import com.common.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/get")
    public String get() {
        return "Hello Vendor";
    }

    @PostMapping
    public ResponseEntity<ApiResponse<VendorResponse>> create(@Valid @RequestBody VendorRequest vendorRequest) {
        VendorResponse response = vendorService.create(vendorRequest);
        return ResponseEntity.ok(ApiResponse.success("Created", response));
    }
}
