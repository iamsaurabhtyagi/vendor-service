CREATE TABLE vendor_menu_categories (
    id CHAR(36) PRIMARY KEY,
    vendor_id CHAR(36) NOT NULL,
    category_name VARCHAR(100) NOT NULL,  -- e.g. 'North Indian', 'Chinese', 'Veg'
    FOREIGN KEY (vendor_id) REFERENCES vendors(id)
);

CREATE TABLE vendor_menu_items (
    id CHAR(36) PRIMARY KEY,
    category_id CHAR(36) NOT NULL,
    item_name VARCHAR(255) NOT NULL,       -- e.g. 'Paneer Butter Masala'
    description TEXT,
    price DECIMAL(10,2),                   -- optional, per plate/serving
    is_available BOOLEAN DEFAULT TRUE,     -- availability flag
    FOREIGN KEY (category_id) REFERENCES vendor_menu_categories(id)
);