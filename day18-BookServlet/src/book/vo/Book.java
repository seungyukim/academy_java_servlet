package book.vo;

public class Book {
	// 1. 멤버 변수 선언
	/** 책을 관리하는 아이디 */
	private String bookId;
	
	/** 책 제목 */
	private String title;
	
	/** 저자 이름 */
	private String author;
	
	/** 책 가격 */
	private int price;
	
	/** 도서 ISBN 13자리 */
	private String isbn;
	
	/** 출판사 */
	private String publish;

	// 2. 생성자 선언
	// (1) 기본 생성자
	public Book() {	}
	
	// (2) 매개변수 받는 생성자
	public Book(String bookId) {
		super();
		this.bookId = bookId;
	}

	public Book(String bookId, String title, String author, int price, String isbn, String publish) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
		this.publish = publish;
	}
	
	

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String bookStr = String.format("책 정보[책 아이디:%s, 제목:%s, 저자:%s, 가격:%d, ISBN:%s, 출판사:%s"
				        , bookId, title, author, price, isbn, publish);
		return bookStr;
	}
	
	
	
}
