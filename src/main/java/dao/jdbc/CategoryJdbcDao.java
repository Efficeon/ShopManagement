package dao.jdbc;

import dao.CategoryDao;
import dao.ProductsDao;
import model.Category;
import model.enumerations.CategoryTitle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryJdbcDao extends ConnectionJdbcDao implements CategoryDao {
    private static final String SQL_SELECT_BY_SHOP_ID = "SELECT * FROM category WHERE shops_id = ?";


    @Override
    public List<Category> getByShopId(int id) {
        ProductsDao productsDao = new ProductsJdbcDao();
        init();
        List<Category> categories = new ArrayList<>();
        PreparedStatement ps = null;
        try{ps = getPreparedStatement(SQL_SELECT_BY_SHOP_ID);
            ps.setInt(1, id );
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setCategoryTitle(CategoryTitle.fromString(rs.getString("category_title")));
                category.setShopsId(rs.getInt("shops_id"));
                category.setProducts(productsDao.getByCategoriesId(rs.getInt("id")));
                categories.add(category);
            }


        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(ps);
        }
        return categories;
    }
}
