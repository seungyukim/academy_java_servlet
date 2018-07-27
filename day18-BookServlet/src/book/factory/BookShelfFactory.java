package book.factory;

import book.dao.BookShelf;
import book.dao.MybatisBookShelf;

public class BookShelfFactory {

	public static BookShelf getBookShelf(String type) {
		BookShelf shelf = null;
		
		if ("mybatis".equals(type)) {
			shelf = new MybatisBookShelf();
		}
		
		return shelf;
	}
}
