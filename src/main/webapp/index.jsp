<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="/Css/index.css">
<link rel="stylesheet" href="/Css/bootstrap.css">
<link rel="shortcut icon" href="/Media/Logo.png" type="image/x-icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
		<div id="notification" class="active">
		<%ArrayList<ArrayList<String>> notification = (ArrayList<ArrayList<String>>) session.getAttribute("notifications"); %>
			<div class="notification fa fa-bell" style="font-size: 24px"
				onclick="notificationPanel()"></div>
			<span class="badge"><%= session.getAttribute("notficationCount") %></span>
			<div id="contains" onmouseleave="notificationPanel()">
			<%
			for(ArrayList<String> i : notification){
			%>
			<h6>
			<span><%=i.get(0) %></span>
			<a href="/makeAsRead/<%=i.get(1)%>" type="button">Make as read</a>
			</h6>
			<%} %>
			</div>
		</div>
	</nav>
	<div id="pageBody">
		<h1 id="headLine">Welcome to Our Pharmacy!</h1>
		<p id="tagLine">We're always here to help you</p>
		<div class="cardsBody">
			<div class="card" style="width: 18rem;">
				<img src="/Media/image1.jpg" class="card-img-top" alt="...">
			</div>
			<div class="card" style="width: 18rem;  18rem;">
				<img src="/Media/image2.jpg" class="card-img-top" alt="...">
			</div>
			<div class="card" style="width: 18rem;  18rem;">
				<img src="/Media/image3.jpg" class="card-img-top" alt="...">
			</div>
			<div class="card" style="width: 18rem;  18rem;">
				<img src="/Media/image4.jpg" class="card-img-top" alt="...">
			</div>
		</div>
	</div>

</body>
<script src="JS/bootstrap.js"></script>
<script src="JS/index.js"></script>
</html>