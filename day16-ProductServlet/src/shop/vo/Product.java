package shop.vo;

/**
 * 제품 판매 매장에서 관리하는 대상인
 * 제품을 정의하는 클래스
 * ------------------------------------------------------
 * 캡슐화를 적용하여 모든 데이터 필드는 private 으로 선언
 * 
 * 제품번호 : prodCode : String
 * 제품 명  : prodName : String
 * 가격     : price    : int
 * 재고수량 : quantity : int
 * -------------------------------------------------------
 * 기본생성자, 매개변수를 받는 생성자 각 필드 1개씩 늘려가며
 * 생성자 중복정의로 5개의 생성자를 정의 this, this() 사용
 * --------------------------------------------------------
 * 메소드 
 * print() : void 
 *    ==> 제품의 상태 출력
 * discount(double percentage) : int 
 *    ==>입력된 퍼센트만큼 할인가격 리턴
 * sell(int amount) : void 
 *    ==> 매장에서 판매(출고)되어 재고수량이 줄어듬
 * buy(int amount) : void
 *    ==> 매장에 입고되어 재고수량이 늘어남
 * ---------------------------------------------------------
 * @author PC38206
 *
 */
public class Product {
	
	// 1. 멤버 변수 선언부
	/** 제품 코드 */
	private String prodCode;
	/** 제품 명 */
	private String prodName;
	/** 제품 가격 */
	private int price;
	/** 재고 수량 */
	private int quantity;
	
	// 2. 생성자 선언부
	/**
	 * 기본 생성자
	 */
	public Product() {
		
	}
	
	/**
	 * 제품 코드 필드만 초기화하는 생성자
	 * @param prodCode
	 */
	public Product(String prodCode) {
		this.prodCode = prodCode;
	}
	
	/**
	 * 모든 필드를 초기화하는 생성자
	 * @param prodCode
	 * @param prodName
	 * @param price
	 * @param quantity
	 */
	public Product(String prodCode, String prodName, int price, int quantity) {
		this(prodCode);
		this.prodName = prodName;
		this.price = price;
		this.quantity = quantity;
	}
	
	/* -----------------------------------------------
 	 * 멤버 변수 필드의 가시성을 private 으로 선언하면
	 * 다른 모든 클래스에서 접근이 불가능해진다.
	 * 따라서 숨겨진 필드에 접근할 수 있는 전용 메소드 쌍을
	 * 정의해야 한다.
	 * ================================================
	 * 접근자 메소드 : getter 
	 * ------------------------------------------------
	 * 1. get 으로 시작
	 * 2. get 뒤에 오는 이름은 접근하려는 멤버변수 명의
	 *    첫 글자만 대문자화 하여 정의한다.
	 * 3. 메소드 매개변수가 없다.
	 * 4. 메소드 리턴 타입을 접근하려는 멤버변수 타입과 맞춘다.
	 * 5. 멤버변수의 타입이 boolean 이면 
	 *    get 이 아니라 is 로 시작하도록 작성
	 * 6. getXxx() , isXxx() 형태로 정의
	 * ================================================
	 * 수정자 메소드 : setter
	 * ------------------------------------------------
	 * 1. set 으로 시작
	 * 2. set 뒤에 오는 이름은 수정하려는 멤버변수 명의
	 *    첫 글자만 대문자화하여 정의한다.
	 * 3. 메소드 매개 변수는 수정하려는 멤버변수의 타입과
	 *    맞추고, 보통 같은 이름으로 설정
	 * 4. 리턴 타입은 void 로 한다.
	 * 5. 보통 안쪽의 로직은 
	 *    this.멤버변수 = 매개변수; 작성
	 * ================================================
	 * */
	
	/** prodCode 의 접근자 */
	public String getProdCode() {
		return this.prodCode;
	}
	
	/** prodCode 의 수정자 */
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	
	/** prodName 의 접근자 */
	public String getProdName() {
		return prodName;
	}

