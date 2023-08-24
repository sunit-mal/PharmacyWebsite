<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice Check</title>
<link rel="stylesheet" href="/Css/bootstrap.css">
<link rel="stylesheet" href="/Css/invoiceCheck.css">
<link rel="shortcut icon" href="/Media/Logo.png" type="image/x-icon">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<img src="/Media/Logo.png" style="width: 4rem; border-radius: 2rem;">&nbsp;
			&nbsp; <a class="navbar-brand" href="#">HalloDoc</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="/entry">Medicine
							Entry</a></li>
					<li class="nav-item"><a class="nav-link" href="/medicinecheck">Medicine
							Check</a></li>
					<li class="nav-item"><a class="nav-link" href="/billing">Billing</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/invoiceCheck">Receipt
							check</a></li>
					<%
					if (session.getAttribute("user") == null) {
					%>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Account </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="/loginPage">Login</a></li>
							<li><a class="dropdown-item" href="/signupPage">Sign Up</a></li>
						</ul></li>
					<%
					} else {
					%>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> <%=session.getAttribute("user").toString()%>
					</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="/logout">Logout</a></li>
							<%
							}
							%>
						</ul>
				</ul>
			</div>
		</div>
	</nav>

	<div id="pageContain">
		<form action="/customerSearch" method="post">
			<div>
				<label for="title">Search Here</label> <input type="text"
					name="searchKey">
			</div>
			<div>
				<label for="title">Search Type</label> <select name="searchType"
					id="type">
					<option value="name">By Customer Name</option>
					<option value="uuid">Using Invoice Number</option>
					<option value="date">Using Visit Date</option>
				</select>
			</div>
			<div id="btn">
				<button type="submit">Search</button>
			</div>
		</form>
		<div id="result">
			<%
			ArrayList<ArrayList<String>> data = (ArrayList<ArrayList<String>>) session.getAttribute("CustomerInvoice");
			%>
			<table>
				<thead>
					<tr>
						<th>Medicine Name</th>
						<th>Expiry Date</th>
						<th>Quantity</th>
						<th>Price</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
					for (ArrayList<String> i : data) {
					%>
					<tr>
						<td><%=i.get(0)%></td>
						<td><%=i.get(1)%></td>
						<td><%=i.get(2)%></td>
						<td><a href="/fetchInvoice/<%=i.get(3)%>">View</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script src="JS/bootstrap.js"></script>
</html>