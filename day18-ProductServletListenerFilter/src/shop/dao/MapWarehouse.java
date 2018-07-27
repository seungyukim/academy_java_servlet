package shop.dao;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shop.exception.DuplicateException;
import shop.exception.NotFoundException;
import shop.vo.Product;

public class MapWarehouse implements GeneralWarehouse {
	
	// 1. 멤버 변수 선언 : 제품정보를 저장할 맵
	Map<String, Product> products;
	
	// 2. 생성자
	// (1) 기본 생성자
	public MapWarehouse() {
		super();
		products = new HashMap<>();
	}

	// (2) 매개변수를 받는 생성자
	public MapWarehouse(Map<String, Product> products) {
		super();
		this.products = products;
	}

	@Override
	public int add(Product product) throws DuplicateException {
		int addCnt = 0;
		
		// 같은 객체가 있는지 검사
		if (!isExists(product)) {
			products.put(product.getProdCode(), product);
			addCnt++;
		} else {
			// 같은 객체가 존재함
			throw new DuplicateException("add", product);
		}
		
		return addCnt;
	}

	@Override
	public Product get(Product product) throws NotFoundException {
		Product found = null;
		
		if (isExists(product)) {
			found = products.get(product.getProdCode());
		} else {
			// 조회할 제품이 존재하지 않음
			throw new NotFoundException("get", product);
		}
		
		return found;
	}

	@Override
	public int set(Product product) throws NotFoundException {
		int setCnt = 0;
		
		if (isExists(product)) {
			products.replace(product.getProdCode(), product);
			setCnt++;
		} else {
			// 수정할 제품이 존재하지 않음
			throw new NotFoundException("set", product);
		}
		
		return setCnt;
	}

	@Override
	public int remove(Product product) throws NotFoundException {
		int rmCnt = 0;
		
		if (isExists(product)) {
			products.remove(product.getProdCode());
			rmCnt++;
		} else {
			// 삭제할 제품이 존재하지 않음
			throw new NotFoundException("remove", product);
		}
		
		return rmCnt;
	}

	@Override
	public List<Product> getAllProducts() {
		Collection<Product> collection = products.values();
		Product[] prodArr = new Product[collection.size()];
		
		return Arrays.asList(collection.toArray(prodArr));
	}

	// 제품이 이미 존재하는지 여부 확인
	// true  : 존재함
	// false : 없음
	private boolean isExists(Product product) {
		return products.containsKey(product.getProdCode());
	}
}
