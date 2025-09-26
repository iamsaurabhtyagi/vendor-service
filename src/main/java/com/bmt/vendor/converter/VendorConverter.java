package com.bmt.vendor.converter;

import com.bmt.vendor.view.request.VendorRequest;
import com.bmt.vendor.view.response.VendorResponse;
import com.common.model.vendor.Vendor;
import com.common.model.vendor.VendorStatus;
import com.common.model.vendor.VendorType;

public class VendorConverter {
    public static Vendor requestToEntityVendor(Vendor vendor, VendorRequest vendorRequest) {
        if(vendor == null)
            vendor = new Vendor();

        vendor.setVendorStatus(VendorStatus.ACTIVE);

        if(vendorRequest.getVendorType() != null)
            vendor.setVendorType(vendorRequest.getVendorType());

        if(vendorRequest.getName() != null)
            vendor.setName(vendorRequest.getName());

        if(vendorRequest.getEmail() != null)
            vendor.setEmail(vendorRequest.getEmail());

        if(vendorRequest.getPhone() != null)
            vendor.setPhone(vendorRequest.getPhone());

        if(vendorRequest.getDescription() != null)
            vendor.setDescription(vendorRequest.getDescription());

        if(vendorRequest.getLogoUrl() != null)
            vendor.setLogoUrl(vendorRequest.getLogoUrl());

        if(vendorRequest.getCapacityMin() != null)
            vendor.setCapacityMin(vendorRequest.getCapacityMin());

        if(vendorRequest.getCapacityMax() != null)
            vendor.setCapacityMax(vendorRequest.getCapacityMax());

        return vendor;
    }

    public static VendorResponse entityToResponseVendor(Vendor vendor) {
        VendorResponse vendorResponse = new VendorResponse();

        vendorResponse.setName(vendor.getName());
        vendorResponse.setEmail(vendor.getEmail());
        vendorResponse.setPhone(vendor.getPhone());
        vendorResponse.setDescription(vendor.getDescription());
        vendorResponse.setLogoUrl(vendor.getLogoUrl());
        vendorResponse.setCapacityMin(vendor.getCapacityMin());
        vendorResponse.setCapacityMax(vendor.getCapacityMax());

        return vendorResponse;
    }
}
