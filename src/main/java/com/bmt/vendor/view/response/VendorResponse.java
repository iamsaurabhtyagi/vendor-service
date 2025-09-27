package com.bmt.vendor.view.response;

import lombok.Data;

import java.util.UUID;

@Data
public class VendorResponse {
    private UUID id;
    private String name;
    private String description;
    private String logoUrl;
    private String phone;
    private String email;
    private Integer capacityMin;
    private Integer capacityMax;
}
