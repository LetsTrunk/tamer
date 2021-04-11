CREATE TABLE places(
    place_id BIGINT NOT NULL AUTO_INCREMENT,
    place_name VARCHAR(255) NOT NULL,
    place_desc TEXT,
    
    latitude BIGINT,
    longitude BIGINT,

    address1 VARCHAR(100),
    address2 VARCHAR(100),

    area_id BIGINT,
    subarea_id BIGINT,

    createdAt DATETIME NOT NULL DEFAULT NOW(),
    updatedAt DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY (place_id)
)

CREATE TABLE place_images(
    place_image_id BIGINT NOT NULL AUTO_INCREMENT,
    place_id BIGINT NOT NULL,
    image_seq INT(2)
)


CREATE TABLE place_filter_attributes(
    filter_attr_id BIGINT NOT NULL AUTO_INCREMENT,
    filter_name VARCHAR(255) NOT NULL,
    createdAt DATETIME NOT NULL DEFAULT NOW(),
    updatedAt DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY (filter_attr_id)
)

CREATE TABLE place_score_attributes(
    score_filter_attr_id BIGINT NOT NULL AUTO_INCREMENT,
    place_id BIGINT NOT NULL, 
    is_trunk TINYINT(1),

    level_score INT(10) UNSIGNED,
    facilities_score INT(10) UNSIGNED,
    view_score INT(10) UNSIGNED,
    accessibility_score INT(10) UNSIGNED,
    roughness_score INT(10) UNSIGNED,
    crowding_score INT(10) UNSIGNED,

    createdAt DATETIME NOT NULL DEFAULT NOW(),
    updatedAt DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY (review_filter_attr_id)
)