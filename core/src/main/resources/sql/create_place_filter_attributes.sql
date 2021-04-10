CREATE TABLE place_filter_attributes(
    filter_attr_id BIGINT NOT NULL AUTO_INCREMENT,
    filter_name VARCHAR(255) NOT NULL,
    createdAt DATETIME NOT NULL DEFAULT NOW(),
    updatedAt DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY (filter_attr_id)
)