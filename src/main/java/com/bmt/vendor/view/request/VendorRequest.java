package com.bmt.vendor.view.request;

import com.common.model.vendor.VendorType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class VendorRequest {
    private String name;
    private VendorType vendorType;
    private String description;
    private String logoUrl;
    @Pattern(regexp = "\\d{10}", message = "Mobile must be 10-digit number")
    private String phone;
    @Email(message = "Please provide valid Email.")
    private String email;
    private Integer capacityMin;
    private Integer capacityMax;
}
