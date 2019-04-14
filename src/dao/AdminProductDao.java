package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import domain.Category;
import domain.Product;

public class AdminProductDao {
    //从数据表查询信息
    public List<Category> getAllCategory() throws SQLException {
        QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
        String sql = "select * from category";
        return runner.query(sql, new BeanListHandler<Category>(Category.class));
    }

    //向数据表插入商品
    public void addProduct(Product product) throws SQLException {
        QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
        String sql = "insert into product values(null,?,?,?,?,?,?,?,?,?,?)";
        runner.update(sql, product.getP_sn(), product.getPname(),
                product.getMarket_price(), product.getShop_price(),
                product.getPimage(), product.getPdate(),
                product.getIs_hot(), product.getPdesc(),
                product.getPflag(), product.getCid());
    }

    //从数据表删除信息
    public void deleteProduct(String pid) throws SQLException {
        QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
        String sql = "delete from product where pid=?";
        runner.update(sql, pid);
    }

    //从数据表查询指定pid的商品信息
    public List<Product> getPidProduct(String pid) throws SQLException {
        QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
        String sql = "select * from product where pid=?";
        Object params[]={pid};
        return runner.query(sql, new BeanListHandler<Product>(Product.class),params);
    }
    //修改指定pid的商品信息
    public void editProduct(Product product,String pid) throws SQLException {
        QueryRunner runner=new QueryRunner(new ComboPooledDataSource());
        String sql="update product set pname=?,is_hot=?," +
                "market_price=?,shop_price=?,pimage=?,cid=?,pdesc=? where pid=?";
        runner.update(sql,product.getPname(),product.getIs_hot(),product.getMarket_price(),
                product.getShop_price(),product.getPimage(),product.getCid(),product.getPdesc(),pid);
    }
}
