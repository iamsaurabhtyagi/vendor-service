CREATE TABLE vendor_users (
    id CHAR(36) PRIMARY KEY,
    vendor_id CHAR(36) NOT NULL,
    user_id CHAR(36) NOT NULL, -- user-service DB
    role VARCHAR(100), -- ENUM('OWNER','MANAGER','STAFF') DEFAULT 'OWNER',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (vendor_id) REFERENCES vendors(id) ON DELETE CASCADE
);