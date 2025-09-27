package com.bmt.vendor.dao;

import com.bmt.vendor.view.response.VendorResponse;
import com.common.model.vendor.Vendor;
import com.common.model.vendor.VendorStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface VendorDao extends CrudRepository<Vendor, UUID> {
    List<Vendor> findByVendorStatus(VendorStatus vendorStatus);
}
