package book.mapper;

import java.util.List;
import java.util.Map;

import book.vo.Book;

public interface BookMapper {
	
	int insert(Book book);
	int update(Book book);
	int delete(Book book);
	String isExists(Book book);
	Book select(Book book);
	List<Book> select();
	List<Book> selectByPrice(Map<String, Integer> prices);
	List<Book> selectByKeyword(String keyword);
	int totalCount();
	

}
