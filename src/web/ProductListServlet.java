package web;

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

@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminProductService service=new AdminProductService();
		List<Product> productList=null;
		try {
			productList=service.getProductList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//把集合放到四大域中
		request.setAttribute("productList", productList);
		//把数据分配给指定的页面
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
