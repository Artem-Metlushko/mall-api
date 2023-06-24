CREATE TABLE `product`
(
    `product_id`    bigint NOT NULL AUTO_INCREMENT,
    `name`         varchar(255) DEFAULT NULL,
    `price`        double       DEFAULT NULL,
    `description`  varchar(255) DEFAULT NULL,
    `category_id`   bigint       DEFAULT NULL,
    PRIMARY KEY (`product_id`),
    CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
);
