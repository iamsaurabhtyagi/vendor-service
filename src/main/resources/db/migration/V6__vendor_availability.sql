CREATE TABLE vendor_availability (
    id CHAR(36) PRIMARY KEY,
    vendor_id CHAR(36) NOT NULL,

    day_of_week VARCHAR(50), -- ENUM('MON','TUE','WED','THU','FRI','SAT','SUN'),
    open_time TIME,
    close_time TIME,
    seasonal_note VARCHAR(255),

    FOREIGN KEY (vendor_id) REFERENCES vendors(id) ON DELETE CASCADE
);