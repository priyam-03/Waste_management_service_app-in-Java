<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>NON-RECYCLABLE WASTE BOOKING|CLEANVERSE</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Da+2&family=Montserrat:wght@100&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
  
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script defer src="https://use.fontawesome.com/releases/v6.1.1/js/all.js"></script>
  <link rel="stylesheet" href="non-recyclable_booking_styles.css">
<link rel="stylesheet" href="LOGINstyles.css">
</head>
<body>
<div class="CompanyName"><h1><b><a class="company-name" href="index.html">CLEANVERSE</a></b></h1></div>
    <div class="header-text">
    <h1>Non-Recyclable Waste Collection</h1>
    <p>Give your non recyclable waste so that we can make new products from it.</p>
    </div>
    <div class="service-description">
        <h1>Service Description</h1>
        <p>Services available once a week. Earn credits based on the amount of Non-Recyclable waste per kg</p>
        <p>CREDITS: 15/kg</p>
        
        <p style="text-align:left; margin-left: 30px;">Enter your two slot:</p>
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
	
<div class="login-box">
<form class="form-class" action="slot" method="post">
<input type="hidden" value="<% out.print(userid); %>" name="id" >

<input type="hidden" value="Nonrecyclable" name="subsname" >

<input class="finp" id="name" name="slot1" type="date">
<input class="finp" id="name" name="slot2" type="date">

<input type="submit" value="Submit">

</form>
</div>
<div class="CompanyName"><h3><b><a class="company-name" href="dashboard.jsp">GO TO DASHBOARD </a></b></h3></div>
</body>
</html>