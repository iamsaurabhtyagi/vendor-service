package com.bmt.vendor.view.response;

import lombok.Data;

import java.util.UUID;

@Data
public class UserResponse {
    private UUID userId;
    private String username;
    private String userType;
    private String userCategory;
    private boolean active;
}
