package com.bmt.vendor.service;

import com.bmt.vendor.converter.VendorConverter;
import com.bmt.vendor.dao.VendorDao;
import com.bmt.vendor.security.JwtUtil;
import com.bmt.vendor.view.request.VendorRequest;
import com.bmt.vendor.view.request.VendorStatusRequest;
import com.bmt.vendor.view.response.VendorResponse;
import com.common.exception.InvalidVendorException;
import com.common.exception.VendorNotFoundException;
import com.common.model.vendor.Vendor;
import com.common.model.vendor.VendorStatus;
import com.common.security.UserContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VendorServiceImpl implements VendorService {

    private final JwtUtil jwtUtil;
    private final VendorDao vendorDao;

    public VendorServiceImpl(JwtUtil jwtUtil, VendorDao vendorDao) {
        this.jwtUtil = jwtUtil;
        this.vendorDao = vendorDao;
    }
    @Override
    public VendorResponse create(VendorRequest vendorRequest) {
        Vendor vendor = VendorConverter.requestToEntityVendor(null, vendorRequest);
        UserContext userContext = jwtUtil.getUserDetails();

        vendor.setUserId(userContext.getUserId());
        vendor = vendorDao.save(vendor);

        return VendorConverter.entityToResponseVendor(vendor);
    }

    @Override
    public VendorResponse update(UUID vendorId, VendorRequest vendorRequest) {
        Vendor vendor = getVendor(vendorId);
        UserContext userContext = jwtUtil.getUserDetails();

        if(!userContext.getUserId().equals(vendor.getUserId()))
            throw new InvalidVendorException("Vendor and User doesn't match");

        vendor = VendorConverter.requestToEntityVendor(vendor, vendorRequest);

        vendor = vendorDao.save(vendor);

        return VendorConverter.entityToResponseVendor(vendor);
    }

    @Override
    public VendorResponse delete(UUID vendorId) {
        Vendor vendor = getVendor(vendorId);

        vendor.setVendorStatus(VendorStatus.INACTIVE);
        vendor = vendorDao.save(vendor);

        return VendorConverter.entityToResponseVendor(vendor);
    }

    @Override
    public VendorResponse read(UUID vendorId) {
        Vendor vendor = getVendor(vendorId);

        return VendorConverter.entityToResponseVendor(vendor);
    }

    @Override
    public List<VendorResponse> getVendorByStatus(VendorStatusRequest vendorStatus) {
        List<Vendor> activeVendors = vendorDao.findByVendorStatus(vendorStatus.getVendorStatus());
        return VendorConverter.entityToResponseVendorList(activeVendors);
    }

    private Vendor getVendor(UUID vendorId) {
        return vendorDao.findById(vendorId)
                .orElseThrow(() -> {throw new VendorNotFoundException("Vendor does not exist");});
    }
}
