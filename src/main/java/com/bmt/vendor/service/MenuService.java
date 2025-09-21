package com.bmt.vendor.service;

import com.bmt.vendor.view.request.MenuRequest;
import com.bmt.vendor.view.response.MenuResponse;

import java.util.UUID;

public interface MenuService {

    MenuResponse create(MenuRequest menuRequest);
    MenuResponse update(MenuRequest menuRequest);
    MenuResponse read(UUID vendorId, UUID menuItemId);
    MenuResponse readVendorMenu(UUID vendorId);
    MenuResponse delete(UUID menuItemId);
}
