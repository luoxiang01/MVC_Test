package web;
/**
 * 向发布商品页面动态添加商品类型
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import service.AdminProductService;

@WebServlet("/AdminAddProductUiServlet")
public class AdminAddProductUiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminProductService service=new AdminProductService();
		List<Category> categoryList=null;
		try {
			categoryList = service.getAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("/admin/product/add.jsp").forward(request , response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
