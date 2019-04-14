package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminProductService;

public class AdminDeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		AdminProductService service=new AdminProductService();
		try {
			service.deleteProduct(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//重定向：实现页面跳转的一种方式
		//当点击删除后，会发送一个请求给服务器端，服务器端发现匹配的servlet，并指定它去执行，当这个servlet之心那个完之后，
		//调用getRequestDispacther()方法，把请求转发给指定的list.jsp让页面显示出来
		response.sendRedirect(request.getContextPath()+"/productList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
