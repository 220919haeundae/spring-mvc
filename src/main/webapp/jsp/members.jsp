<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="java.util.List" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
 %>

 <html>
 <head>

 </head>
 <body>
 <ul>
     <%
         for(Member m : members) {
     %>

           <li><%= m.getUsername() %></li>
           <li><%= m.getAge() %></li>

     <%
         }
     %>
 </ul>
 </body>
 </html>