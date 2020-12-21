# Spring MVC Pattern

### Spring MVC 처리 순서

1. 클라이언트(Client)가 서버에 어떤 요청(request)을 한다면 스프링에서 제공하는 DispatcherServlet 이라는 
   클래스(일종의 front controller)가 요청을 가로챈다.
   (web.xml에 살표보면 모든 url(/)에 서블릿 매핑을 하여 모든 요청을 DispatcherServlet이 가로채게 해둔다(변경가능))
   

2. 요청을 가로챈 DispatcherServlet은 HandlerMapping(URL 분석등)에게 어떤 컨트롤러 에게 요청을 위임하면 좋을지 물어본다.
   (HandlerMapping은 servlet-context.xml 에서 @Controller로 등록한 것들을 스캔해서 찾아놨기 때문에 어느 컨트롤러에게 
   요청을 위임해야할지 알고 있다.)