package com.bmt.vendor.service;

import com.bmt.vendor.view.request.VendorRequest;
import com.bmt.vendor.view.response.VendorResponse;
import com.common.model.vendor.Vendor;

import java.util.UUID;

public interface VendorService {
    VendorResponse create(VendorRequest vendorRequest);
    VendorResponse update(UUID vendorId, VendorRequest vendorRequest);
    VendorResponse read(UUID vendorId);
    String delete(UUID vendorId);

}
