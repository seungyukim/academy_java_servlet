package book.dao;

import java.util.List;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.vo.Book;

/**
 * 책(Book) 정보를 저장할 책장을 나타내는 인터페이스  
 * @author PC38206
 *
 */
public interface BookShelf {

	/**
	 * 매개변수로 전달된 book 정보 1건을 신규로 추가함<br/> 
	 * @param book : 신규로 추가할 책 정보를 담은 객체<br/>
	 * @return 추가된 책 정보의 개수<br/> 추가 성공시 1 리턴<br/>
	 * @throws DuplicateException 이미 동일한 아이디를 가진 책정보가 등록되어있는 경우 발생<br/>
	 */
	public abstract int insert(Book book) throws DuplicateException;
	
	/**
	 * 매개변수로 전달된 book 정보 1건을 수정함<br/>
	 * @param book : 수정할 책 정보를 담은 객체<br/>
	 * @return 수정된 책 정보의 개수<br/> 수정 성공시 1 리턴<br/>
	 * @throws NotFoundException 수정하려는 아이디에 해당하는 책정보가 없는 경우 발생<br/>
	 */
	int update(Book book) throws NotFoundException;
	
	/**
	 * 매개변수로 전달된 book 정보 1건을 삭제함<br/>
	 * @param book : 삭제할 책 정보를 담은 객체<br/>
	 * @return 삭제된 책 정보의 개수<br/> 삭제 성공시 1 리턴<br/>
	 * @throws NotFoundException 삭제하려는 아이디에 해당하는 책정보가 없는 경우 발생<br/>
	 */
	int delete(Book book) throws NotFoundException;
	
	/**
	 * 매개변수로 전달된 book 정보 1건을 상세조회 함<br/>
	 * @param book : 조회할 책의 아이디를 담고 있는 객체<br/>
	 * @return 조회할 책의 전체 상세 정보를 담은 객체
	 * @throws NotFoundException 조회하려는 아이디에 해당하는 책정보가 없는 경우 발생<br/>
	 */
	Book select(Book book) throws NotFoundException;
	
	/**
	 * 등록되어 있는 책 전체 목록을 조회
	 * @return 전체 책 목록
	 */
	List<Book> select();
	
	/**
	 * 매개변수로 전달된 최저가(low) 에서 최고가(high) 사이의 가격대에 해당하는<br/>
	 * 책을 검색하여 목록으로 리턴한다
	 * @param low  : 검색조건 최저가
	 * @param high : 검색조건 최고가
	 * @return 가격 조건에 맞는 책의 목록
	 */
	List<Book> select(int low, int high);
	
	/**
	 * 매개변수로 전달된 검색어(keyword)가 제목에 포함된<br/> 
	 * 책을 검색하여 목록으로 리턴한다
	 * @param keyword : 검색어
	 * @return 검색 조건에 맞는 책의 목록
	 */
	List<Book> select(String keyword);
	
	/**
	 * 등록된 책의 개수를 리턴한다
	 * @return 등록된 책의 개수
	 */
	int totalCount();
	
}
