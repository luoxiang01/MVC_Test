package web;
/**
 * 请求显示商品列表
 * 一方面，向service层请求逻辑操作
 * 另一方面，将service返回的逻辑操作显示到jsp页面中
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import service.AdminProductService;

@WebServlet("/AdminListProductUiServlet")
public class AdminListProductUiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminProductService service=new AdminProductService();
		List<Product> productList=null;
		try {
			productList=service.getProductList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
