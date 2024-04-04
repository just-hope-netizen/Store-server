package com.netizen.storeserver.repo;

import com.netizen.storeserver.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StoreRepo {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addProduct(Product product){
        String query ="INSERT INTO product (productId, name, category, imageUrl, inStock, price) VALUES (?,?,?,?,?,?)";
        int rows = jdbcTemplate.update(query, product.getProductId(), product.getName(), product.getCategory(), product.getImageUrl(), product.isInStock(), product.getPrice());
        System.out.println(rows);
    }

    public List<Product> findAll() {
        String query ="SELECT * FROM PRODUCT";
        RowMapper<Product> rowMapper = new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
               Product product = new Product();
               product.setProductId(rs.getInt("productId"));
               product.setName(rs.getString("name"));
               product.setCategory(rs.getString("category"));
               product.setImageUrl(rs.getString("imageUrl"));
               product.setInStock(rs.getBoolean("inStock"));
               product.setPrice(rs.getInt("price"));
                return product;
            }
        };
       return jdbcTemplate.query(query, rowMapper);
    }

    public List<Product> findAllByName(String q) {
        String sql= "SELECT * FROM product WHERE name Like '%" + q +"%' OR category   lIKE '%" + q +"%'";
        System.out.println(sql);
        RowMapper<Product> rowMapper = (rs, rowNum) -> {
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setName(rs.getString("name"));
            product.setCategory(rs.getString("category"));
            product.setImageUrl(rs.getString("imageUrl"));
            product.setInStock(rs.getBoolean("inStock"));
            product.setPrice(rs.getInt("price"));
            return product;
        };
        return jdbcTemplate.query(sql, rowMapper);
    }
}
