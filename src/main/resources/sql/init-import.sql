INSERT INTO country(name) VALUES('한식'), ('일식'), ('중식'), ('베트남'), ('대만'), ('이탈리아'), ('프랑스');
INSERT INTO category(name) VALUES('밥'), ('국물'), ('면'), ('고기'), ('디저트/간식');
INSERT INTO food(name, country_id) VALUES('김치볶음밥', 1), ('규동', 2), ('오므라이스', 1), ('돈까스', 2), ('순대국밥', 1), ('닭갈비', 1);
INSERT INTO tag(name) VALUES('든든한'), ('매운'), ('달콤한'), ('시큼한'), ('느끼한'), ('얼큰한');
INSERT INTO food_tag(food_id, tag_id) VALUES (1, 1), (1,2), (2, 1), (2,3), (3,3), (4,1), (4,3), (4,5), (5,1), (5,6), (6,2);
INSERT INTO food_category(food_id, category_id) VALUES(1, 1), (1,4), (2,1), (2,4), (3,1), (4,1), (4,4), (5,1), (5,2), (6,1), (6,4);
