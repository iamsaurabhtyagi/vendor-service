package com.bmt.vendor.util.converter;

import com.bmt.vendor.view.request.MenuRequest;
import com.common.model.vendor.MenuItem;

public class MenuConverter {
    public static MenuItem requestToEntity(MenuRequest menuRequest) {
        MenuItem menuItem = new MenuItem();

        menuItem.setName(menuRequest.getName());
        menuItem.setDescription(menuRequest.getDescription());
        menuItem.setCategory(menuRequest.getCategory());
        menuItem.setCuisineType(menuRequest.getCuisineType());
        menuItem.setPrice(menuRequest.getPrice());
        menuItem.setIsAvailable(true);

        return menuItem;
    }
}
