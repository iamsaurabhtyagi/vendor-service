package com.bmt.vendor.view.request;

import com.common.model.vendor.CuisineType;
import com.common.model.vendor.MenuCategory;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MenuRequest {
    private MenuCategory category;
    private CuisineType cuisineType;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean available;
}
