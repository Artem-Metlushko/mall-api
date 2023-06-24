CREATE TABLE `category`
(
    `category_id`   bigint NOT NULL AUTO_INCREMENT,
    `description`  varchar(255) DEFAULT NULL,
    `image`        varchar(255) DEFAULT NULL,
    `name`         varchar(255) DEFAULT NULL,
    `product_count` int          DEFAULT NULL,
    `rating`       double       DEFAULT NULL,
    PRIMARY KEY (`category_id`)
);
