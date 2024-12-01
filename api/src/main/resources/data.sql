-- 브랜드 테이블에 브랜드 A 추가
INSERT INTO Brand (name) VALUES ('A');
INSERT INTO Brand (name) VALUES ('B');
INSERT INTO Brand (name) VALUES ('C');
INSERT INTO Brand (name) VALUES ('D');
INSERT INTO Brand (name) VALUES ('E');
INSERT INTO Brand (name) VALUES ('F');
INSERT INTO Brand (name) VALUES ('G');
INSERT INTO Brand (name) VALUES ('H');
INSERT INTO Brand (name) VALUES ('I');


-- 카테고리 테이블에 카테고리 정보 추가 (예시)
INSERT INTO Category (name) VALUES ('상의');
INSERT INTO Category (name) VALUES ('아우터');
INSERT INTO Category (name) VALUES ('바지');
INSERT INTO Category (name) VALUES ('스니커즈');
INSERT INTO Category (name) VALUES ('가방');
INSERT INTO Category (name) VALUES ('모자');
INSERT INTO Category (name) VALUES ('양말');
INSERT INTO Category (name) VALUES ('액세사리');

-- 제품 테이블에 제품 정보 추가 (카테고리 id 사용)
INSERT INTO Product (category_id, brand_id) VALUES (1, 1);
INSERT INTO Product (category_id, brand_id) VALUES (2,1);
INSERT INTO Product (category_id, brand_id) VALUES (3,1);
INSERT INTO Product (category_id, brand_id) VALUES (4,1);
INSERT INTO Product (category_id, brand_id) VALUES (5,1);
INSERT INTO Product (category_id, brand_id) VALUES (6,1);
INSERT INTO Product (category_id, brand_id) VALUES (7,1);
INSERT INTO Product (category_id, brand_id) VALUES (8,1);

INSERT INTO Product (category_id, brand_id) VALUES (1, 2);
INSERT INTO Product (category_id, brand_id) VALUES (2,2);
INSERT INTO Product (category_id, brand_id) VALUES (3,2);
INSERT INTO Product (category_id, brand_id) VALUES (4,2);
INSERT INTO Product (category_id, brand_id) VALUES (5,2);
INSERT INTO Product (category_id, brand_id) VALUES (6,2);
INSERT INTO Product (category_id, brand_id) VALUES (7,2);
INSERT INTO Product (category_id, brand_id) VALUES (8,2);

INSERT INTO Product (category_id, brand_id) VALUES (1, 3);
INSERT INTO Product (category_id, brand_id) VALUES (2,3);
INSERT INTO Product (category_id, brand_id) VALUES (3,3);
INSERT INTO Product (category_id, brand_id) VALUES (4,3);
INSERT INTO Product (category_id, brand_id) VALUES (5,3);
INSERT INTO Product (category_id, brand_id) VALUES (6,3);
INSERT INTO Product (category_id, brand_id) VALUES (7,3);
INSERT INTO Product (category_id, brand_id) VALUES (8,3);

INSERT INTO Product (category_id, brand_id) VALUES (1, 4);
INSERT INTO Product (category_id, brand_id) VALUES (2,4);
INSERT INTO Product (category_id, brand_id) VALUES (3,4);
INSERT INTO Product (category_id, brand_id) VALUES (4,4);
INSERT INTO Product (category_id, brand_id) VALUES (5,4);
INSERT INTO Product (category_id, brand_id) VALUES (6,4);
INSERT INTO Product (category_id, brand_id) VALUES (7,4);
INSERT INTO Product (category_id, brand_id) VALUES (8,4);


INSERT INTO Product (category_id, brand_id) VALUES (1, 5);
INSERT INTO Product (category_id, brand_id) VALUES (2,5);
INSERT INTO Product (category_id, brand_id) VALUES (3,5);
INSERT INTO Product (category_id, brand_id) VALUES (4,5);
INSERT INTO Product (category_id, brand_id) VALUES (5,5);
INSERT INTO Product (category_id, brand_id) VALUES (6,5);
INSERT INTO Product (category_id, brand_id) VALUES (7,5);
INSERT INTO Product (category_id, brand_id) VALUES (8,5);

