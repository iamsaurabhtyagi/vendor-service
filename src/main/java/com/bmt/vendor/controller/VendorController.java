package com.bmt.vendor.controller;

import com.bmt.vendor.service.VendorService;
import com.bmt.vendor.view.request.VendorRequest;
import com.bmt.vendor.view.request.VendorStatusRequest;
import com.bmt.vendor.view.response.VendorResponse;
import com.common.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<VendorResponse>> create(@Valid @RequestBody VendorRequest vendorRequest) {
        VendorResponse response = vendorService.create(vendorRequest);
        return ResponseEntity.ok(ApiResponse.success("Vendor Created", response));
    }

    @PutMapping("/{vendorId}")
    public ResponseEntity<ApiResponse<VendorResponse>> update(@PathVariable UUID vendorId,
                                                              @Valid @RequestBody VendorRequest vendorRequest) {
        VendorResponse response = vendorService.update(vendorId, vendorRequest);
        return ResponseEntity.ok(ApiResponse.success("Vendor Updated", response));
    }

    @DeleteMapping("/{vendorId}")
    public ResponseEntity<ApiResponse<VendorResponse>> delete(@PathVariable UUID vendorId) {
        VendorResponse response = vendorService.delete(vendorId);
        return ResponseEntity.ok(ApiResponse.success("Vendor Deleted", response));
    }

    @GetMapping("/{vendorId}")
    public ResponseEntity<ApiResponse<VendorResponse>> get(@PathVariable UUID vendorId) {
        VendorResponse response = vendorService.read(vendorId);
        return ResponseEntity.ok(ApiResponse.success("Vendor Detail", response));
    }

    @GetMapping("/status")
    public ResponseEntity<ApiResponse<List<VendorResponse>>> getVendorByStatus(@Valid @RequestBody VendorStatusRequest request) {
        List<VendorResponse> responses = vendorService.getVendorByStatus(request);
        return ResponseEntity.ok(ApiResponse.success(request.getVendorStatus()+" Vendor Details", responses));
    }
}
