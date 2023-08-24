<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medicine Check</title>
<link rel="stylesheet" href="/Css/medicineCheck.css">
<link rel="stylesheet" href="/Css/bootstrap.css">
<link rel="shortcut icon" href="/Media/Logo.png" type="image/x-icon">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
		<img src="/Media/Logo.png" style="width: 4rem;border-radius: 2rem;">&nbsp; &nbsp;
			<a class="navbar-brand" href="#">HalloDoc</a>
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
					<%if (session.getAttribute("user") == null){%>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Account </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="/loginPage">Login</a></li>
							<li><a class="dropdown-item" href="/signupPage">Sign Up</a></li>
						</ul></li>
					<%}else{ %>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> <%=session.getAttribute("user").toString() %> </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="/logout">Logout</a></li>
					<%} %>
					</ul>
				</ul>
			</div>
		</div>
	</nav>
	<div class="contain">
		<div class="formContener">
			<div class="form">
				<!-- For Check by Name -->


				<input class="cbn" type="radio" name="SingleSilection" id="cbn">
				<label class="form-check-label"> Check By Name </label>
				<hr>
				<div id="cbnid">
					<div class="cbnID">
						<form action="/checkByName" method="get">
							<input type="text" class="form-control"
								placeholder="Medicine Name" name="name">
							<button type="submit">Process</button>
						</form>
					</div>

				</div>



				<!-- For Check by Expiry Date -->
				<div>
					<input class="CBED" type="radio" name="SingleSilection"
						id="chechByDate"> <label class="form-check-label">
						Check By Expiry Date </label>
					<hr>
					<div class="CBEDdetails" id="CBEDdetails">
						<form action="/checkByExpiry" method="get">
							<input type="date" name="expiryDate" id="">
							<button type="submit">Process</button>
						</form>
					</div>
				</div>

				<!-- For Check by Quantity -->
				<div>
					<input class="cbq" type="radio" name="SingleSilection"
						id="cbqcheck"> <label class="form-check-label">
						Check By Quantity </label>
					<div id="cbq" class="checkbyquantity">
						<form action="/checkByQuantity" method="get">
							<div>
								<input type="number" name="quantity">
								<button type="submit">Process</button>
							</div>
						</form>
					</div>
				</div>
				<br>
			</div>
			<div class="result">
				<%
				List<List<String>> data = (List<List<String>>) session.getAttribute("resultData");
				%>
				<table>
					<thead>
						<tr>
							<th>Medicine Name</th>
							<th>Expiry Date</th>
							<th>Quantity</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (List<String> i : data) {
						%>
						<tr>
							<td><%=i.get(0)%></td>
							<td><%=i.get(1)%></td>
							<td><%=i.get(2)%></td>
							<td><%=i.get(3)%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<script src="JS/bootstrap.js"></script>
<script src="JS/medicinecheck.js"></script>
</html>