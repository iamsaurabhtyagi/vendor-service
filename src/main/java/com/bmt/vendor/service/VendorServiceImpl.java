package com.bmt.vendor.service;

import com.bmt.vendor.converter.VendorConverter;
import com.bmt.vendor.dao.VendorDao;
import com.bmt.vendor.view.request.VendorRequest;
import com.bmt.vendor.view.response.VendorResponse;
import com.common.exception.VendorNotFoundException;
import com.common.model.vendor.Vendor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorDao vendorDao;

    public VendorServiceImpl(VendorDao vendorDao) {
        this.vendorDao = vendorDao;
    }
    @Override
    public VendorResponse create(VendorRequest vendorRequest) {
        Vendor vendor = VendorConverter.requestToEntityVendor(null, vendorRequest);

        vendor = vendorDao.save(vendor);

        return VendorConverter.entityToResponseVendor(vendor);
    }

    @Override
    public VendorResponse update(UUID vendorId, VendorRequest vendorRequest) {
        Vendor vendor = getVendor(vendorId);

        vendor = VendorConverter.requestToEntityVendor(vendor, vendorRequest);
        vendor = vendorDao.save(vendor);

        return VendorConverter.entityToResponseVendor(vendor);
    }

    @Override
    public VendorResponse read(UUID vendorId) {
        Vendor vendor = getVendor(vendorId);

        return VendorConverter.entityToResponseVendor(vendor);
    }

    @Override
    public String delete(UUID vendorId) {
        return null;
    }

    private Vendor getVendor(UUID vendorId) {
        return vendorDao.findById(vendorId)
                .orElseThrow(() -> {throw new VendorNotFoundException("Vendor does not exist");});
    }
}
