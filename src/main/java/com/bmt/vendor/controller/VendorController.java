package com.bmt.vendor.controller;

import com.bmt.vendor.service.VendorService;
import com.bmt.vendor.view.request.VendorRequest;
import com.bmt.vendor.view.response.VendorResponse;
import com.common.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public String greet() {
        return "Hello Vendor";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<VendorResponse>> create(@Valid @RequestBody VendorRequest vendorRequest) {
        VendorResponse response = vendorService.create(null, vendorRequest);
        return ResponseEntity.ok(ApiResponse.success("Created", response));
    }

    @PutMapping("/{vendorId}/user/{userId}")
    public ResponseEntity<ApiResponse<VendorResponse>> update(@PathVariable UUID vendorId,
                                                              @PathVariable UUID userId,
                                                              @Valid @RequestBody VendorRequest vendorRequest) {
        VendorResponse response = vendorService.update(vendorId, userId, vendorRequest);
        return ResponseEntity.ok(ApiResponse.success("Updated", response));
    }

    @GetMapping("/{vendorId}")
    public ResponseEntity<ApiResponse<VendorResponse>> get(@PathVariable UUID vendorId) {
        VendorResponse response = vendorService.read(vendorId);
        return ResponseEntity.ok(ApiResponse.success("Read", response));
    }

    @DeleteMapping("/{vendorId}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable UUID vendorId) {
        String response = vendorService.delete(vendorId);
        return ResponseEntity.ok(ApiResponse.success("Deleted", response));
    }
}
