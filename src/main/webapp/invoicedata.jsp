<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Invoice</title>
<link rel="stylesheet" href="/Css/invoicedata.css">
<script type="text/javascript" src="JS/invoiceGen.js"></script>
<link rel="shortcut icon" href="/Media/Logo.png" type="image/x-icon">
</head>

<body>
	<header>
		<h1>Invoice</h1>
		<address >
			<p>HalloDoc</p>
			<p>
				Baruipur<br>Kolkata 700144
			</p>
			<p>8172089782</p>
		</address>
	</header>
	<%
	List<List<String>> data = (List<List<String>>) session.getAttribute("invoice");
	int k = 0;
	%>
	<h1>Recipient</h1>
	<form action="saveInvoice" method="post">
	<div>
		<table class="data">
			<tr>
				<th><span >Customer Name</span></th>
				<td><input type="text" name="CustomerName" required></td>
			</tr>
			<tr>
				<th><span >Visit Date</span></th>
				<td><input type="date" name="visitDate" required></td>
			</tr>
			<tr>
				<th><span >Contect Number</span></th>
				<td><input type="text" name="number" required></td>
			</tr>
		</table>
		<table class="inventory">
			<thead>
				<tr>
					<th><span >Item</span></th>
					<th><span >Expiry Date</span></th>
					<th><span >Quantity</span></th>
					<th><span >Price</span></th>
				</tr>
			</thead>

			<tbody>
				<%
				for (List<String> i : data) {
				%>
				<tr>
					<td><input type="text" name="medName<%=k%>" id=""
						value=<%=i.get(0)%> ></td>
					<td><input type="text" name="expiryDate<%=k%>" id=""
						value=<%=i.get(1)%>></td>
					<td><input type="number" name="quantity<%=k%>"
						id="quantity<%=k%>" max="<%=Integer.valueOf(i.get(2))%>"
						onkeyup="calculatePrice(<%=k%>,<%=Float.valueOf(i.get(3))%>)" required></td>
					<td><input type="text" name="price<%=k%>" id="price<%=k%>" ></td>
					<td hidden="true"><input type="text" name="medid<%=k%>" value=<%=i.get(4)%> hidden="true"></td>
				</tr>
				<%
				k += 1;
				}
				%>
			</tbody>
			<table class="balance">
				<tr>
					<th><span >Total</span></th>
					<td><input id="total"></td>
				</tr>
			</table>
		</table>
		<input type=number name="count" hidden="true" value=<%=data.size()%>>
		</div>
		<div id="btn">
		<button type="submit">Next</button></div>
	</form>
</body>
</html>