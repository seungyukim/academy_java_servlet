package include;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/include")
public class MyIncludeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.응답객체에 한글설정
		//include방식은 첫 서블릿이 응답하므로 
		//응답하는 서블릿에서 한글설정을
		 response.setContentType("text/html; charset=utf-8");
		
		//1.request객체에 name속성 추가
		request.setAttribute("name", "또잉이");
		
		//2.inclue로 next 서블릿 이동을 위하여
		//(1)RequestDispatcher를 얻어냄
		RequestDispatcher reqd;
		reqd = request.getRequestDispatcher("next");
		
		//(2)얻어진 dispatcher객체에 inclue()적용
		//	 이때, 최초의 request, response를 전달
		reqd.include(request, response);
	
	}

}
