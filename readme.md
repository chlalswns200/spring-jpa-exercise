# 도서

## Endpoints
도서 목록 조회 하는 기능

GET /api/v1/book/list

ex) http://localhost:8080/api/v1/books

## 호출 주소
http://ec2-43-200-129-254.ap-northeast-2.compute.amazonaws.com:8080/api/book/list


# 병원

## Endpoints
###병원 정보와 해당 병원의 리뷰 전체를 조회 하는 기능

GET /api/v2/hospital/{id}

ex) http://localhost:8080/api/v2/hospital/3

###특정 병원의 리뷰를 조회하는 기능

GET /api/v2/hospital/{id}/reviews

ex) http://localhost:8080/api/v2/hospital/3/reviews

###특정 병원의 리뷰를 작성하는 기능

POST /api/v2/hospital/{id}/reviews

ex) http://localhost:8080/api/v2/hospital/3/reviews


## 호출 주소
http://ec2-43-200-129-254.ap-northeast-2.compute.amazonaws.com:8080/api/v2/hospital

