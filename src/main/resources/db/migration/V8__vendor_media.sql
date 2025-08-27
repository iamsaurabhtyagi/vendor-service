CREATE TABLE vendor_media (
    id CHAR(36) PRIMARY KEY,
    vendor_id CHAR(36) NOT NULL,

    media_type VARCHAR(500), -- ENUM('PHOTO','VIDEO'),
    url VARCHAR(500) NOT NULL,
    description VARCHAR(255),

    FOREIGN KEY (vendor_id) REFERENCES vendors(id) ON DELETE CASCADE
);