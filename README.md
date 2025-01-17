# 📝 [ JSP ] 강의평가 웹 사이트
<img src="https://user-images.githubusercontent.com/92259017/146367274-746bc3c6-821a-4313-b1b7-f59d0e7ea837.png"/>

## 🔎 목차
1. 개발환경
2. 구현한 기능
3. 출처

## 🛠 개발환경
1. 사용언어
    - Java SE 8
2. 라이브러리/프레임워크
    - Bootstrap 4
    - jQuery 3.6
    - JAF, JavaMail API
3. 통합 개발 환경
    - Eclipse 2020-06
4. 데이터베이스
    - MySQL 8.0
5. 운영체제
    - Windows 10
6. 웹 서버
    - Apache Tomcat 8.5

## 🎨 구현한 기능
- ### 회원
    - 회원가입 시 이메일 인증
    - 로그인, 로그아웃 기능

- ### 강의평가
    - 회원은 강의평가를 등록할 수 있습니다.
    - 부적절한 강의평가를 신고할 수 있습니다. 신고 내용은 관리자 이메일로 발송됩니다.
    - 강의평가를 한 번만 추천할 수 있습니다.
    - 자신이 쓴 강의평가만 삭제할 수 있습니다.

- ### 미니 검색 엔진
    - 검색 엔진을 통해 전공/교양 과목을 검색하고 원하는 방식으로 정렬할 수 있습니다.

- ### XSS 방어
    - XSS 방어 조치로 script 언어가 텍스트로 표시되도록 하였습니다.

## 🔗 출처
- [JSP 강의평가 웹 사이트 개발하기](https://inf.run/Td8i)
- [유튜브 동빈나](https://youtu.be/hke9FKluXow)
