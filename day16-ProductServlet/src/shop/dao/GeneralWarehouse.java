package shop.dao;

import java.util.List;

import shop.exception.DuplicateException;
import shop.exception.NotFoundException;
import shop.vo.Product;

/**
 * 제품을 관리하기 위한 창고의 기능을 
 * 선언한 인터페이스
 * @author PC38206
 *
 */
public interface GeneralWarehouse {

	/**
	 * Product 정보 1건을 추가함 <br/>s
	 * -----------------------------------------------------<br/>
	 * 추가하는 과정에서 추가할 제품이 이미 존재하면 0을 리턴하고<br/>
	 * 동일 데이터가 존재하지 않아 추가에 성공하면 1을 리턴함 <br/>
	 * ------------------------------------------------------<br/>
	 * @param product : 추가할 제품 정보<br/>
	 * @return 0 : 동일한 데이터가 존재하는 경우 추가 실패 <br/>
	 * 		   1 : 추가 성공<br/>
	 */
	public abstract int add(Product product) throws DuplicateException;
	
	/**
	 * Product 정보 1개를 조회함<br/>
	 * ------------------------------------------------------------------<br/>
	 * @param product : 조회할 제품정보의 코드값(prodCode)만 담고있는 객체<br/>
	 * @return 매개변수로 입력된 product 와 동일한 제품정보<br/>
	 *         null : 조회할 제품정보가 존재하지 않음<br/>
	 */
	public abstract Product get(Product product) throws NotFoundException;
	
	/**
	 * Product 1개의 정보를 수정함<br/>
	 * 수정하는 과정에서 수정할 제품 인덱스가<br/> 
	 * -1 보다 크게 나와 성공한 경우 <br/>
	 * 수정 성공을 의미하는 1을 리턴<br/>
	 * ----------------------------------------------------------------------<br/>
	 * @param product : 수정할 제품정보의 코드값(prodCode)만 담고있는 객체<br/>
	 * @return 0 : 수정할 제품 정보가 존재하지 않아서 실패함<br/>
	 *         1 : 수정 성공함 <br/>
	 */
	public abstract int set(Product product) throws NotFoundException;
	
	/**
	 * Product 1개의 정보를 삭제함<br/>
	 * 삭제하는 과정에서 삭제할 인덱스가<br/> 
	 * -1 보다 크게 나와 성공한 경우 <br/>
	 * 삭제 성공을 의미하는 1을 리턴<br/>
	 * ----------------------------------------------------------------------<br/>
	 * @param product : 삭제할 제품정보의 코드값(prodCode)만 담고있는 객체<br/>
	 * @return 0 : 삭제할 제품 정보가 존재하지 않아서 실패함<br/>
	 *         1 : 삭제 성공함<br/>
	 */
	public abstract int remove(Product product) throws NotFoundException;
	
	/**
	 * 전체 제품 목록을 List<Product> 타입으로 바꾸어 리턴한다.<br/>
	 * 실제로 어떤 자료구조로 저장하는지는 중요하지 않음.<br/>
	 * @param 전체 제품 목록<br/>
	 */
	public abstract List<Product> getAllProducts();
}