INSERT INTO Product (category_id, brand_id) VALUES (1, 6);
INSERT INTO Product (category_id, brand_id) VALUES (2,6);
INSERT INTO Product (category_id, brand_id) VALUES (3,6);
INSERT INTO Product (category_id, brand_id) VALUES (4,6);
INSERT INTO Product (category_id, brand_id) VALUES (5,6);
INSERT INTO Product (category_id, brand_id) VALUES (6,6);
INSERT INTO Product (category_id, brand_id) VALUES (7,6);
INSERT INTO Product (category_id, brand_id) VALUES (8,6);

INSERT INTO Product (category_id, brand_id) VALUES (1, 7);
INSERT INTO Product (category_id, brand_id) VALUES (2,7);
INSERT INTO Product (category_id, brand_id) VALUES (3,7);
INSERT INTO Product (category_id, brand_id) VALUES (4,7);
INSERT INTO Product (category_id, brand_id) VALUES (5,7);
INSERT INTO Product (category_id, brand_id) VALUES (6,7);
INSERT INTO Product (category_id, brand_id) VALUES (7,7);
INSERT INTO Product (category_id, brand_id) VALUES (8,7);

INSERT INTO Product (category_id, brand_id) VALUES (1, 8);
INSERT INTO Product (category_id, brand_id) VALUES (2,8);
INSERT INTO Product (category_id, brand_id) VALUES (3,8);
INSERT INTO Product (category_id, brand_id) VALUES (4,8);
INSERT INTO Product (category_id, brand_id) VALUES (5,8);
INSERT INTO Product (category_id, brand_id) VALUES (6,8);
INSERT INTO Product (category_id, brand_id) VALUES (7,8);
INSERT INTO Product (category_id, brand_id) VALUES (8,8);

INSERT INTO Product (category_id, brand_id) VALUES (1, 9);
INSERT INTO Product (category_id, brand_id) VALUES (2,9);
INSERT INTO Product (category_id, brand_id) VALUES (3,9);
INSERT INTO Product (category_id, brand_id) VALUES (4,9);
INSERT INTO Product (category_id, brand_id) VALUES (5,9);
INSERT INTO Product (category_id, brand_id) VALUES (6,9);
INSERT INTO Product (category_id, brand_id) VALUES (7,9);
INSERT INTO Product (category_id, brand_id) VALUES (8,9);

INSERT INTO PRICE (product_id, amount) VALUES (1, 11200);
INSERT INTO PRICE (product_id, amount) VALUES (2, 5500);
INSERT INTO PRICE (product_id, amount) VALUES (3, 4200);
INSERT INTO PRICE (product_id, amount) VALUES (4, 9000);
INSERT INTO PRICE (product_id, amount) VALUES (5, 2000);
INSERT INTO PRICE (product_id, amount) VALUES (6, 1700);
INSERT INTO PRICE (product_id, amount) VALUES (7, 1800);
INSERT INTO PRICE (product_id, amount) VALUES (8, 2300);


INSERT INTO PRICE (product_id, amount) VALUES (9, 10500);
INSERT INTO PRICE (product_id, amount) VALUES (10, 5900);
INSERT INTO PRICE (product_id, amount) VALUES (11, 3800);
INSERT INTO PRICE (product_id, amount) VALUES (12, 9100);
INSERT INTO PRICE (product_id, amount) VALUES (13, 2100);
INSERT INTO PRICE (product_id, amount) VALUES (14, 2000);
INSERT INTO PRICE (product_id, amount) VALUES (15, 2000);
INSERT INTO PRICE (product_id, amount) VALUES (16, 2200);

INSERT INTO PRICE (product_id, amount) VALUES (17, 10000);
INSERT INTO PRICE (product_id, amount) VALUES (18, 6200);
INSERT INTO PRICE (product_id, amount) VALUES (19, 3300);
INSERT INTO PRICE (product_id, amount) VALUES (20, 9200);
INSERT INTO PRICE (product_id, amount) VALUES (21, 2200);
INSERT INTO PRICE (product_id, amount) VALUES (22, 1900);
INSERT INTO PRICE (product_id, amount) VALUES (23, 2200);
INSERT INTO PRICE (product_id, amount) VALUES (24, 2100);

