package com.bmt.vendor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {

    @GetMapping("/get")
    public String get() {
        return "Hello Vendor";
    }
}
