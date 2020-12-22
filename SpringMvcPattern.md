# Spring MVC Pattern

### Spring MVC 처리 순서

1. 클라이언트(Client)가 서버에 어떤 요청(request)을 한다면 스프링에서 제공하는 DispatcherServlet 이라는 
   클래스(일종의 front controller)가 요청을 가로챈다.
   (web.xml에 살표보면 모든 url(/)에 서블릿 매핑을 하여 모든 요청을 DispatcherServlet이 가로채게 해둔다(변경가능))
   

2. 요청을 가로챈 DispatcherServlet은 HandlerMapping(URL 분석등)에게 어떤 컨트롤러 에게 요청을 위임하면 좋을지 물어본다.
   (HandlerMapping은 servlet-context.xml 에서 @Controller로 등록한 것들을 스캔해서 찾아놨기 때문에 어느 컨트롤러에게 
   요청을 위임해야할지 알고 있다.)
   

   
3. 요청에 매핑된 컨트롤러가 있다면 @RequestMapping을 통하여 요청을 처리할 메서드에 도달한다.


4. 컨트롤러에서는 해당 요청을 처리할 Service를 주입(DI)받아 비즈니스로직을 Service에게 위임한다.


5. Service에서는 요청에 필요한 작업 대부분(코딩)을 담당하며 데이터베이스에 접근이 필요하면 DAO를 주입받아
   DB처리는 DAO에게 위임한다.
   

6. DAO는 mybatis(또는 hibernate등) 설정을 이용해서 SQL 쿼리를 날려 DB에 저장되어있는 정보를 받아 서비스
   에게 다시 돌려준다.
   

7. 모든 비즈니스 로직을 끝낸 서비스가 결과물을 컨트롤러에게 넘긴다.


8. 결과물을 받은 컨트롤러는 필요에 따라 Model객체에 결과물을 넣거나, 어떤 view(jsp)파일을 보여줄 것인지등의
   정보를 답아 DispatcherServlet에게 보낸다.
   

9. DispatcherServlet은 ViewResolver에게 받은 뷰의 대한 정보를 넘긴다.


10. ViewResolver는 해당 JSP를 찾아서(응답할 View를 찾음) DispatcherServlet에게 알려준다.
    (servlet-context.xml에서 suffix, prefix를 통해 /WEB-INF/views/index.jsp 이렇게 만들어주는 것eh ViewResolver)
    

11. DispatcherServlet은 응답할 View에게 Render를 지시하고 View는 응답 로직을 처리한다.


12. 결과적으로 DispatcherServlet이 클라이언트에게 렌더링된 View를 응답한다.