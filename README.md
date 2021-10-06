## | 적용된 것들
- JPA
- Swagger 2.4
- Spring 5
- Spring Boot 2.3
- Spring MVC

## | 추가 적용할 것들
- Custom Exception
- Swagger
- AOP

### 카테고리 단건 조회
GET http://localhost:8080/api/categories/1


### 카테고리 모두 조회
GET http://localhost:8080/api/categories/all


### 카테고리 페이징 조회
GET http://localhost:8080/api/categories


### 음식 단건 조회
GET http://localhost:8080/api/foods/1


### 음식 모두 조회
GET http://localhost:8080/api/foods/all


### 음식 페이징 조회
GET http://localhost:8080/api/foods


### 음식 단 건 조회 JOIN 국가
GET http://localhost:8080/api/foods/1/country



### 음식 리스트 조회 JOIN 국가, 태그
GET http://localhost:8080/api/foods/1/country-tags


### 음식 리스트 조회 JOIN 국가, 태그, 카테고리
GET http://localhost:8080/api/foods/1/country-tags-categories


