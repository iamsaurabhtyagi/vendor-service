package com.bmt.vendor.service;

import com.bmt.vendor.dao.MenuDao;
import com.bmt.vendor.dao.VendorDao;
import com.bmt.vendor.security.JwtUtil;
import com.bmt.vendor.converter.MenuConverter;
import com.bmt.vendor.view.request.MenuRequest;
import com.bmt.vendor.view.response.MenuResponse;
import com.common.exception.VendorNotFoundException;
import com.common.model.vendor.MenuItem;
import com.common.model.vendor.Vendor;
import com.common.security.UserContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MenuServiceImpl implements MenuService {

    private final JwtUtil jwtUtil;
    private final VendorDao vendorDao;
    private final MenuDao menuDao;

    public MenuServiceImpl(JwtUtil jwtUtil, VendorDao vendorDao, MenuDao menuDao) {
        this.jwtUtil = jwtUtil;
        this.vendorDao = vendorDao;
        this.menuDao = menuDao;
    }

    @Override
    public MenuResponse create(UUID vendorId, MenuRequest menuRequest) {
        Vendor vendor = vendorDao.findById(vendorId)
                .orElseThrow(() -> new VendorNotFoundException("No Vendor with id: " + vendorId));

        UserContext userContext = jwtUtil.getUserDetails();

        MenuItem menuItem = MenuConverter.requestToEntity(null, menuRequest);
        menuItem.setVendor(vendor);
        menuItem = menuDao.save(menuItem);

        return MenuConverter.entityToResponse(menuItem);
    }

    @Override
    public MenuResponse update(UUID menuItemId, MenuRequest menuRequest) {
        MenuItem menuItem = getMenuItem(menuItemId);
        UserContext userContext = jwtUtil.getUserDetails();

        MenuConverter.requestToEntity(menuItem, menuRequest);
        menuItem = menuDao.save(menuItem);

        return MenuConverter.entityToResponse(menuItem);
    }

    @Override
    public MenuResponse readMenuItem(UUID menuItemId) {
        MenuItem menuItem = getMenuItem(menuItemId);
        return MenuConverter.entityToResponse(menuItem);
    }

    @Override
    public List<MenuResponse> readVendorMenuItems(UUID vendorId) {
        List<MenuItem> menuItems = menuDao.findByVendorId(vendorId);
        return MenuConverter.entityToResponseList(menuItems);
    }

    @Override
    public MenuResponse delete(UUID menuItemId) {
        MenuItem menuItem = getMenuItem(menuItemId);
        menuDao.deleteById(menuItemId);
        return MenuConverter.entityToResponse(menuItem);
    }

    @Override
    public List<MenuResponse> deleteMenuItems(UUID vendorId) {
        List<MenuItem> menuItems = getMenuItems(vendorId);
        menuDao.deleteByVendorId(vendorId);
        return MenuConverter.entityToResponseList(menuItems);
    }

    private MenuItem getMenuItem(UUID menuItemId) {
        return menuDao.findById(menuItemId)
                .orElseThrow(() -> {throw new VendorNotFoundException("Menu Item does not exist");});
    }

    private List<MenuItem> getMenuItems(UUID vendorId) {
        return menuDao.findByVendorId(vendorId);
    }
}
