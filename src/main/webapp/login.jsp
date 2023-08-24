<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="/Css/bootstrap.css">
<link rel="stylesheet" href="/Css/signup.css">
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
	<div class="half pagebg">
		<div class="contents order-2 order-md-1">
			<div class="container">
				<div class="row align-items-center justify-content-center">
					<div class="col-md-7">
						<form action="/userLogin" method="post" autocomplete="off">

							<div class="form-group first">
								<label for="username" spellcheck="false" autocapitalize="false">Username
									: </label> <input type="text" class="form-control"
									placeholder="Your Username" id="username" name="username" required>
							</div>
							<div class="form-group last mb-3">
								<label for="password">Password : </label> <input type="password"
									class="form-control" placeholder="Your Password" id="password"
									name="password" required>
							</div>

							<button type="submit" class="btn btn-block btn-primary">Continue
							</button>
							<br> <a href="/signupPage"
								style="position: relative; text-decoration: none;">Not
								a user ? Create account .</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="JS/bootstrap.js"></script>
</html>