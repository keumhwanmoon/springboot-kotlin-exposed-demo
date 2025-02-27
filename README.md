# 🚀 Spring Boot with Exposed Demo Project

Spring Boot 환경에서 Kotlin ORM 프레임워크인 Exposed의 활용 방법을 보여주는 데모 프로젝트입니다.
Kotlin 개발자를 위한 Spring Boot 애플리케이션에서의 Exposed 실전 활용 예제 제공이 목적입니다.

## 🧑‍💻 작성자 소개

안녕하세요! 15년차 백엔드 개발자 문금환입니다.
현재 프리랜서로 활동하고 있으며, 코틀린과 스프링을 주력으로 사용하고 있습니다.
더 나은 코드를 위해 항상 고민하고 새로운 기술을 탐구하는 것을 즐깁니다.

궁금하신 점이나 협업 제안이 있으시다면 언제든 연락 주세요.

### 연락처
- 이메일: keumhwan.moon@gmail.com
- GitHub: [@keumhwanmoon](https://github.com/keumhwanmoon)

### 기술 블로그
- [Tistory](https://jason-moon.tistory.com/)
- [Medium](https://medium.com/@jason.moon.kr)
- [GitHub Pages](https://keumhwanmoon.github.io)

## ⚙️ 기술 스택

- Kotlin 1.9.21
- Spring Boot 3.2.2
- [Exposed](https://www.jetbrains.com/help/exposed/home.html) (Kotlin ORM)
- Spring Data JDBC 3.2.2
- Spring MVC 6.1.3
- Java 17 (OpenJDK 17.0.9)

## 🌟 주요 기능

### 📋 사용자 관리 (User Management)
Exposed DSL을 활용한 CRUD 작업 구현
- 사용자 목록 조회 (`GET /api/users`)
- 사용자 상세 조회 (`GET /api/users/{id}`)
- 사용자 생성 (`POST /api/users`)
- 사용자 수정 (`PUT /api/users/{id}`)
- 사용자 삭제 (`DELETE /api/users/{id}`)

> SQL과 유사한 문법의 Exposed DSL을 통한 데이터베이스 작업 수행
> (예시: Users.select() 형태의 쿼리 작성)

### 🔖 코드 관리 (Code Management)
Exposed ORM을 활용한 객체지향적 데이터 접근
- 코드 목록 조회: `GET /api/codes`
- 코드 상세 조회: `GET /api/codes/{codeId}`
- 코드 생성: `POST /api/codes`
- 코드 수정: `PUT /api/codes/{codeId}`
- 코드 삭제: `DELETE /api/codes/{codeId}`
- 상위 코드로 하위 코드 목록 조회: `GET /api/codes/parent/{parentCodeId}`
- 계층 구조 코드 조회: `GET /api/codes/hierarchy`
- 활성 코드 목록 조회: `GET /api/codes/active`

> Exposed ORM을 활용한 객체지향적 데이터 접근
> (예시: Code.find { Codes.codeId eq codeId }.firstOrNull() 형태의 엔티티 조회)

## 🚀 프로젝트 시작

### ✅ 필수 요구사항
- JDK 17 이상
- Gradle 8.5 이상

### 📥 설치 및 실행 방법

1. 프로젝트 복제
```bash
git clone https://github.com/keumhwanmoon/springboot-kotlin-exposed-demo.git
cd springboot-kotlin-exposed-demo
```

2. 프로젝트 빌드
```bash
./gradlew clean build
```

3. 애플리케이션 실행
```bash
./gradlew bootRun
```

## 💾 데이터베이스 구성

H2 인메모리 데이터베이스 사용
- `resources/schema.sql`: 테이블 스키마 정의
- `resources/data.sql`: 초기 데이터 설정

## 💡 Exposed 활용 예시

### DSL 방식 (UserService)
```kotlin
Users.select { Users.id eq id }
    .firstOrNull()
```

### Sequence API 방식 (CodeService)
```kotlin
val code = Code.find { Codes.codeId eq codeId }.firstOrNull()
code?.apply {
    this.parCodeId = codeReq.parCodeId
    this.codeName = codeReq.codeName
    this.codeValue = codeReq.codeValue
    this.codeExplanation = codeReq.codeExplanation
    this.useYn = codeReq.useYn.single()
    this.sortNumber = codeReq.sortNumber
    this.lastUpdatedAt = LocalDateTime.now()
}?.toCodeRes()
```

## 🔍 API 테스트 가이드

프로젝트의 `/http` 디렉토리에서 제공되는 HTTP 요청 파일을 통해 모든 API를 쉽게 테스트할 수 있습니다.

### 📋 테스트 환경 설정
각 HTTP 파일에서 사용되는 공통 환경 변수:
```http
@host = localhost    // 서버 호스트
@port = 8080        // 서버 포트
```

## 🤝 프로젝트 참여

프로젝트 개선을 위한 다양한 의견 환영
- 버그 발견 시 GitHub Issue 등록 요청
- 새로운 기능 제안은 Pull Request 검토 후 반영
- 기타 문의사항은 이메일로 연락 가능

## 🔗 관련 프로젝트 추천

### Ktorm을 활용한 유사 프로젝트
[Springboot Kkotlin Ktorm Demo](https://github.com/keumhwanmoon/springboot-kotlin-ktorm-demo)
- Spring Boot와 Ktorm을 활용한 데모 프로젝트
- Exposed 대신 Ktorm을 사용하여 구현된 유사한 기능
- 주요 차이점:
  - Ktorm의 SQL DSL 문법 활용
  - Entity Sequence API 대신 Entity API 사용
  - 더 직관적인 조인 쿼리 작성 가능

#### 기능 비교
| 기능      | 현재 프로젝트 (Exposed)      | Ktorm 프로젝트           |
|---------|------------------------|----------------------|
| ORM 문법  | SQL DSL + Sequence API | SQL DSL + Entity API |
| 타입 안전성  | ✅                      | ✅                    |
| 코틀린 친화성 | ✅                      | ✅                    |
| 학습 곡선   | 중간                     | 낮음                   |
| 커뮤니티 규모 | 큼                      | 성장중                  |

이 두 프로젝트를 비교하면서 Kotlin ORM의 다양한 접근 방식을 학습할 수 있습니다.
각각의 장단점을 파악하여 프로젝트 요구사항에 맞는 최적의 선택을 할 수 있습니다.


## 📝 라이선스
본 프로젝트는 MIT 라이선스 적용. 상세 내용은 [LICENSE](LICENSE) 파일 참조.
