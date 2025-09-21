package com.bmt.vendor.view.response;

import com.common.model.vendor.CuisineType;
import com.common.model.vendor.MenuCategory;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MenuResponse {
    private MenuCategory category;
    private CuisineType cuisineType;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean isAvailable = true;
    private LocalDateTime createdAt;
}
