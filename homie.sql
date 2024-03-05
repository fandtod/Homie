CREATE DATABASE `homie`;

-- 1.使用者user_info
CREATE TABLE `user_info` (
   `user_id` int NOT NULL AUTO_INCREMENT COMMENT '使用者編號',
   `user_account` varchar(50) NOT NULL COMMENT '使用者帳號',
   `user_password` varchar(20) NOT NULL COMMENT '使用者密碼',
   `user_pic` blob COMMENT '使用者大頭照',
   `garbage_coin` int NOT NULL DEFAULT '0' COMMENT '垃圾幣',
   `seller_identity` int NOT NULL DEFAULT '0' COMMENT '賣家身份',
   `user_name` varchar(50) DEFAULT NULL COMMENT '使用者姓名',
   `user_address` varchar(100) DEFAULT NULL COMMENT '使用者地址',
   `user_phone` varchar(50) DEFAULT NULL COMMENT '使用者電話',
   `user_gender` int DEFAULT NULL COMMENT '使用者性別',
   `user_ic` varchar(10) DEFAULT NULL COMMENT '使用者身分證',
   PRIMARY KEY (`user_id`),
   UNIQUE KEY `user_account` (`user_account`),
   UNIQUE KEY `user_ic` (`user_ic`)
 ) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='使用者';
 
 -- 2.賣家seller
 CREATE TABLE `seller` (
   `seller_id` int NOT NULL AUTO_INCREMENT COMMENT '賣家編號',
   `user_id` int NOT NULL COMMENT '使用者編號',
   `seller_pcrc` blob NOT NULL COMMENT '良民證',
   `bank_code` int NOT NULL COMMENT '銀行代碼',
   `bank_account` varchar(50) NOT NULL COMMENT '銀行帳號',
   `bank_holder_name` varchar(100) NOT NULL COMMENT '銀行戶名',
   `total_review_count` int NOT NULL COMMENT '評價總人數',
   `total_review_stars` int NOT NULL COMMENT '評價總星數',
   PRIMARY KEY (`seller_id`),
   KEY `seller_user_info_user_id_idx` (`user_id`),
   CONSTRAINT `seller_user_info_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='賣家';
 
 -- 3.地區area
 CREATE TABLE `area` (
   `area_id` int NOT NULL AUTO_INCREMENT COMMENT '地區編號',
   `user_id` int NOT NULL COMMENT '使用者編號',
   `area_name` varchar(50) NOT NULL COMMENT '地區名稱',
   PRIMARY KEY (`area_id`),
   KEY `area_user_info_user_id_idx` (`user_id`),
   CONSTRAINT `area_user_info_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='地區';
 
 -- 4.員工emp
 CREATE TABLE `emp` (
   `emp_id` int NOT NULL AUTO_INCREMENT COMMENT '員工編號/帳號',
   `emp_password` char(20) NOT NULL COMMENT '員工密碼',
   `emp_name` varchar(50) NOT NULL COMMENT '員工姓名',
   PRIMARY KEY (`emp_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='員工';
 
 -- 5.公告announcement
 CREATE TABLE `announcement` (
   `article_id` int NOT NULL AUTO_INCREMENT COMMENT '文章編號',
   `emp_id` int NOT NULL COMMENT '員工編號',
   `upload_date` timestamp NOT NULL COMMENT '文章日期',
   `article_title` varchar(50) NOT NULL COMMENT '文章標題',
   `article_content` text COMMENT '文章內容',
   PRIMARY KEY (`article_id`),
   KEY `announcement_emp_emp_id_idx` (`emp_id`),
   CONSTRAINT `announcement_emp_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `emp` (`emp_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='公告';
 
 -- 6.買賣家須知guideline
 CREATE TABLE `guideline` (
   `guideline_id` int NOT NULL AUTO_INCREMENT COMMENT '須知編號',
   `guideline_title` text NOT NULL COMMENT '須知標題',
   `guideline_content` text NOT NULL COMMENT '須知內文',
   `guideline_time` timestamp NOT NULL COMMENT '須知時間',
   PRIMARY KEY (`guideline_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='買賣家須知';
 
 -- 7.違規處理violation
 CREATE TABLE `violation` (
   `violation_id` int NOT NULL AUTO_INCREMENT COMMENT '違規編號',
   `user_id` int NOT NULL COMMENT '使用者編號(買家)',
   `user_id_seller` int NOT NULL COMMENT '使用者編號(賣家)',
   `report_direction` int NOT NULL COMMENT '檢舉方向',
   `violation_category` int NOT NULL COMMENT '違規類別',
   `violation_content` mediumtext NOT NULL COMMENT '違規內容',
   `violation_pic1` blob COMMENT '違規照片1',
   `violation_pic2` blob COMMENT '違規照片2',
   `violation_pic3` blob COMMENT '違規照片3',
   `violation_pic4` blob COMMENT '違規照片4',
   `violation_pic5` blob COMMENT '違規照片5',
   `violation_time` timestamp NOT NULL COMMENT '違規時間',
   `violation_status` int DEFAULT NULL COMMENT '違規狀態',
   PRIMARY KEY (`violation_id`),
   KEY `violation_user_info_user_id_idx` (`user_id`),
   KEY `violation_seller_user_id_idx` (`user_id_seller`),
   CONSTRAINT `violation_seller_user_id` FOREIGN KEY (`user_id_seller`) REFERENCES `seller` (`user_id`),
   CONSTRAINT `violation_user_info_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='違規處理';
 
 -- 8.服務訂單order_service
 CREATE TABLE `order_service` (
   `order_service_id` int NOT NULL AUTO_INCREMENT COMMENT '服務訂單編號',
   `user_id_seller` int NOT NULL COMMENT '使用者編號(賣家)',
   `user_id_buyer` int NOT NULL COMMENT '使用者編號(買家)',
   `order_quantity` int NOT NULL COMMENT '訂單數量',
   `order_status` int NOT NULL COMMENT '訂單狀態',
   `order_unit_price` int NOT NULL COMMENT '訂單單價',
   `order_total` int NOT NULL COMMENT '訂單總價',
   `order_placement_time` timestamp NULL DEFAULT NULL COMMENT '訂單成立時間',
   `order_service_finish_date` timestamp NULL DEFAULT NULL COMMENT '訂單完成日期',
   `order_add_gc` int NOT NULL COMMENT '增加GC',
   `order_deduct_gc` int NOT NULL COMMENT '扣除GC',
   `order_service_item` int NOT NULL COMMENT '訂單項目',
   `review_score` int DEFAULT NULL COMMENT '評價分數',
   `review_content` varchar(200) DEFAULT NULL COMMENT '評價內容',
   `review_time` timestamp NULL DEFAULT NULL COMMENT '評價時間',
   `refund_time` timestamp NULL DEFAULT NULL COMMENT '退款時間',
   PRIMARY KEY (`order_service_id`),
   KEY `order_service_user_info_user_id_idx` (`user_id_buyer`),
   KEY `order_service_seller_user_id_idx` (`user_id_seller`),
   CONSTRAINT `order_service_seller_user_id` FOREIGN KEY (`user_id_seller`) REFERENCES `seller` (`user_id`),
   CONSTRAINT `order_service_user_info_user_id` FOREIGN KEY (`user_id_buyer`) REFERENCES `user_info` (`user_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='服務訂單';
 
 -- 9.商品訂單order_product
 CREATE TABLE `order_product` (
   `order_product_id` int NOT NULL AUTO_INCREMENT COMMENT '商品訂單編號',
   `user_id` int NOT NULL COMMENT '使用者編號',
   `product_total` int NOT NULL COMMENT '商品總價',
   `product_status` int NOT NULL COMMENT '訂單狀態',
   `tracking_number` int DEFAULT NULL COMMENT '物流編號',
   `delivery_time` timestamp NULL DEFAULT NULL COMMENT '出貨時間',
   `arrival_time` timestamp NULL DEFAULT NULL COMMENT '到貨時間',
   `product_placement_time` timestamp NULL DEFAULT NULL COMMENT '訂單成立時間',
   `product_finish_date` timestamp NULL DEFAULT NULL COMMENT '訂單完成日期',
   `refund_time` timestamp NULL DEFAULT NULL COMMENT '退款時間',
   `order_product_unit_price` int NOT NULL COMMENT '訂單單價',
   `order_product_quantity` int NOT NULL COMMENT '訂單數量',
   `order_product_item` varchar(50) NOT NULL COMMENT '訂單項目',
   PRIMARY KEY (`order_product_id`),
   KEY `order_product_user_info_user_id_idx` (`user_id`),
   CONSTRAINT `order_product_user_info_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品訂單';
 
 -- 10.通知notification
 CREATE TABLE `notification` (
   `notification_id` int NOT NULL AUTO_INCREMENT COMMENT '通知編號',
   `user_id` int NOT NULL COMMENT '使用者編號',
   `violation_id` int DEFAULT NULL COMMENT '違規編號',
   `order_service_id` int DEFAULT NULL COMMENT '服務訂單編號',
   `order_product_id` int DEFAULT NULL COMMENT '商品訂單編號',
   `notification_content` text NOT NULL COMMENT '通知內容',
   `notification_time` timestamp NOT NULL COMMENT '通知時間',
   `is_read` tinyint(1) NOT NULL COMMENT '已讀未讀',
   PRIMARY KEY (`notification_id`),
   KEY `notification_user_info_user_id_idx` (`user_id`),
   KEY `notification_violation_violation_id_idx` (`violation_id`),
   KEY `notification_order_service_order_service_id_idx` (`order_service_id`),
   KEY `notification_order_product_order_product_id_idx` (`order_product_id`),
   CONSTRAINT `notification_order_product_order_product_id` FOREIGN KEY (`order_product_id`) REFERENCES `order_product` (`order_product_id`),
   CONSTRAINT `notification_order_service_order_service_id` FOREIGN KEY (`order_service_id`) REFERENCES `order_service` (`order_service_id`),
   CONSTRAINT `notification_user_info_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`),
   CONSTRAINT `notification_violation_violation_id` FOREIGN KEY (`violation_id`) REFERENCES `violation` (`violation_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='通知';
 
 -- 11.商品product
 CREATE TABLE `product` (
   `product_id` int NOT NULL AUTO_INCREMENT COMMENT '商品編號',
   `product_name` varchar(100) NOT NULL COMMENT '商品名稱',
   `product_price` int NOT NULL COMMENT '商品價格',
   `product_stock` int NOT NULL COMMENT '商品庫存',
   `product_shipped` int NOT NULL COMMENT '商品出貨數',
   `product_introduction` text COMMENT '商品介紹',
   `product_picture` mediumblob COMMENT '商品照片',
   `product_picture_name` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`product_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品';
 
 -- 12.商品訂單細節order_product_detail
 CREATE TABLE `order_product_detail` (
   `order_product_detail_id` int NOT NULL AUTO_INCREMENT COMMENT '商品訂單細節編號',
   `order_product_id` int NOT NULL COMMENT '商品訂單編號',
   `product_id` int NOT NULL COMMENT '商品編號',
   `product_quantity` int NOT NULL COMMENT '商品數量',
   `product_name` varchar(100) NOT NULL COMMENT '商品名稱',
   `product_price` int NOT NULL COMMENT '商品價格',
   `product_score` int DEFAULT NULL COMMENT '商品評價分數',
   `product_content` varchar(150) DEFAULT NULL COMMENT '商品評價內容',
   PRIMARY KEY (`order_product_detail_id`),
   KEY `order_product_detail_order_product_order_product_id_idx` (`order_product_id`),
   KEY `order_product_detail_product_product_id_idx` (`product_id`),
   CONSTRAINT `order_product_detail_order_product_order_product_id` FOREIGN KEY (`order_product_id`) REFERENCES `order_product` (`order_product_id`),
   CONSTRAINT `order_product_detail_product_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品訂單細節';
 
 -- 13.商品收藏product_collection
 CREATE TABLE `product_collection` (
   `product_collection_id` int NOT NULL AUTO_INCREMENT COMMENT '商品收藏編號',
   `user_id` int NOT NULL COMMENT '使用者編號',
   `product_id` int NOT NULL COMMENT '商品編號',
   `product_collection_time` timestamp NOT NULL COMMENT '收藏時間',
   PRIMARY KEY (`product_collection_id`),
   KEY `product_collection_user_info_user_id_idx` (`user_id`),
   KEY `product_collection_product_product_id_idx` (`product_id`),
   CONSTRAINT `product_collection_product_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
   CONSTRAINT `product_collection_user_info_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品收藏';
 
 -- 14.系統參數system_parameters
 CREATE TABLE `system_parameters` (
   `parameters_name` varchar(30) NOT NULL COMMENT '參數名稱',
   `parameters_value` int NOT NULL COMMENT '參數值'
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系統參數';
 
 -- 15.不服務時間unavailable_time
 CREATE TABLE `unavailable_time` (
   `unavailable_time_id` int NOT NULL AUTO_INCREMENT COMMENT '不服務時間編號',
   `user_id` int NOT NULL COMMENT '使用者編號',
   `undate` date NOT NULL COMMENT '日期',
   `morning` int NOT NULL DEFAULT '0' COMMENT '早上',
   `afternoon` int NOT NULL DEFAULT '0' COMMENT '下午',
   `night` int NOT NULL DEFAULT '0' COMMENT '晚上',
   PRIMARY KEY (`unavailable_time_id`),
   KEY `unavailable_time_seller_idx` (`user_id`),
   CONSTRAINT `unavailable_time_seller_user_id` FOREIGN KEY (`user_id`) REFERENCES `seller` (`user_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='不服務時間';
 
 -- 16.服務service
 CREATE TABLE `service` (
   `service_id` int NOT NULL AUTO_INCREMENT COMMENT '服務編號',
   `service_code` int NOT NULL COMMENT '服務代碼',
   `user_id` int NOT NULL COMMENT '使用者編號',
   `service_name` varchar(50) NOT NULL COMMENT '服務名稱',
   `service_price` int NOT NULL COMMENT '服務價格',
   `service_introduction` text COMMENT '服務介紹',
   `service_picture` mediumblob COMMENT '服務照片',
   `banner` tinyint(1) NOT NULL DEFAULT '0' COMMENT '首頁曝光',
   PRIMARY KEY (`service_id`),
   KEY `service_seller_user_id_idx` (`user_id`),
   CONSTRAINT `service_seller_user_id` FOREIGN KEY (`user_id`) REFERENCES `seller` (`user_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='服務';
 
 -- 17.首頁廣告advertise
 CREATE TABLE `advertise` (
   `advertise_id` int NOT NULL AUTO_INCREMENT COMMENT '廣告編號',
   `service_id` int NOT NULL COMMENT '服務編號',
   `advertise_start_time` timestamp NULL DEFAULT NULL COMMENT '廣告開始時間',
   `advertise_end_time` timestamp NULL DEFAULT NULL COMMENT '廣告結束時間',
   `advertise_picture_name` varchar(50) DEFAULT NULL COMMENT '廣告圖片名稱',
   PRIMARY KEY (`advertise_id`),
   KEY `advertise_service_service_id_idx` (`service_id`),
   CONSTRAINT `advertise_service_service_id` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='首頁廣告';
 
 -- 18.服務收藏service_collection
 CREATE TABLE `service_collection` (
   `service_collection_id` int NOT NULL AUTO_INCREMENT COMMENT '服務收藏編號',
   `user_id` int NOT NULL COMMENT '使用者編號',
   `service_id` int NOT NULL COMMENT '服務編號',
   `service_collection_time` timestamp NOT NULL COMMENT '服務收藏時間',
   PRIMARY KEY (`service_collection_id`),
   KEY `service_collection_user_info_user_id_idx` (`user_id`),
   KEY `service_collection_service_service_id_idx` (`service_id`),
   CONSTRAINT `service_collection_service_service_id` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`),
   CONSTRAINT `service_collection_user_info_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='服務收藏';
 
 -- 19.購物車cart
 CREATE TABLE `cart` (
   `user_id` int NOT NULL COMMENT '使用者編號',
   `product_id` int NOT NULL COMMENT '商品編號',
   `cart_name` varchar(100) NOT NULL COMMENT '商品名稱',
   `cart_price` int NOT NULL COMMENT '商品價格',
   `cart_num` int NOT NULL COMMENT '商品數量',
   `cart_introduction` text COMMENT '商品介紹',
   `cart_picture` mediumblob COMMENT '商品照片',
   `isChecked` tinyint(1) NOT NULL DEFAULT '0' COMMENT '勾選',
   `cart_picture_name` varchar(50) DEFAULT NULL,
   PRIMARY KEY (`user_id`,`product_id`),
   KEY `cart_user_info_user_id_idx` (`user_id`),
   KEY `cart_product_product_id_idx` (`product_id`),
   CONSTRAINT `cart_product_product_id_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
   CONSTRAINT `cart_user_info_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='購物車';
 
 insert into product values(1,'清潔液',399,10,5,'【CLEAN HOUSE】泡沫洗手慕斯 青檸橙香','C:/sts4-workspace/homie-demo/src/main/resources/static/assets/images/kitchen_goods_1.jpg','kitchen_goods_1');
insert into product values(2,'洗衣精',599,10,5,'【CLEAN HOUSE】溫和潤膚洗手液-清潔滋潤雙重呵','C:/sts4-workspace/homie-demo/src/main/resources/static/assets/images/kitchen_goods_2.jpg','kitchen_goods_2');
insert into product values(3,'馬桶刷',600,10,5,'【CLEAN HOUSE】橄欖溫和洗手液500ml','C:/sts4-workspace/homie-demo/src/main/resources/static/assets/images/kitchen_goods_3.jpg','kitchen_goods_3');
insert into product values(4,'清潔液',799,10,5,'【CLEAN HOUSE】義大利進口有機香氛洗手液500ml','C:/sts4-workspace/homie-demo/src/main/resources/static/assets/images/kitchen_goods_4.jpg','kitchen_goods_4');
insert into product values(5,'洗衣精',350,10,5,'【CLEAN HOUSE】抗菌清潔洗手液-綠茶萃取250ml','C:/sts4-workspace/homie-demo/src/main/resources/static/assets/images/kitchen_goods_5.jpg','kitchen_goods_5');
insert into product values(6,'馬桶刷',625,10,5,'【CLEAN HOUSE】防護三氯生殺菌洗手液500ml','C:/sts4-workspace/homie-demo/src/main/resources/static/assets/images/kitchen_goods_6.jpg','kitchen_goods_6');
insert into product values(7,'漂白水',835,10,5,'【CLEAN HOUSE】防護三氯生殺菌洗手液500ml','C:/sts4-workspace/homie-demo/src/main/resources/static/assets/images/kitchen_goods_7.jpg','kitchen_goods_7');
insert into product values(8,'玻璃刷',999,10,5,'【CLEAN HOUSE】無患子茶樹精油抗菌洗手乳310g','C:/sts4-workspace/homie-demo/src/main/resources/static/assets/images/kitchen_goods_8.jpg','kitchen_goods_8');
insert into product values(9,'馬桶刷',800,10,5,'【CLEAN HOUSE】茶樹乾洗手淨化型噴霧 90ml','C:/sts4-workspace/homie-demo/src/main/resources/static/assets/images/kitchen_goods_9.jpg','kitchen_goods_9');
insert into product values(10,'漂白水',230,10,5,'【CLEAN HOUSE】75%酒精乾洗手100ml','C:/sts4-workspace/homie-demo/src/main/resources/static/assets/images/kitchen_goods_10.jpg','kitchen_goods_10');
insert into product values(11,'玻璃刷',199,10,5,'【CLEAN HOUSE】蘆薈乾洗手凝露 354ml ','C:/sts4-workspace/homie-demo/src/main/resources/static/assets/images/kitchen_goods_11.jpg','kitchen_goods_11');
insert into product values(12,'玻璃刷',650,10,5,'【CLEAN HOUSE】普瑞來乾洗手凝露隨身瓶(30ml)','C:/sts4-workspace/homie-demo/src/main/resources/static/assets/images/kitchen_goods_12.jpg','kitchen_goods_12');

INSERT INTO `homie`.`order_service` (`order_service_id`, `user_id_seller`, `user_id_buyer`, `order_quantity`, `order_status`, `order_unit_price`, `order_total`, `order_placement_time`, `order_service_finish_date`, `order_add_gc`, `order_deduct_gc`, `order_service_item`, `review_score`, `review_content`, `review_time`, `refund_time`) VALUES ('2', '8', '1', '1', '2', '233', '211', '2024-01-23 00:00:00', '2024-02-28 00:00:00', '1', '0', '1', '1', '普通', '2023-01-22 00:00:00', '2023-01-22 00:00:00');
INSERT INTO `homie`.`order_service` (`order_service_id`, `user_id_seller`, `user_id_buyer`, `order_quantity`, `order_status`, `order_unit_price`, `order_total`, `order_placement_time`, `order_service_finish_date`, `order_add_gc`, `order_deduct_gc`, `order_service_item`, `review_score`, `review_content`, `review_time`, `refund_time`) VALUES ('3', '8', '1', '1', '2', '100', '100', '2024-01-22 00:00:00', '2024-01-22 00:00:00', '1', '0', '1', '1', '還行', '2023-01-22 00:00:00', '2023-01-22 00:00:00');
INSERT INTO `homie`.`order_service` (`order_service_id`, `user_id_seller`, `user_id_buyer`, `order_quantity`, `order_status`, `order_unit_price`, `order_total`, `order_placement_time`, `order_service_finish_date`, `order_add_gc`, `order_deduct_gc`, `order_service_item`, `review_score`, `review_content`, `review_time`, `refund_time`) VALUES ('6', '8', '1', '1', '2', '322', '133', '2024-10-22 00:00:00', '2024-03-22 00:00:00', '1', '0', '1', '1', '可以', '2023-01-22 00:00:00', '2023-01-22 00:00:00');
INSERT INTO `homie`.`order_service` (`order_service_id`, `user_id_seller`, `user_id_buyer`, `order_quantity`, `order_status`, `order_unit_price`, `order_total`, `order_placement_time`, `order_service_finish_date`, `order_add_gc`, `order_deduct_gc`, `order_service_item`, `review_score`, `review_content`, `review_time`, `refund_time`) VALUES ('7', '8', '1', '1', '2', '123', '123', '2024-10-22 00:00:00', '2024-05-22 00:00:00', '1', '0', '1', '1', '不行', '2023-01-22 00:00:00', '2023-01-22 00:00:00');
INSERT INTO `homie`.`order_service` (`order_service_id`, `user_id_seller`, `user_id_buyer`, `order_quantity`, `order_status`, `order_unit_price`, `order_total`, `order_placement_time`, `order_service_finish_date`, `order_add_gc`, `order_deduct_gc`, `order_service_item`, `review_score`, `review_content`, `review_time`, `refund_time`) VALUES ('16', '8', '1', '1', '2', '599', '599', '2024-10-22 00:00:00', '2024-06-22 00:00:00', '1', '0', '1', '1', '可以增加商品', '2023-01-22 00:00:00', '2023-01-22 00:00:00');
INSERT INTO `homie`.`order_service` (`order_service_id`, `user_id_seller`, `user_id_buyer`, `order_quantity`, `order_status`, `order_unit_price`, `order_total`, `order_placement_time`, `order_service_finish_date`, `order_add_gc`, `order_deduct_gc`, `order_service_item`, `review_score`, `review_content`, `review_time`, `refund_time`) VALUES ('17', '8', '1', '1', '2', '1000', '1000', '2024-10-22 00:00:00', '2024-07-22 00:00:00', '1', '0', '1', '1', '讚', '2023-01-22 00:00:00', '2023-01-22 00:00:00');
INSERT INTO `homie`.`order_service` (`order_service_id`, `user_id_seller`, `user_id_buyer`, `order_quantity`, `order_status`, `order_unit_price`, `order_total`, `order_placement_time`, `order_service_finish_date`, `order_add_gc`, `order_deduct_gc`, `order_service_item`, `review_score`, `review_content`, `review_time`, `refund_time`) VALUES ('18', '8', '1', '1', '2', '2064', '2064', '2024-10-22 00:00:00', '2024-08-22 00:00:00', '1', '0', '1', '1', '普通', '2023-01-22 00:00:00', '2023-01-22 00:00:00');
INSERT INTO `homie`.`order_service` (`order_service_id`, `user_id_seller`, `user_id_buyer`, `order_quantity`, `order_status`, `order_unit_price`, `order_total`, `order_placement_time`, `order_service_finish_date`, `order_add_gc`, `order_deduct_gc`, `order_service_item`, `review_score`, `review_content`, `review_time`, `refund_time`) VALUES ('19', '8', '1', '1', '2', '4999', '4999', '2024-10-22 00:00:00', '2024-09-22 00:00:00', '1', '0', '1', '1', '待加強', '2023-01-22 00:00:00', '2023-01-22 00:00:00');
INSERT INTO `homie`.`order_service` (`order_service_id`, `user_id_seller`, `user_id_buyer`, `order_quantity`, `order_status`, `order_unit_price`, `order_total`, `order_placement_time`, `order_service_finish_date`, `order_add_gc`, `order_deduct_gc`, `order_service_item`, `review_score`, `review_content`, `review_time`, `refund_time`) VALUES ('20', '8', '1', '1', '2', '242', '242', '2024-10-22 00:00:00', '2024-10-22 00:00:00', '1', '0', '1', '1', '商品瑕疵', '2023-01-22 00:00:00', '2023-01-22 00:00:00');
INSERT INTO `homie`.`order_service` (`order_service_id`, `user_id_seller`, `user_id_buyer`, `order_quantity`, `order_status`, `order_unit_price`, `order_total`, `order_placement_time`, `order_service_finish_date`, `order_add_gc`, `order_deduct_gc`, `order_service_item`, `review_score`, `review_content`, `review_time`, `refund_time`) VALUES ('21', '8', '1', '1', '2', '1643', '1643', '2024-10-22 00:00:00', '2024-11-22 00:00:00', '1', '0', '1', '1', '不滿意', '2023-01-22 00:00:00', '2023-01-22 00:00:00');
INSERT INTO `homie`.`order_service` (`order_service_id`, `user_id_seller`, `user_id_buyer`, `order_quantity`, `order_status`, `order_unit_price`, `order_total`, `order_placement_time`, `order_service_finish_date`, `order_add_gc`, `order_deduct_gc`, `order_service_item`, `review_score`, `review_content`, `review_time`, `refund_time`) VALUES ('22', '8', '1', '1', '2', '1666', '1666', '2024-10-22 00:00:00', '2024-12-22 00:00:00', '1', '0', '1', '1', '品項多', '2023-01-22 00:00:00', '2023-01-22 00:00:00');

INSERT INTO `homie`.`user_info` (`user_id`, `user_account`, `user_password`, `garbage_coin`, `seller_identity`, `user_name`, `user_address`, `user_phone`, `user_gender`, `user_ic`) VALUES ('1', 'admin', 'admin', '0', '0', '王世民', '台北市忠孝東路五段', '0987654321', '0', 'A234567890');
INSERT INTO `homie`.`user_info` (`user_id`, `user_account`, `user_password`, `garbage_coin`, `seller_identity`, `user_name`, `user_address`, `user_phone`, `user_gender`, `user_ic`) VALUES ('2', 'asd123', 'asd123', '0', '0', '陳之廷', '台北市忠孝東路四段', '0923456789', '0', 'P132378978');
INSERT INTO `homie`.`user_info` (`user_id`, `user_account`, `user_password`, `garbage_coin`, `seller_identity`, `user_name`, `user_address`, `user_phone`, `user_gender`, `user_ic`) VALUES ('3', 'qwe123', 'qwe123', '0', '0', '張文彥', '台北市忠孝東路三段', '0912312312', '0', 'W264534532');

 