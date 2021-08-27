CREATE TABLE places(
    place_id BIGINT NOT NULL AUTO_INCREMENT,
    place_name VARCHAR(255) NOT NULL,
    place_desc TEXT,

    is_trunk TINYINT(1),

    latitude DECIMAL(16,14),
    longitude DECIMAL(17,14),

    address1 VARCHAR(100),
    address2 VARCHAR(100),

    area_id BIGINT,
    subarea_id BIGINT,

    view_cnt BIGINT DEFAULT 0,
    scrap_cnt BIGINT DEFAULT 0,

    score BIGINT DEFAULT 0,

    created_at DATETIME NOT NULL DEFAULT NOW(),
    updated_at DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY (place_id)
)

ALTER TABLE places MODIFY COLUMN latitude DECIMAL(16,14);
ALTER TABLE places MODIFY COLUMN longitude DECIMAL(17,14);

#지역 정보 - 계층구조
CREATE TABLE areas(
    area_id BIGINT NOT NULL AUTO_INCREMENT,
    parent_area_id BIGINT,
    area_code VARCHAR(100),
    area_name VARCHAR(100),
    PRIMARY KEY (area_id)
)

CREATE TABLE place_images(
    place_image_id BIGINT NOT NULL AUTO_INCREMENT,
    place_id BIGINT NOT NULL,
    image_seq INT(2)
)

filter_type : CAMPING_TYPE, PLACE_TYPE, SCALE, COST, FACILITY

CREATE TABLE place_filter_attributes(
    filter_attr_id BIGINT NOT NULL AUTO_INCREMENT,
    filter_name VARCHAR(100) NOT NULL,
    filter_type VARCHAR(100) NOT NULL,
    display_name VARCHAR(100) NOT NULL,
    createdAt DATETIME NOT NULL DEFAULT NOW(),
    updatedAt DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY (filter_attr_id),
    INDEX `place_filter_attributes_idx0` (`filter_name`),
    INDEX `place_filter_attributes_idx1` (`filter_type`),
    INDEX `place_filter_attributes_idx2` (`updatedAt`)
)

INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('CAR_CAMP','CAMPING_TYPE');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('CAR_PICNIC','CAMPING_TYPE');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('AUTO_CAMPING','CAMPING_TYPE');

INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('MOUNTAIN','PLACE_TYPE');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('SEA','PLACE_TYPE');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('VALLEY','PLACE_TYPE');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('RESERVOIR','PLACE_TYPE');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('RIVER','PLACE_TYPE');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('LAKE','PLACE_TYPE');

INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('MORE THAN 100 CARS','SCALE');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('30000','COST');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('RESTROOM','FACILITY');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('COOK','FACILITY');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('WATER','FACILITY');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('STORE','FACILITY');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('TRAIL','FACILITY');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('ELECTRICITY','FACILITY');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('HOT_WATER','FACILITY');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('SHOWER','FACILITY');
INSERT INTO place_filter_attributes(filter_name,filter_type) VALUES ('PET','FACILITY');

CREATE TABLE place_score_attributes(
    score_filter_attr_id BIGINT NOT NULL AUTO_INCREMENT,
    place_id BIGINT NOT NULL,
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

INSERT INTO place_score_attributes( place_id, level_score, facilities_score, view_score, accessibility_score, roughness_score, crowding_score, createdAt, updatedAt)
VALUES (1,10,10,10,10,10,10, now(),now());

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
            (6371*acos(cos(radians(37.4485225))*cos(radians(latitude))*cos(radians(longitude)-radians(126.8943311))+sin(radians(37.4485225))*sin(radians(latitude))))
            AS distance
FROM places p 
INNER JOIN areas a ON p.area_id = a.area_id 
INNER JOIN areas a2 ON p.subarea_id = a2.area_id
HAVING distance <= 10
ORDER BY distance 
LIMIT 0,300


insert into places(place_name,place_desc,latitude,longitude,address1,address2,area_id,subarea_id,createdAt,updatedAt) values('jinhan home', 'desc',37.46852250,126.8943311,'addr','addr2',1,1,now(),now());
Query OK, 1 row affected (0.01 sec)