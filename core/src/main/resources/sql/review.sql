CREATE TABLE place_reviews(
    `place_review_id`       BIGINT(20)      NOT NULL    AUTO_INCREMENT,
    `place_id`              BIGINT(20)      NOT NULL    COMMENT '리뷰 대상 장소',
    `review_score`          INT(2)          NOT NULL    COMMENT '1,2,3점 각 별로예요 그럭저럭 훌륭해요',
    `contents`              VARCHAR(300)    NOT NULL    COMMENT '리뷰 내용',
    `createdBy`             BIGINT(20)      NOT NULL    COMMENT '작성자 Id',
    `createdAt`             DATETIME(6)     NOT NULL    DEFAULT NOW(),
    `updatedAt`             DATETIME(6)     NOT NULL    DEFAULT NOW(),
    PRIMARY KEY (`place_review_id`)
    INDEX `place_reviews_idx0` (`updatedAt`)

)

CREATE TABLE place_review_images(
    `place_review_image_id`         BIGINT(20)      NOT NULL        AUTO_INCREMENT,
    `place_review_id`               BIGINT(20)      NOT NULL        COMMENT '리뷰 번호',
    `place_review_image_url`        VARCHAR(100)    NOT NULL        COMMENT '리뷰 이미지 주소',
    `main_yn`                       TINYINT(1)      NOT NULL        DEFAULT 0
    PRIMARY KEY (`place_review_images_id`)
    INDEX `place_review_images_idx0` (`place_review_id`)
    INDEX `place_review_images_idx1` (`main_yn`)
)