# SpringCorePractice

SpringCore에서 배운 내용을 바탕으로 만든 하나의 주문 시스템

현재 localhost://8080/test로 지정된 하나의 주문만 들어간다 //값 변경 불가

Controller에서는 크게 3가지 Service를 사용하도록 설게하였다
1. Logger
  해당 요청에 대한 로그를 알 수 있도록 scope="request"인 logger각 각 요청별로 호출된다
2. MemberService
  현재는 웹으로 부터 입력 값이나 세션이 구현되어 있지 않기 때문에 임의의 한 유저에 대한 정보를 입력받았다 가정하였음.
  그 유저 정보를 바탕으로 초기에 회원가입을 하여 성공시 Member를 돌려받고 이미 존재한다면 null을 돌려받음 <<< DIP위반인가?
  그 후 해당 유저의 정보로 로그인을 시도하여 마찬 가지로 성공시 Member 실패시 null을 받는다.
  
3. OrderService
  회원 정보를 세션에 저장하여서 전달해야하나 현재는 세션이 구현되어 있지 않다 그럼으로 위에서 login을 해서 받은 user를 바탕으로 주문을 넣는다
  OrderService도 마찬가지로 해당 유저가 실제 존재하는지 한번더 체크하는 알고리즘이 MemberRepository의 findbyID를 통해서 이루어지고 존재한다면
  Order를 반환하고 존재하지 않는다면 null을 반환한다.

Spring Bean에 등록된 Component로는
OrderServiceImpl 

MemberServiceImpl 

LoggerService 

MemoryMemberRepository 

RateDiscountpolicy 

FixDiscountpolicy(@Primary) 

Logger(@Scope(value="request")) 
가 설정되었고 의존 관계는 다음과 같다

OrderServiceImple - (MemberRepository, Discountpolicy)

MemberService  - (MemberRepository)

LoggerService - (Logger)
