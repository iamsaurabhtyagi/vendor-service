package com.bmt.vendor.service;

import com.bmt.vendor.dao.MenuDao;
import com.bmt.vendor.view.request.MenuRequest;
import com.bmt.vendor.view.response.MenuResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuDao menuDao;

    public MenuServiceImpl(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Override
    public MenuResponse create(MenuRequest menuRequest) {
        return null;
    }

    @Override
    public MenuResponse update(MenuRequest menuRequest) {
        return null;
    }

    @Override
    public MenuResponse read(UUID vendorId, UUID menuItemId) {
        return null;
    }

    @Override
    public MenuResponse readVendorMenu(UUID vendorId) {
        return null;
    }

    @Override
    public MenuResponse delete(UUID menuItemId) {
        return null;
    }
}
