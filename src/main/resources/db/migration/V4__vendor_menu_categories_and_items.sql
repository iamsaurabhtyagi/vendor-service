CREATE TABLE cuisine_type (
    id CHAR(36) PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,   -- e.g., "Veg", "Non-Veg", "Eggetarian", "Jain"
    description VARCHAR(255)
);

CREATE TABLE menu_categories (
    id CHAR(36) PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL,  -- e.g. 'Breakfast', 'Lunch', 'Dinner'
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE menu_items (
    id CHAR(36) PRIMARY KEY,
    vendor_id CHAR(36) NOT NULL,
    category VARCHAR(255) NOT NULL,
    cuisine_type VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,       -- e.g. 'Paneer Butter Masala'
    description TEXT,
    price DECIMAL(10,2),                   -- optional, per plate/serving
    is_available BOOLEAN DEFAULT TRUE,     -- availability flag
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (vendor_id) REFERENCES vendors(id)
);

CREATE TABLE menu_item_history (
    id CHAR(36) PRIMARY KEY,
    menu_item_id CHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    old_price DECIMAL(10,2),
    new_price DECIMAL(10,2),
    changed_by CHAR(36) NOT NULL, -- user_id
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (menu_item_id) REFERENCES menu_items(id)
);