<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medicine Entry</title>
<link rel="stylesheet" href="/Css/bootstrap.css">
<link rel="stylesheet" href="/Css/medicineentry.css">
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
	<%String massage = session.getAttribute("massage").toString(); %>
	<div class="formContener">
        <form action="/save" method="get" class="form">
        	<div>
        		<label>Medicine Name</label>
        		<input type="text" name="medicinename" required>
        	</div>
<!--         	<div> -->
<!--         		<label>Entry Date</label> -->
<!--         		<input type="date" name="entrydate" required> -->
<!--         	</div> -->
        	<div>
        		<label>Expiry Date</label>
        		<input type="date" name="expirydate" required>
        	</div>
        	<div>
        		<label>Quantity</label>
        		<input type="number" name="quantity" required>
        	</div>
        	<div>
        		<label>Price per unit</label>
        		<input type="text" name="price" required>
        	</div>
        	<button type="submit" style="background-color: blue;color:white;">Submit</button>
        	<button type="reset" style="background-color: red;color:white;">Clear</button>
        	<p style="color:white;"><%=massage%></p>
        </form>
	
	</div>
    </div>
			
		

</body>
<script src="JS/bootstrap.js"></script>
</html>