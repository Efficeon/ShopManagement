package dao.jdbc;

import dao.CategoryDao;
import dao.ShopDao;
import model.Shop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopJdbcDao extends ConnectionJdbcDao implements ShopDao {
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM shops WHERE id = ?";

    @Override
    public Shop read(Shop shop) {
        CategoryDao categoryDao = new CategoryJdbcDao();
        init();
        PreparedStatement ps = null;
        try {
            ps = getPreparedStatement(SQL_SELECT_BY_ID);
            ps.setInt(1, shop.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                shop.setId(rs.getInt(1));
                shop.setTitle(rs.getString(1));
            }
            shop.setCategories(categoryDao.getByShopId(shop.getId()));
        } catch (SQLException ex) {
            System.err.println(new java.util.Date()+" : "+ex.getMessage());
        } finally {
            closeStatement(ps);
        }

        return shop;
    }
}
