package service;
/**
 * 统筹web层的各种请求，并将这些请求分配给dao层中每一个具体的类，然后将结果返回给web层
 */
import java.sql.SQLException;
import java.util.List;

import dao.AdminProductDao;
import dao.ProductListDao;
import domain.Category;
import domain.Product;

public class AdminProductService {
	//显示商品列表
	public List<Product> getProductList() throws SQLException{
		ProductListDao dao=new ProductListDao();
		List<Product> productList=dao.getProductList();
		return productList;
	}
	//后台商品分类
	public List<Category> getAllCategory() throws SQLException {
		AdminProductDao dao=new AdminProductDao();
		List<Category> categoryList=dao.getAllCategory();
		return categoryList;
	}
	//后台添加商品
	public void addProduct(Product product) throws SQLException {
		AdminProductDao dao=new AdminProductDao();
		dao.addProduct(product);
	}
	//后台删除商品
	public void deleteProduct(String pid) throws SQLException {
		AdminProductDao dao=new AdminProductDao();
		dao.deleteProduct(pid);
	}
	//获取指定pid商品的信息到edit.jsp页面
	public List<Product> getPidProduct(String pid) throws SQLException{
		AdminProductDao dao=new AdminProductDao();
		return dao.getPidProduct(pid);
	}
	//修改指定pid商品信息
    public void editProduct(Product product,String pid) throws SQLException{
	    AdminProductDao dao=new AdminProductDao();
	    dao.editProduct(product,pid);
    }
}
