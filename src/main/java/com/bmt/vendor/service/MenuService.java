package com.bmt.vendor.service;

import com.bmt.vendor.view.request.MenuRequest;
import com.bmt.vendor.view.response.MenuResponse;

import java.util.List;
import java.util.UUID;

public interface MenuService {

    MenuResponse create(UUID vendorId, MenuRequest menuRequest);
    MenuResponse update(UUID menuItemId, MenuRequest menuRequest);
    MenuResponse readMenuItem(UUID menuItemId);
    List<MenuResponse> readVendorMenuItems(UUID vendorId);
    MenuResponse delete(UUID menuItemId);
    List<MenuResponse> deleteMenuItems(UUID vendorId);
}
