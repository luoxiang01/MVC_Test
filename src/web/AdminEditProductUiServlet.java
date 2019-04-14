package web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Category;
import domain.Product;
import org.apache.commons.beanutils.BeanUtils;
import service.AdminProductService;

@WebServlet("/exitProductUi")
public class AdminEditProductUiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminProductService service=new AdminProductService();
		String pid=request.getParameter("pid");
		List<Category> categoryList=null;
		List<Product> productInfo=null;
		try {
			categoryList=service.getAllCategory();
			productInfo=service.getPidProduct(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("productInfo", productInfo);
		request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
	}

}
