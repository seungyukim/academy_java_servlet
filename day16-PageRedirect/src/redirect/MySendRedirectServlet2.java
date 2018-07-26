package redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * send redirect기법은
 * 최초의 request에 대하여 response를 일으키고
 * 새로운 request로 다음 서블릿을 요청한다
 * 
 * 따라서 최소의 request에 설정했던 속성등이
 * 유지되지 않는다
 * @author PC38209
 *
 */
@WebServlet("/redirect2")
public class MySendRedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * redirect 목적 페이지인 next로 이동하기 전 
	 * 현재의 request에 대한 응답이 일어나기 때문에
	 * 브라우저 주소창에 요청 주소가 다음 페이지로 변경됨
	 * 
	 * 그리고 request가 변경되기 떄문에 설정한 속성이 유지되지 않는다.
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. request객체에 name속성을 설정
		request.setAttribute("name", "또잉");
		
		//2.sendRedirect로 전송
		//redirect는 응답을 일으키므로 response에 진행
		response.sendRedirect("next");
	}

}
