package forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿 페이지 이동 방식 중
 * forward방식을 사용하여 페이지 이동을
 * 테스트하는 클래스
 * --------------------------------
 * Foward방식으로 페이지를 이동시키면
 * 최초의 request, response가 유지되면서 이동한다
 * @author PC38209
 *
 */
@WebServlet("/forward")
public class MyForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 첫 서블릿 진입하여 request에 속성을 추가
		request.setAttribute("name", "또잉이");
		
		//2.forward 방식으로 next 서블릿으로 이동
		//(1)reqestDispatcher 객체를 얻어냄
		RequestDispatcher reqd;
		reqd = request.getRequestDispatcher("next");
		
		//(2)얻어진 dispatcher객체 reqd에 forward()사용
		// 이때 최초의 request, response를 전달
		reqd.forward(request, response);
	}

}
