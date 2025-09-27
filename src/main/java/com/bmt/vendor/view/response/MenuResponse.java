package com.bmt.vendor.view.response;

import com.common.model.vendor.CuisineType;
import com.common.model.vendor.MenuCategory;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MenuResponse {
    private UUID id;
    private MenuCategory category;
    private CuisineType cuisineType;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean available = true;
    private LocalDateTime createdAt;
}
