package book.exception;

import book.vo.Book;

/**
 * 신규 입력 할 때, 책 정보가 
 * 중복인 경우 발생시킬 예외를 정의한 클래스
 * 
 * @author PC38206
 *
 */
public class DuplicateException extends Exception {

	// 기본 생성자
	public DuplicateException() {
		super("책 정보가 중복되었습니다.");
	}
	
	// 매개변수가 있는 생성자
	public DuplicateException(String type, Book book) {
		super(String.format("[%s]:책[%s:%s] 정보가 중복되었습니다."
				          , type, book.getBookId(), book.getTitle()));
		
	}
}






