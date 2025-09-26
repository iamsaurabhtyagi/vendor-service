package com.bmt.vendor.service;

import com.bmt.vendor.dao.MenuDao;
import com.bmt.vendor.security.JwtUtil;
import com.bmt.vendor.util.converter.MenuConverter;
import com.bmt.vendor.view.request.MenuRequest;
import com.bmt.vendor.view.response.MenuResponse;
import com.bmt.vendor.view.response.UserResponse;
import com.common.model.vendor.MenuItem;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MenuServiceImpl implements MenuService {

    private final JwtUtil jwtUtil;
    private final MenuDao menuDao;

    public MenuServiceImpl(JwtUtil jwtUtil, MenuDao menuDao) {
        this.jwtUtil = jwtUtil;
        this.menuDao = menuDao;
    }

    @Override
    public MenuResponse create(MenuRequest menuRequest) {
        MenuItem menuItem = MenuConverter.requestToEntity(menuRequest);
        UserResponse userResponse = jwtUtil.getUserDetails();
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
