<<  spring.jpa.hibernate.ddl-auto 의 각 옵션이 하는 일 >>

create: 이 옵션은 애플리케이션이 시작될 때마다 데이터베이스 스키마를 삭제하고 다시 생성합니다. 		이 옵션은 데이터 손실을 초래할 수 있으므로 프로덕션 환경에서 사용할 때 
		주의해야 합니다.

update: 이 옵션은 기존 테이블이나 데이터를 삭제하지 않고 스키마를 업데이트합니다. 
		필요한 경우 새 테이블을 생성하고 열을 추가 또는 수정합니다. 
		그러나 더 이상 필요하지 않은 열이나 테이블을 제거하지는 않습니다.
        역시 프로덕션 환경에서 사용할 때 주의해야 합니다.
        
validate: 이 옵션은 데이터베이스 스키마에 변경을 가하지 않습니다. 
		단순히 기존 스키마를 엔터티 클래스와 비교하여 일치하지 않는 부분을 보고합니다.
		엔터티와 데이터베이스 스키마 사이에 차이가 있으면 예외가 발생합니다.

none: 이 옵션은 Hibernate에 의한 자동 스키마 관리를 비활성화합니다. 
		데이터베이스 스키마를 수동으로 만들고 유지 관리해야 합니다.