INSERT INTO PRICE (product_id, amount) VALUES (25, 10100);
INSERT INTO PRICE (product_id, amount) VALUES (26, 5100);
INSERT INTO PRICE (product_id, amount) VALUES (27, 3000);
INSERT INTO PRICE (product_id, amount) VALUES (28, 9500);
INSERT INTO PRICE (product_id, amount) VALUES (29, 2500);
INSERT INTO PRICE (product_id, amount) VALUES (30, 1500);
INSERT INTO PRICE (product_id, amount) VALUES (31, 2400);
INSERT INTO PRICE (product_id, amount) VALUES (32, 2000);

INSERT INTO PRICE (product_id, amount) VALUES (33, 10700);
INSERT INTO PRICE (product_id, amount) VALUES (34, 5000);
INSERT INTO PRICE (product_id, amount) VALUES (35, 3800);
INSERT INTO PRICE (product_id, amount) VALUES (36, 9900);
INSERT INTO PRICE (product_id, amount) VALUES (37, 2300);
INSERT INTO PRICE (product_id, amount) VALUES (38, 1800);
INSERT INTO PRICE (product_id, amount) VALUES (39, 2100);
INSERT INTO PRICE (product_id, amount) VALUES (40, 2100);

INSERT INTO PRICE (product_id, amount) VALUES (41, 11200);
INSERT INTO PRICE (product_id, amount) VALUES (42, 7200);
INSERT INTO PRICE (product_id, amount) VALUES (43, 4000);
INSERT INTO PRICE (product_id, amount) VALUES (44, 9300);
INSERT INTO PRICE (product_id, amount) VALUES (45, 2100);
INSERT INTO PRICE (product_id, amount) VALUES (46, 1600);
INSERT INTO PRICE (product_id, amount) VALUES (47, 2300);
INSERT INTO PRICE (product_id, amount) VALUES (48, 1900);

INSERT INTO PRICE (product_id, amount) VALUES (49, 10500);
INSERT INTO PRICE (product_id, amount) VALUES (50, 5800);
INSERT INTO PRICE (product_id, amount) VALUES (51, 3900);
INSERT INTO PRICE (product_id, amount) VALUES (52, 9000);
INSERT INTO PRICE (product_id, amount) VALUES (53, 2200);
INSERT INTO PRICE (product_id, amount) VALUES (54, 1700);
INSERT INTO PRICE (product_id, amount) VALUES (55, 2100);
INSERT INTO PRICE (product_id, amount) VALUES (56, 2000);

INSERT INTO PRICE (product_id, amount) VALUES (57, 10800);
INSERT INTO PRICE (product_id, amount) VALUES (58, 6300);
INSERT INTO PRICE (product_id, amount) VALUES (59, 3100);
INSERT INTO PRICE (product_id, amount) VALUES (60, 9700);
INSERT INTO PRICE (product_id, amount) VALUES (61, 2100);
INSERT INTO PRICE (product_id, amount) VALUES (62, 1600);
INSERT INTO PRICE (product_id, amount) VALUES (63, 2000);
INSERT INTO PRICE (product_id, amount) VALUES (64, 2400);

INSERT INTO PRICE (product_id, amount) VALUES (65, 11400);
INSERT INTO PRICE (product_id, amount) VALUES (66, 6700);
INSERT INTO PRICE (product_id, amount) VALUES (67, 3200);
INSERT INTO PRICE (product_id, amount) VALUES (68, 9500);
INSERT INTO PRICE (product_id, amount) VALUES (69, 2400);
INSERT INTO PRICE (product_id, amount) VALUES (70, 1700);
INSERT INTO PRICE (product_id, amount) VALUES (71, 1700);
INSERT INTO PRICE (product_id, amount) VALUES (72, 2400);

