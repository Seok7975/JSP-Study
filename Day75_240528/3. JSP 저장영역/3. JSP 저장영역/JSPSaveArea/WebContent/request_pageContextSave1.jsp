<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h2> request와 pageContext 차이 알아보기</h2>
	
	<%
		//정보저장하기		
		request.setAttribute("id", "hong");
		pageContext.setAttribute("name","홍길동");	
	%>
	
	<h2> 저장된 정보 출력해보기 </h2>
	request : <%=request.getAttribute("id") %><br/>
	pageContext : <%=pageContext.getAttribute("name") %> <br/>
	
	<hr>
	
	<a href="request_PageContextGet.jsp"> 이동하기 </a>
	  <%--  pageContext.forward("request_PageContextGet.jsp"); --%>
	 <%-- <jsp:forward page="request_PageContextGet.jsp"/> --%>
</body>
</html>

<%-- 
	페이지 이동방법
	
	1. 포워드(forward)
	- request 스코프에 담긴값이 유효하다.(request, response가 유지된다.)
	- 이동된 url이 화면에 안보인다.(사용자는 이동했는지 알수없음)
	- 포워드하는 방법
	1) pageContext.forward("이동할 페이지");
	2) <jsp:forward page="이동할 페이지" />
	3) RequestDispatcher rd = request.getRequestDispatcher("이동할 페이지");
		rd.forward(request, response);
		
	2. 리다이렉트(redirect)
	- 클라이언트가 새로 페이지를 요청한 것과 같은 방식으로 페이지가 이동됨.
	request, response가 유지되지 않는다.(새로 만들어짐)
	- 이동된 url이 화면에 보인다.
	- 리다이렉트 하는 방법
	response.sendRedirect("이동할 페이지");
 --%>