package web;
/**
 * 请求添加商品
 */
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Product;
import service.AdminProductService;

@WebServlet("/AdminAddProductServlet")
public class AdminAddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码
		request.setCharacterEncoding("UTF-8");
		Map<String,String[]> map=request.getParameterMap();
		Product product=new Product();
		try {
			//用来将一些 key-value 的值（例如 hashmap）映射到 bean 中的属性
			BeanUtils.populate(product, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		//用户输入7个字段，而数据表中有11个字段，所以需要我们自己添加4个字段
		product.setP_sn(UUID.randomUUID().toString());
		product.setPimage("products/c_0001.jpg");
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String pdate=sdf.format(date);
		product.setPdate(pdate);
		product.setPflag(1);//令1表示上架，0表示下架
		
		AdminProductService service=new AdminProductService();
		try {
			service.addProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//页面重定向
		response.sendRedirect(request.getContextPath()+"/productList");
	}

}
