package com.couponDao;

import com.model.Coupon;

public interface CouponDao {

	void save(Coupon coupon);

	Coupon findByCode(String code);
	
	



}
