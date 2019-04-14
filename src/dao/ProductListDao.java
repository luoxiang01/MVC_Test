package dao;
/**
 * 连接数据库，查询数据表中所有的商品信息
 */
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import domain.Product;

public class ProductListDao {
	//从数据表product中获取信息
	public List<Product> getProductList() throws SQLException{
		//连接数据表进行查询
		QueryRunner runner=new QueryRunner(new ComboPooledDataSource());
		String sql="select * from product";
		return runner.query(sql, new BeanListHandler<Product>(Product.class));
	}
}
