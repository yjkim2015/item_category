## 개발 환경

| 분야                   | stack                   |
| ---------------------- |-------------------------|
| 언어                   | Java 1.8                |
| 프레임워크             | springBoot 3.1.0        |
| DB                     | h2 Database             |
| 빌드 툴                | Gradle                  |
| Persistence 프레임워크 | JPA/Hibernate, QueryDsl |
| API 테스트 툴          | Postman, Swagger        |
| IDE                    | IntelliJ                |

<hr>

<h1> 테이블 구조 </h1>
Brand ⇄ Product (1:N 관계):

하나의 브랜드 (Brand)는 여러 개의 상품 (Product)을 가질 수 있습니다.
Product는 brand_id 외래 키를 통해 Brand와 연결됩니다.
Product ⇄ Brand (N:1 관계):

하나의 상품 (Product)은 하나의 카테고리 (Category)에 속합니다.
Product는 category_id 외래 키를 통해 Category와 연결됩니다.
Product ⇄ Category (1:N 관계):

하나의 상품 (Product)은 하나의 가격 (Price)을 가질 수 있습니다.
Price는 product_id 외래 키를 통해 Product와 연결됩니다.
Product ⇄ Price (1:1 관계):

중간 테이블로서 Product 역할
**Product**는 **Brand**와 Category 사이에서 중간 테이블 역할을 합니다.
즉, **Product**는 각각 **Brand**와 **Category**를 외래 키로 참조하여,
**Brand**와 Category 간의 다대일 관계를 연결합니다.

<hr>

<h1>모듈 구조</h1>

현재 모듈 구조를 나눈 방식은 계층별로 책임과 역할을 분리하여 확장성 및 관리 용이성을 높이려는 설계입니다. 각 모듈이 독립적으로 책임을 가지고 있으며, 다음과 같은 구조적 장점이 있습니다:

1. **api 모듈**

* 클라이언트와 직접 소통하며, API 요청을 처리합니다. 주로 컨트롤러와 설정 파일을 포함하여, 서비스 로직을 호출하고 데이터를 반환하는 역할을 담당합니다.
* 클라이언트와의 요청 처리 부분을 분리함으로써 프레젠테이션 계층의 독립성을 높여 API의 유지보수와 확장이 용이해집니다.

2. **core 모듈**

* 비즈니스 로직을 처리하며, infra 모듈을 통해 데이터에 접근합니다. 예외 처리를 포함하여, API 모듈에서 호출된 서비스의 로직을 구현합니다.
* 비즈니스 로직을 따로 관리하여 API 모듈과 분리되므로, 각 서비스 기능에 대한 독립성과 테스트의 용이성을 확보할 수 있습니다. 다양한 서비스 계층 로직을 추가할 때 모듈 구조의 유연성이 확보됩니다.

3. **infra 모듈**
* 데이터베이스와의 상호작용을 담당하며, 엔티티와 레포지토리를 포함합니다. 데이터베이스 설정 및 데이터 초기화를 위한 구성 요소들이 포함되어 있습니다.
* 데이터베이스 접근 로직을 서비스와 분리하여 데이터 관리 로직의 독립성을 높이고, 데이터 계층에 대한 변경 사항을 다른 모듈에 영향을 주지 않고 처리할 수 있습니다.


![img_5.png](image/img_5.png)

![img_6.png](image/img_6.png)


<h1>1번 문제</h1>

![img_14.png](image/img_14.png)
![img_9.png](image/img_9.png)
![img_10.png](image/img_10.png)
![img_3.png](image/img_3.png)
![img_4.png](image/img_4.png)


<h2>2번 문제</h1>
![img_14.png](image/img_14.png)
![img_7.png](image/img_7.png)
![img_8.png](image/img_8.png)
![img_11.png](image/img_11.png)
![img_12.png](image/img_12.png)

<h2>3번 문제</h1>
![img_14.png](image/img_14.png)
![img_15.png](image/img_15.png)
![img_17.png](image/img_17.png)
<h2>4번 문제</h1>
<h3>Brand</h3>
![img_19.png](image/img_19.png)
1-1 (저장)
![img_31.png](image/img_31.png)
![img_32.png](image/img_32.png)
![img_33.png](image/img_33.png)
1-2 (삭제)
![img_35.png](image/img_35.png)
![img_36.png](image/img_36.png)
![img_37.png](image/img_37.png)
1-3 (수정)
![img_38.png](image/img_38.png)
![img_39.png](image/img_39.png)
![img_40.png](image/img_40.png)

<h3>Product</h3>
![img_18.png](image/img_18.png)

1-1 (저장)
![img_20.png](image/img_20.png)
![img_21.png](image/img_21.png)
![img_23.png](image/img_23.png)
![img_24.png](image/img_24.png)
1-2 (삭제)
![img_25.png](image/img_25.png)
![img_26.png](image/img_26.png)
1-3 (수정)
![img_27.png](image/img_27.png)
![img_28.png](image/img_28.png)
![img_30.png](image/img_30.png)


<h1>구현 범위</h1>
1~4번 문제에 대해서는 전부 구현하였습니다.
테스트 코드는 작성하지 못하였습니다.

1번
카테고리 별 최저가격 브랜드와 상품 가격의 경우
쿼리가 복잡하고 QueryDsl에서는 SubQuery안에 Limit을 지원하지 않아 NativeQuery를 사용하였습니다.
2번과 3번은 
QueryDSL을 사용하였으며
4번의 경우는 기본 JpaRepository에서 제공해주는 기능을 사용하였습니다.

<h1>실행 방법</h1>
1. local 환경에서 h2 데이터베이스 설치 후 실행
2. project import 
2-1 ./gradlew :api:bootRun
