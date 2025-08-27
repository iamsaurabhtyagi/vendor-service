CREATE TABLE vendor_licenses (
    id CHAR(36) PRIMARY KEY ,
    vendor_id CHAR(36) NOT NULL,

    license_type VARCHAR(100), -- ENUM('FSSAI','ALCOHOL','FIRE_SAFETY','OTHER'),
    license_number VARCHAR(100),
    valid_until DATE,

    FOREIGN KEY (vendor_id) REFERENCES vendors(id) ON DELETE CASCADE
);