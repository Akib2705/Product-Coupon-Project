package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.couponDao.CouponDao;
import com.couponDao.CouponImp1;
import com.model.Coupon;

@WebServlet("/cand")
public class CouponController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CouponDao dao = new CouponImp1();

	public CouponController() {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("create")) {
			createCoupon(request, response);
		} else if (action.equals("find")) {
			findCoupon(request, response);
		}
	}

	private void createCoupon(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String CouponCode = request.getParameter("CouponCode");
		String discount = request.getParameter("discount");
		String expiryDate = request.getParameter("expiryDate");
		Coupon coupon = new Coupon();
		coupon.setCode(CouponCode);
		coupon.setDiscount(new BigDecimal(discount));
		coupon.setExpDate(expiryDate);
		dao.save(coupon);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Coupon Created!!</b>");
		out.print("<br/><a href='index.html'>Home</a>");

	}

	public void findCoupon(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String CouponCode = request.getParameter("couponCode");
		System.out.println(CouponCode);
		Coupon coupon = dao.findByCode(CouponCode);
		System.out.println(coupon.getCode());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Coupon Details:</b>");
		out.print(coupon);
		out.print("<br/><a href='index.html'>Home</a>");

	}
}
