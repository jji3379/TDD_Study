# TDD 가이드

## Red - Green - Refactor
- Red: 실패하는 테스트를 작성한다.
- Green: 테스트를 통과하는 최소한의 코드를 작성한다.
- Refactor: 중복을 제거하고, 가독성을 높인다.

## 테스트 케이스 세분화하기
- 해피 케이스
- 예외 케이스
- 경계값 테스트
  - 범위(이상, 이하, 초과, 미만)
  - 구간
  - 날짜 등

## 테스트하기 어려운 영역을 구분하고 분리하기
- 관측할 때마다 다른 값에 의존하는 코드 (IN)
  - 현재 날짜 
  - 시간 
  - 랜덤 값
  - 전역 변수
  - 함수
  - 사용자 입력 등
- 외부 세계에 영향을 주는 코드 (OUT)
  - 표준 출력
  - 메시지 발송
  - 데이터베이스에 기록하기 등

## DisplayName을 섬세하게
- 명사의 나열보다 문장으로
  - A이면 B이다.
  - A이면 B가 아니고 C다.
- 테스트 행위에 대한 결과까지 기술하기
  - 음료를 1개 추가하면 주문 목록에 담긴다.
- 도메인 용어를 사용하여 한층 추상화된 내용을 담기
  - "영업 시작 시간" 이전에는 주문을 생성할 수 없다.

## BDD 스타일로 작성하기
- Given
  - 시나리오 진행에 필요한 모든 준비 과정 (객체, 값, 상태 등)
- When
  - 시나리오 행동 진행
- Then
  - 시나리오 진행에 대한 결과 명시, 검증
- 어떤 환경에서(Given) 어떤 행동을 진행했을 때(When) 어떤 상태 변화가 일어난다(Then).
  - DisplayName에 명확하게 작성할 수 있다.

## 주로 사용하는 검증 방법
- assertThat().hasSize(1)
- assertThat().isEqualTo("A")
- assertThatThrownBy().isInstanceOf(IllegalArgumentException.class).hasMessage("A")
- assertThat().hasSize(2).extracting("name", "price").containsExactlyInAnyOrder(tuple("A", 1000), tuple("B", 2000))