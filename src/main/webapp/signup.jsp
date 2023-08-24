<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet" href="/Css/bootstrap.css">
<link rel="stylesheet" href="/Css/signup.css">
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
	<div>
		<div class="pagebg">
			<section class="ftco-section">
				<div class="container">
					<div class="row">
						<div class="col-lg-10">
							<div class="wrap d-md-flex">
								<div class="login-wrap p-4 p-md-5">
									<div class="data">
										<form action="/register" class="signup-form" method="post">
											<div class="row">
												<div class="col-md-12">
													<div class="form-group d-flex align-items-center">
														<label class="label" for="first name">First Name</label> <input
															type="text" class="form-control" placeholder="First Name"
															name="fname" required>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group d-flex align-items-center">
														<label class="label" for="last name">Last Name</label> <input
															type="text" class="form-control" placeholder="Last Name"
															name="lname" required>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group d-flex align-items-center">
														<label class="label" for="email">Email Address</label> <input
															type="text" class="form-control"
															placeholder="example@email.com" name="email" required>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group d-flex align-items-center">
														<label class="label" for="username">Username</label> <input
															type="text" class="form-control" placeholder="Username"
															name="uname" required>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group d-flex align-items-center">
														<label class="label" for="phone">Password</label> <input
															type="password" class="form-control" id="PassEntry"
															placeholder="Password" name="pass1" required>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group d-flex align-items-center">
														<label class="label" for="phone">Confirm Password</label>
														<input type="password" class="form-control cp3"
															placeholder="Enter Password again" name="pass2" required>
													</div>
													<br> <span id="StrengthDisp"
														class="badge displayBadge">Weak</span> <br>
												</div>
											</div>

											<div class="col-md-12 my-4">
												<div class="form-group">
													<div class="col-md-12">
														<div class="form-group footerGp">
															<button type="submit"
																class="btn btn-secondary submit p-3">Create an
																account</button>
															<a href="/loginPage" class="toLogin"
																style="position: relative; left: 10%; text-decoration: none;">Already
																a user? Login.</a>
														</div>
														<div style="text-align: center">
															<%
															String massage = session.getAttribute("massage").toString();
															%>
															<p><%=massage%></p>
														</div>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
</body>
<script src="JS/bootstrap.js"></script>
<script src="JS/signup.js"></script>
</html>