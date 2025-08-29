package com.bmt.vendor.dao;

import com.common.model.vendor.Vendor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VendorDao extends CrudRepository<Vendor, UUID> {
}