	/** prodName 의 수정자 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	/** price 의 접근자 */
	public int getPrice() {
		return price;
	}

	/** price 의 수정자 */
	public void setPrice(int price) {
		this.price = price;
	}

	/** quantity 의 접근자 */
	public int getQuantity() {
		return quantity;
	}

	/** quantity 의 수정자 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// 3. 메소드 선언부
	/**
	 * 제품 정보를 출력
	 */
	public void print() {
		System.out.printf("제품 정보 [제품코드 : %s, 제품명 : %s"
				         + ", 가격 %d: , 재고수량 : %d]%n"
				         , prodCode, prodName, price, quantity);
	}
	
	/**
	 * 입력된 percentage만큼 할인을 진행할 경우
	 * 판매 가격이 얼마가 되는지 계산하여 리턴
	 * @param percentage
	 * @return
	 */
	public int discount(double percentage) {
		int price = this.price;
		
		if (percentage > 0) {
			price = price - (int)(this.price * (percentage / 100));
		}
		
		return price;
	}

	/**
	 * 제품을 출고(판매)하고 재고 수량을 감소시킨다.	 
	 * @param amount
	 */
	public void sell(int amount) {
		// 재고 수량이 출고하려는 수량보다 크거나 같을때만
		// 출고함.
		if (this.quantity >= amount) {
			this.quantity -= amount;
		}
	}
	
	/**
	 * 제품이 입고되어 재고 수량을 증가시킨다.
	 * @param amount
	 */
	public void buy(int amount) {
		// 입고된 만큼 재고수량 증가 후 저장반영
		this.quantity += amount;		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prodCode == null) ? 0 : prodCode.hashCode());
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
		Product other = (Product) obj;
		if (prodCode == null) {
			if (other.prodCode != null)
				return false;
		} else if (!prodCode.equals(other.prodCode))
			return false;
		return true;
	}


	// Object 클래스에서 나도 모르는 사이 상속받은
	// toString() 메소드를 재정의 해보자.
	// 1. 메소드 헤더가 동일 : 리턴타입 메소드이름 (매개변수 목록)
	@Override
	public String toString() {
		String strProduct = String.format(
				"제품 정보 [제품코드 : %s, 제품명 : %s"
		                 + ", 가격 %,d: , 재고수량 : %d]%n"
		         , prodCode, prodName, price, quantity);
		return strProduct;
	}

//	// Product 의 객체들은 prodCode 가 같으면 
//	// 동일 객체로 판단
//	@Override
//	public boolean equals(Object obj) {
//		// 1. 동일 비교 결과 저장 변수 선언
//		// 2. 초기화 : 기본 false 설정
//		boolean isEqual = false;
//		
//		// 3. 사용 : 동일한 객체인지 판단
//		// (1) 비교 대상인 obj 가 Product 타입인지 검사
//		if (obj instanceof Product) {
//			// (2) 비교 하려하는 this 객체와
//			//     비교 대상인 obj 간 각각의 필드가 동일한지
//			//     비교
//			Product product = (Product)obj;
//			//     prodCode 만 같으면 같은 객체로 인정
//			if (this.prodCode.equals(product.prodCode)) {
//				isEqual = true;
//			}
//		}
//		
//		return isEqual;
//	}
//
//	@Override
//	public int hashCode() {
//		// 입력이 동일하면 출력도 동일함 보장하는 수학적 알고리즘
//		// 출력이 다르면 입력이 다르다는 결론을 보장하는 함수
//		
//		// 1. 비교하려는 필드가 참조형이면 그 클래스의
//		//    hashCode() 를 호출
//		// 2. 비교하려는 필드가 기본형이면 참조형으로 바꾸는
//		//    포장 클래스 객체로 변환 후에 hashCode() 를 호출
//		// 3. 1, 2 의 결과를 모두 ^ (XOR) 연산을 통과시킨다.
//		
//		return this.prodCode.hashCode();
//	}
	
	
	
	
	
	
	
	
	

}
