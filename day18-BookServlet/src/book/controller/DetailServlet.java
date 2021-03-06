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
import book.exception.NotFoundException;
import book.vo.Book;

/**
 * 도서코드(bookId)를 파라미터로 받아서
 * 도서 한 건의 정보를 상세조회하고
 * 상세보기 뷰로 이동하는 서블릿
 * @author PC38209
 *
 */
@WebServlet({"/detail", "/main/detail"})
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글처리
		
		//2. 모델 생성
		// (1) 화면에서 넘어온 파라미터 추출
		//	   조회할 도서 코드
		String bookId = request.getParameter("bookId");
		
		// (2)추출한 도서코드를 가지는 Book객체로 포장
		Book book = new Book(bookId);
		
		BookShelf bookShelf;
		bookShelf = (BookShelf) getServletContext().getAttribute("bookShelf");
		
		//3. View 객체 선언
		String view = null;
		String next = null;
		String message = null;
		try {
			//2.(4) DB에서 1건 상세 조회
			Book found = bookShelf.select(book);
			
			//2.(5) 조회된 상세 정보를 request에 속성 추가
			request.setAttribute("book", found);
			//3.(1) 1차 뷰 선택
			view = "/detailJsp";
			
		} catch (NotFoundException e) {
			//조회하려는 제품이 없을 때 메시지 생성
			message = e.getMessage();
			
			//request에 속성 추가
			request.setAttribute("message", message);
			//3.(1) 1차 뷰 선택
			view = "/messageJsp";
			
			//3.(1) 2차 뷰 선택 & 속성으로 추가-->실패 한 경우에만
			next = "main/list";
			request.setAttribute("next", next);
			
			e.printStackTrace();
		}
		
		//3.(3)모델에 맞는 뷰를 생성
		RequestDispatcher reqd;
		reqd = request.getRequestDispatcher(view);
		
		reqd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
