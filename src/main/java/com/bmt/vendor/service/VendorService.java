package com.bmt.vendor.service;

import com.bmt.vendor.view.request.VendorRequest;
import com.bmt.vendor.view.request.VendorStatusRequest;
import com.bmt.vendor.view.response.VendorResponse;

import java.util.List;
import java.util.UUID;

public interface VendorService {
    VendorResponse create(VendorRequest vendorRequest);
    VendorResponse update(UUID vendorId, VendorRequest vendorRequest);
    VendorResponse read(UUID vendorId);
    VendorResponse delete(UUID vendorId);
    List<VendorResponse> getVendorByStatus(VendorStatusRequest vendorStatus);
}
