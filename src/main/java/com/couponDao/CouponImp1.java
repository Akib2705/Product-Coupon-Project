package com.couponDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Coupon;
import com.util.ConnectionUtil;

public class CouponImp1 implements CouponDao {

	@Override
	public void save(Coupon coupon) {
		Connection connection = ConnectionUtil.getConnection();

		try {
			PreparedStatement pstmt = connection
					.prepareStatement("insert into coupon (code,discount,exp_date) values(?,?,?)");
			pstmt.setString(1, coupon.getCode());
			pstmt.setBigDecimal(2, coupon.getDiscount());
			pstmt.setString(3, coupon.getExpDate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Coupon findByCode(String code) {
		Coupon coupon = new Coupon();
		Connection connection = ConnectionUtil.getConnection();

		try {
			PreparedStatement pstmt = connection.prepareStatement("Select * from coupon where code=?");
			pstmt.setString(1, code);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				coupon.setId(resultSet.getInt(1));
				coupon.setCode(resultSet.getString(2));
				coupon.setDiscount(resultSet.getBigDecimal(3));
				coupon.setExpDate(resultSet.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coupon;
	}

}
