<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ORGANIC WASTE BOOKING|CLEANVERSE</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Da+2&family=Montserrat:wght@100&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
  
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script defer src="https://use.fontawesome.com/releases/v6.1.1/js/all.js"></script>
  <link rel="stylesheet" href="organic_waste_booking_styles.css">

</head>
<body>
<div class="CompanyName"><h1><b><a class="company-name" href="index.html">CLEANVERSE</a></b></h1></div>
    <div class="header-text">
    <h1>Organic Waste Collection</h1>
    <p>Have organic waste collected so that it can be used for composting.</p>
    </div>
    <div class="service-description">
        <h1>Service Description</h1>
        <p>Services available daily. Earn credits based on the amount of Organic waste per kg</p>
        <p>CREDITS: 30/kg</p>
    </div>
<%
	HttpSession session2=request.getSession(false);
	int userid=(int)session2.getAttribute("id");
	if(userid>0){  
     System.out.println("Hello, "+userid+" Welcome to Profile");
        }  
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").forward(request, response);  
        }
	
	%>
	<div class="service-description">
	 Press Submit to register for this month
	</div>
<div class="login-box">

<form class="form-class" action="slot" method="post">
<input type="hidden" value="<% out.print(userid); %>" name="id" >
<input type="hidden" value="Organic" name="subsname" >
<input type="hidden" value="upto this month" name="slot" >
<input type="submit" value="Submit">
</form>
</div>
<div class="CompanyName"><h3><b><a class="company-name" href="dashboard.jsp">GO TO DASHBOARD </a></b></h3></div>
 <div class="Contact">
        <h1>Contact</h1><br>
        <p>emailcleanverse@gmail.com</p>
    </div>
    <footer id="footer">
        <h3><i class="footer-icon fa-brands fa-twitter"></i><i class="footer-icon fa-brands fa-facebook-f"></i><i class="footer-icon fa-brands fa-instagram"></i><i class="footer-icon fa-solid fa-envelope"></i></h3>
        <p>© Copyright CLEANVERSE</p>
    
      </footer>
</body>
</html>