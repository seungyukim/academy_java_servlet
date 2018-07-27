package book.exception;

import book.vo.Book;

/**
 * 수정, 삭제 작업 중 대상 책이 없는 경우 
 * 발생시킬 예외를 정의한 클래스
 * 
 * @author PC38206
 *
 */
public class NotFoundException extends Exception {

	public NotFoundException() {
		super("책 정보가 존재하지 않습니다.");
	}
	
	public NotFoundException(String type, Book book) {
		super(String.format("[%s]:책[%s:%s] 정보가 존재하지 않습니다."
		                   , type, book.getBookId(), book.getTitle()));
	}
	
}





