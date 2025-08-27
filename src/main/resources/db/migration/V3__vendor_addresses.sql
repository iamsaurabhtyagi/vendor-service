CREATE TABLE vendor_addresses (
    id CHAR(36) PRIMARY KEY,
    vendor_id CHAR(36) NOT NULL,

    full_address VARCHAR(500) NOT NULL,
    city VARCHAR(100),
    state VARCHAR(100),
    pin_code VARCHAR(20),
    google_map_url VARCHAR(500),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (vendor_id) REFERENCES vendors(id) ON DELETE CASCADE
);