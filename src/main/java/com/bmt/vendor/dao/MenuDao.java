package com.bmt.vendor.dao;

import com.common.model.vendor.MenuItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface MenuDao extends CrudRepository<MenuItem, UUID> {
    List<MenuItem> findByVendorId(UUID vendorId);

    void deleteByVendorId(UUID vendorId);
}
