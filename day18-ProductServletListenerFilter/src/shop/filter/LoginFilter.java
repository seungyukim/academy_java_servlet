package shop.filter;

import static shop.util.LoginChecker.isLogin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "loginFilter"
          ,urlPatterns = {"/main/*"})
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest  req
			           , ServletResponse res
			           , FilterChain     chain)
			throws IOException, ServletException {

		// 1. 전처리
		System.out.println("=== 2. 로그인 필터 진입 ===");
		
		if (isLogin((HttpServletRequest)req)) {
			// 현재 로그인 상태
			req.setAttribute("isLogin", "true");
			
			// 2. 다음 필터 진행
			chain.doFilter(req, res);
		} else {
			// 로그인 시도인 경우는 정상진행
			// 로그인 시도 화면으로부터 요청파라미터가 
			// 전달되었을 것이므로 그 파라미터로 분기
			String userid = ((HttpServletRequest)req).getParameter("userid");
			if (userid != null) {
				// 로그인 처리를 그대로 수행하게 함
				// 2. 다음 필터 진행
				chain.doFilter(req, res);
			} else {
				// 로그인이 아닌 상태라면 로그인 화면으로 이동
				req.setAttribute("isLogin", "false");
				
				RequestDispatcher reqd;
				reqd = req.getRequestDispatcher("login");
		
				reqd.forward(req, res);
			}
			
			
		}
		
		// 2. 다음 필더 진행
		
		
		// 3. 후처리
		System.out.println("=== 2. 로그인 필터 종료 ===");
		
	}

	@Override
	public void destroy() {
		
	}

}
