package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.couponDao.CouponDao;
import com.couponDao.CouponImp1;
import com.model.Coupon;
import com.model.Product;
import com.productDao.ProductDao;
import com.productDao.ProductImpl;

@WebServlet("/products")
public class ProductController extends HttpServlet {
	CouponDao couponDao = new CouponImp1();
	ProductDao productDao = new ProductImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("done");

		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String couponCode = request.getParameter("couponCode");

		Coupon coupon = couponDao.findByCode(couponCode);
		Product product = new Product();

		String expDate = coupon.getExpDate();

		String currentdate = LocalDate.now().toString();

		SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-DD");
		Date date1;
		Date date2;

		try {
			date1 = sdf.parse(currentdate);
			date2 = sdf.parse(expDate);

			System.out.println(sdf.format(date1));
			System.out.println(sdf.format(date2));

			if (date1.before(date2)) {
				product.setName(name);
				product.setDescription(description);
				System.out.println(coupon.getDiscount());

				product.setPrice(new BigDecimal(price).subtract(coupon.getDiscount()));

				productDao.save(product);
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<b>Product Created</b>");
				out.print("<br/><a href='index.html'>Home</a>");

			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();

				out.println("<h1>Your coupon has expired:</h1>");
				out.print("<br/><a href='index.html'>Home</a>");
				
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
