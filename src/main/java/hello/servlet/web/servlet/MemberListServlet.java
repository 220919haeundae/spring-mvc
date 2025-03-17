package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name= "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter w = response.getWriter();

        w.write(
            "<html>" +
            "<head>" +
            "   <meta charset=\"UTF-8\">\n" +
            "</head>\n" +
            "<body>\n" +
            "성공\n" +
            "<ul>\n"
        );
            for(Member m : members) {
                w.write(
                    "   <li>id="+m.getId()+"</li>\n" +
                    "   <li>username="+m.getUsername()+"</li>\n" +
                    "   <li>age="+m.getAge()+"</li>\n"
                );
            }
        w.write(
            "</ul>\n" +
            "<a href=\"index.html\">메인</a>\n" +
            "</body>\n" +
            "</html>"
        );
    }
}
