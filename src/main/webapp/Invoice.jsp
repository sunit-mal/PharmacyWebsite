<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<html>
<head>
<meta charset="utf-8">
<title>Invoice</title>
<link rel="stylesheet" href="/Css/invoice.css">
<link rel="shortcut icon" href="/Media/Logo.png" type="image/x-icon">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<%
	List<List<String>> issuemeds = (List<List<String>>) session.getAttribute("issueMeds");
	ArrayList<String> invoideData = (ArrayList<String>)session.getAttribute("invoiceCustomer");
	%>
	<a href="/">Home</a><br><br>
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
	<article>
		<h1>Recipient</h1>
		<table class="data">
			<tr>
				<th><span >Customer Name</span></th>
				<td><span ><%=invoideData.get(0)%></span></td>
			</tr>
			<tr>
				<th><span >Visit Date</span></th>
				<td><span ><%=invoideData.get(1) %></span></td>
			</tr>
			<tr>
				<th><span >Contect Number</span></th>
				<td><span ><%=invoideData.get(2)%></span></td>
			</tr>
		</table>
		<table class="meta">
			<tr>
				<th><span >Invoice #</span></th>
				<td><span ><%=invoideData.get(3)%></span></td>
			</tr>
			<tr>
				<th><span >Date</span></th>
				<td><span ><%=LocalDate.now() %></span></td>
			</tr>
			<tr>
				<th><span >Totel Amount</span></th>
				<td><span id="prefix" >&#8377;</span><span><%=invoideData.get(4)%></span></td>
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
				for (List<String> i : issuemeds) {
				%>
				<tr>
					<td><a class="cut">-</a><span ><%=i.get(0) %></span></td>
					<td><span ><%=i.get(1) %></span></td>
					<td><span ><%=i.get(2) %></span></td>
					<td><span data-prefix>&#8377;</span><span><%=i.get(3) %></span></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<table class="balance">
			<tr>
				<th><span >Total</span></th>
				<td><span data-prefix>&#8377;</span><span><%=invoideData.get(4) %></span></td>
			</tr>
			<tr>
				<th><span >Collect By <%=session.getAttribute("user").toString()%></span></th>
				<td><span data-prefix>&check;</span><span >PAID</span></td>
			</tr>
		</table>
	</article>
	<aside>
		<h1>
			<span >Terms and Condition</span>
		</h1>
		<div >
			<p>Issue Medicine can't be refundable. Thank You !</p>
		</div>
	</aside>

	<button id="printBTN" onclick="window.print()">
		<i class="fa fa-print" style="font-size: 24px">Print</i>
	</button>
</body>
</html>