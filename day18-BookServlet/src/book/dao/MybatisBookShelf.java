package book.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.mapper.BookMapper;
import book.mybatis.MybatisClient;
import book.vo.Book;

/**
 * mybatis 로 구현
 * @author HannaC
 *
 */
public class MybatisBookShelf implements BookShelf {
	
	private SqlSessionFactory factory;
	
	public MybatisBookShelf() {
		super();
		factory = MybatisClient.getFactory();
	}

	@Override
	public int insert(Book book) throws DuplicateException {
		
		if (isExists(book)) {
			throw new DuplicateException("추가", book);
		}
		
		int addCnt = 0;
		SqlSession session = factory.openSession(true);
		
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			addCnt = mapper.insert(book);
			
		} finally {
			if (session != null) 
				session.close();
		}
		
		return addCnt;
	}

	@Override
	public int update(Book book) throws NotFoundException {
		
		if (!isExists(book) ) {
			throw new NotFoundException("수정", book);
		}
		
		int setCnt = 0;
		SqlSession session = factory.openSession(true);
		
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			setCnt = mapper.update(book);
			
		} finally {
			if (session != null)
				session.close();
		}
		
		return setCnt;
	}

	@Override
	public int delete(Book book) throws NotFoundException {
		
		if (!isExists(book)) {
			throw new NotFoundException("삭제", book);
		}
		
		int rmCnt = 0;
		SqlSession session = factory.openSession(true);
		
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			rmCnt = mapper.delete(book);
			
		} finally {
			if (session != null)
				session.close();
		}
		
		return rmCnt;
	}

	@Override
	public Book select(Book book) throws NotFoundException {
			
		if (!isExists(book)) {
			throw new NotFoundException("조회", book);
		}
		
		Book found = null;
		SqlSession session = factory.openSession();
		
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			found = (Book) mapper.select(book);
			
		} finally {
			if (session != null)
				session.close();
		}
		
		return found;
	}

	@Override
	public List<Book> select() {
		List<Book> books = null;
		
		SqlSession session = factory.openSession();
		
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			books = (List<Book>) mapper.select();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return books;
	}

	@Override
	public List<Book> select(int low, int high) {
		List<Book> books = null;
		
		SqlSession session = factory.openSession();
		
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			
			Map<String, Integer> prices = new HashMap<>();
			prices.put("low", low);
			prices.put("high", high);
			
			books = mapper.selectByPrice(prices);
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return books;
	}

	@Override
	public List<Book> select(String keyword) {
		List<Book> books = null;
		
		SqlSession session = factory.openSession();
		
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			books = mapper.selectByKeyword(keyword);
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return books;
	}

	@Override
	public int totalCount() {
		int totalCount = 0;
		SqlSession session = factory.openSession();
		
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			totalCount = mapper.totalCount();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return totalCount;
	}
	
	private boolean isExists(Book book) {
		boolean isExists = false;
		
		SqlSession session = factory.openSession();
		
		try {
			BookMapper mapper = session.getMapper(BookMapper.class);
			String bookId = mapper.isExists(book);
			
			if (bookId != null) {
				isExists = true;
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return isExists;
	}

}
