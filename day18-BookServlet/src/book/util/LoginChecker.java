package book.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 로그인 상태를 체크해서 로그인 여부를
 * boolean 값으로 리턴하는 static 를 가진 클래스
 * @author PC38209
 *
 */
public class LoginChecker {

	public static boolean isLogin(HttpServletRequest req) {
		boolean isLogin = false;
		
		// 매개변수로 넘어온 req 로 부터 세션을 얻어냄
		HttpSession session = req.getSession(false);
		
		if (session != null) {
			// 로그인 했을 때, session 객체에
			// userid 라는 이름으로 추가된 속성이 있는지 검사
			String userid = (String) session.getAttribute("userid");
			
			if (userid != null) {
				isLogin = true;
			}
			
			System.out.println("isLogin = " + isLogin);
		}
		
		return isLogin;
	}
}
