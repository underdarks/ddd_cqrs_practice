# ejm_company
이제이엠컴퍼니 과제

---
- 아키텍쳐 : DDD + CQRS 적용(확장성 고려) + layered 아키텍처
- DB : Mysql 8.x(도커 미사용)
- 객체변환(엔티티<-> dto 변환) : mapstruct 사용하려다가 강한 의존성으로 인해 사용하지 않았음
- 추가 고려 사항 : 멀티 모듈, 도커, AWS 인프라 등
- db 생성 쿼리는 프로젝트 안에 resourece 폴더 안에 db_스키마_생성.sql 참고
- git 전략 : git-flow
- 문서 Swagger 참고 : http://localhost:8080/swagger-ui.html
