package com.bmt.vendor.converter;

import com.bmt.vendor.view.request.MenuRequest;
import com.bmt.vendor.view.response.MenuResponse;
import com.common.model.vendor.MenuItem;

import java.util.List;

public class MenuConverter {
    public static MenuItem requestToEntity(MenuItem menuItem, MenuRequest menuRequest) {
        if(menuItem == null)
            menuItem = new MenuItem();

        if(menuRequest.getName() != null)
            menuItem.setName(menuRequest.getName());

        if(menuRequest.getDescription() != null)
            menuItem.setDescription(menuRequest.getDescription());

        if(menuRequest.getCategory() != null)
            menuItem.setCategory(menuRequest.getCategory());

        if(menuRequest.getCuisineType() != null)
            menuItem.setCuisineType(menuRequest.getCuisineType());

        if(menuRequest.getPrice() != null)
            menuItem.setPrice(menuRequest.getPrice());

        if(menuRequest.getAvailable() != null)
            menuItem.setAvailable(menuItem.isAvailable());
        else
            menuItem.setAvailable(true);

        return menuItem;
    }

    public static MenuResponse entityToResponse(MenuItem menuItem) {
        MenuResponse menuResponse = new MenuResponse();

        menuResponse.setId(menuItem.getId());
        menuResponse.setName(menuResponse.getName());
        menuResponse.setDescription(menuItem.getDescription());
        menuResponse.setCategory(menuItem.getCategory());
        menuResponse.setCuisineType(menuItem.getCuisineType());
        menuResponse.setPrice(menuItem.getPrice());
        menuResponse.setAvailable(menuItem.isAvailable());

        return menuResponse;
    }

    public static List<MenuResponse> entityToResponseList(List<MenuItem> menuItems) {
        return menuItems.stream()
                .map(MenuConverter::entityToResponse)
                .toList();
    }
}
