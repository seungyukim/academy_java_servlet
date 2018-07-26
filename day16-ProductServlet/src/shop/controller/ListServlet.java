package shop.controller;

import static shop.factory.WarehouseFactory.getWarehouse;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dao.GeneralWarehouse;
import shop.vo.Product;
/**
 * 제품 전체 목록을 조회하는 서블릿
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글설정
		//(1)요청 설정
		request.setCharacterEncoding("utf-8");
		
		//(2)응답설정
		//   응답은 jsp에서 담당할 것이므로 불필요
		
		//2.조회에 필요한 객체 선언
		GeneralWarehouse warehouse;
		warehouse = getWarehouse("mybatis");

		//3.조회 결과를 request에 속성으로 추가
		List<Product> products = warehouse.getAllProducts();
		request.setAttribute("products", products);
		
		//4.조회 결과가 추가된 request를
		//적절한 목록 view(list.jsp)로 전달(페이지이동)
		RequestDispatcher reqd;
		reqd = request.getRequestDispatcher("listJsp");
		
		reqd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
