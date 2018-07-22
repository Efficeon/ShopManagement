package dao.jdbc;

import dao.ProductsDao;
import model.Products;
import model.enumerations.Status;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsJdbcDao extends ConnectionJdbcDao implements ProductsDao {
    private static final String SQL_INSERT = "INSERT INTO products (id, products_title, price, status, category_id) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE_BY_ID = "UPDATE products SET products_title=?, price = ?, status=?, category_id=? WHERE id=?";
    private static final String SQL_SELECT_BY_CATEGORY_ID = "SELECT * FROM products WHERE category_id = ?";

    @Override
    public void create(Products product) {
        init();
        PreparedStatement ps=null;
        try{ ps= getPreparedStatement(SQL_INSERT);
            ps.setInt(1, product.getId());
            ps.setString(2, product.getTitle());
            ps.setFloat(3, product.getPrice());
            ps.setString(4, String.valueOf(product.getStatus()));
            ps.setInt(5, product.getCategoryId());

            ps.executeUpdate();
            System.out.println("Products: " +  product.getId() + " was create.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
    }

    @Override
    public void update(Products product) {
        init();
        PreparedStatement ps = null;
        try {
            ps = getPreparedStatement(SQL_UPDATE_BY_ID);
            ps.setString(1, product.getTitle());
            ps.setFloat(2, product.getPrice());
            ps.setString(3, String.valueOf(product.getStatus()));
            ps.setInt(4, product.getCategoryId());
            ps.setInt(5, product.getId());

            ps.executeUpdate();
            System.out.println("Products: " +  product.getId() + " was update.");

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }

    }

    @Override
    public List<Products> getByCategoriesId(int id) {
        init();
        List<Products> products = new ArrayList<>();
        PreparedStatement ps = null;
        try{ps = getPreparedStatement(SQL_SELECT_BY_CATEGORY_ID);
            ps.setInt(1, id );
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Products product = new Products();
                product.setId(rs.getInt(1));
                product.setTitle(rs.getString(2));
                product.setPrice(rs.getFloat(3));
                product.setStatus(Status.fromString(rs.getString(4)));
                product.setCategoryId(rs.getInt(5));
                products.add(product);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return products;
    }
}
