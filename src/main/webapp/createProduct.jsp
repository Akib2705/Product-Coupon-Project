<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
</head>
<body>
	<h1>Create Product</h1>
	<form action="products" method="post">
		<pre>
Name:<input type="text" name="name" />
Description:<input type="text" name="description" />
Price:<input type="text" name="price" /> 
CouponCode:<input type="text" name="couponCode" />
Submit:<input type="submit" value="Save" />
</pre>
	</form>
</body>
</html>