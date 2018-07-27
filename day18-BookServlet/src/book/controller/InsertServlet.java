package book.controller;

import static book.factory.BookShelfFactory.getBookShelf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.dao.BookShelf;
import book.exception.DuplicateException;
import book.vo.Book;

/**
 * 
 * @author PC38209
 *
 */
@WebServlet({"/insert", "/main/insert"})
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * menu.jsp에서 링크를 클릭했을 때 발생하는
	 * 신규도서 등록 요청을 처리한다.
	 * insert.jsp로 이동
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//뷰를 결정
		String view ="/insertJsp";
		
		//RequestDispatcher로 이동
		RequestDispatcher reqd;
		reqd = request.getRequestDispatcher(view);
		
		reqd.forward(request, response);
	}

	/**
	 * insert.jsp에서 등록하기 버튼이 클릭되었을 때
	 * post요청을 처리한다
	 * 내부적으로 insert.jsp의 form으로 전달된
	 * 파라미터를 추출하여 Product객체로 포장하고
	 * insert쿼리를 실행
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글처리
		
		//2.모델생성
		// (1)insert.jsp에서 넘어온 파라미터 추출
		String bookId = request.getParameter("bookId");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String isbn = request.getParameter("isbn");
		String publish = request.getParameter("publish");
		
		// (2)Book 타입으로 포장
		Book book = new Book(bookId, title, author, price, isbn, publish);
		
		// (3)DB 입력에 필요한 객체 선언
		BookShelf bookShelf;
		bookShelf = (BookShelf) getServletContext().getAttribute("bookShelf");
		
		//  DB입력 성공/ 실패시 발생하는 메시지
		String message = null;
		
		//3.(2) 메시지 출력 후 이동할 뷰 페이지
		String next = "";
		
		try {
			// (4)insert 쿼리 수행
			bookShelf.insert(book);
			message = String.format("도서 정보 [%s] 추가에 성공하였습니다", book.getBookId());
			
			//추가 성공 후 전체 목록으로 자동 이동
			next = "main/list";
		} catch (DuplicateException e) {
			message = String.format(e.getMessage());
			e.printStackTrace();
		}
		
		// (5)추가 성공 / 실패에 따른 발생 메시지를
		//	  request에 속성으로 추가
		request.setAttribute("message", message);
		
		//3. View 결정
		// (1) 추가 성공/ 실패 메시지를 출력할 1차 뷰
		String view ="/messageJsp";
		
		// (2)2차 뷰 선택된 내용을 request에 속성으로 추가
		request.setAttribute("next", next);
		
		RequestDispatcher reqd;
		reqd = request.getRequestDispatcher(view);
		
		reqd.forward(request, response);
	}

}
