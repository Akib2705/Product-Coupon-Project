package com.productDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Product;
import com.util.ConnectionUtil;

public class ProductImpl implements ProductDao {

	@Override
	public void save(Product product) {
		Connection connection = ConnectionUtil.getConnection();

		try {
			PreparedStatement pstmt = connection.prepareStatement("insert into product (name,description,price)values(?,?,?)");

			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getDescription());
			pstmt.setBigDecimal(3, product.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
