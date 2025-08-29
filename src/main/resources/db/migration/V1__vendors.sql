CREATE TABLE vendors (
    id CHAR(36) PRIMARY KEY,
    user_id CHAR(36) NOT NULL, -- user-service DB
    name VARCHAR(255) NOT NULL,
    description TEXT,
    logo_url VARCHAR(500),

    phone VARCHAR(20),
    email VARCHAR(100),

    status VARCHAR(20),

    capacity_min INT,
    capacity_max INT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);