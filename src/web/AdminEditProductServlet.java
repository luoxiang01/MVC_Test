package web;

import domain.Product;
import org.apache.commons.beanutils.BeanUtils;
import service.AdminProductService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class AdminEditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //解决中文乱码
        request.setCharacterEncoding("UTF-8");
        String pid=request.getParameter("pid");

        Product product=new Product();
        Map<String,String[]> map=request.getParameterMap();
        try {
            BeanUtils.populate(product, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        product.setP_sn(UUID.randomUUID().toString());
        product.setPimage("products/c_0001.jpg");
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String pdate=sdf.format(date);
        product.setPdate(pdate);
        product.setPflag(1);//令1表示上架，0表示下架

        AdminProductService service=new AdminProductService();
        try {
            service.editProduct(product,pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //页面重定向
        response.sendRedirect(request.getContextPath()+"/productList");
    }

}