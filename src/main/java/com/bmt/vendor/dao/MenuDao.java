package com.bmt.vendor.dao;

import com.common.model.vendor.MenuItem;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MenuDao extends CrudRepository<MenuItem, UUID> {
}
