CREATE TABLE places(
    place_id BIGINT NOT NULL AUTO_INCREMENT,
    place_name VARCHAR(255) NOT NULL,
    place_desc TEXT,
    
    latitude DECIMAL(16,14),
    longitude DECIMAL(17,14),

    address1 VARCHAR(100),
    address2 VARCHAR(100),

    area_id BIGINT,
    subarea_id BIGINT,

    createdAt DATETIME NOT NULL DEFAULT NOW(),
    updatedAt DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY (place_id)
)

ALTER TABLE places MODIFY COLUMN latitude DECIMAL(16,14);
ALTER TABLE places MODIFY COLUMN longitude DECIMAL(17,14);

#지역 정보 - 계층구조
CREATE TABLE areas(
    area_id BIGINT NOT NULL AUTO_INCREMENT,
    parent_area_id BIGINT,
    area_name VARCHAR(100),
    PRIMARY KEY (area_id)
)

INSERT INTO areas(area_name)

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
    PRIMARY KEY (score_filter_attr_id)
)

SELECT *,
	(6371*acos(cos(radians(37.4685225))*cos(radians(latitude))*cos(radians(longitude)
	-radians(126.8943311))+sin(radians(37.4685225))*sin(radians(latitude))))
	AS distance
FROM places
HAVING distance <= 0.3
ORDER BY distance 
LIMIT 0,300

update places set latitude=37.4685225, longitude=126.8943311 WHERE place_id=1;


SELECT place_id, place_name, place_desc, latitude, longitude, address1, address2,
            a.area_id as area_id, a.area_name as area_name,
            a2.area_id as subarea_id, a2.area_name as subarea_name,
            createdAt, updatedAt,
            (6371*acos(cos(radians(37.4685225))*cos(radians(latitude))*cos(radians(longitude)-radians(126.8943311))+sin(radians(37.4685225))*sin(radians(latitude))))
            AS distance
FROM places p 
INNER JOIN areas a ON p.area_id = a.area_id 
INNER JOIN areas a2 ON p.subarea_id = a2.area_id
HAVING distance <= 0.3
ORDER BY distance 
LIMIT 0,300
