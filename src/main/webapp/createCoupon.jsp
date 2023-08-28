<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Coupon</title>
</head>

<body>
	<h1>Create Coupon</h1>
	<form action="cand" method="post">
		<pre>
Coupon Code:<input type="text" name="CouponCode" />
Discount:<input type="text" name="discount" />
Expiry Date:<input type="date" name="expiryDate" />
<input type="hidden" name="action" value="create">
<input type="submit" value="Save">
</pre>
	</form>


</body>
</html>