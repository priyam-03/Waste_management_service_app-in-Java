<%@page import="java.util.ArrayList"%>

<%@page import="bean.insert"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DASHBOARD|CLEANVERSE</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Da+2&family=Montserrat:wght@100&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
  
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script defer src="https://use.fontawesome.com/releases/v6.1.1/js/all.js"></script>
  <link rel="stylesheet" href="organic_waste_booking_styles.css">
  <script type="text/javascript">
  window.history.forward();
  function noBack() {
      window.history.forward();
  }
    </script>
</head>
<body onload="showAlluser()">
	<section id="CompanyName">
        <div>
            <a class="company-name" href="index.html">
                <h1>HOME PAGE</h1>
            </a>
        </div>
    </section>
    <a href="collector_logout"class="btn btn-outline-success" type="submit" >Log out</a>
<%
int userid=0;
HttpSession session5=request.getSession(false);

if(session5.getAttribute("name")!=null){  
    String name=(String)session5.getAttribute("name");  
      
    out.print("Hello, "+name+" Welcome to Profile");  
 System.out.println("Hello, "+name+" Welcome to Profile");
  userid=(int)session5.getAttribute("id");
    }  
    else{  
        out.print("Please login first");  
        request.getRequestDispatcher("login_collector.html").forward(request, response);  
    } 
	
	insert obj = new insert();
	ArrayList<insert> allList = obj.getuserdata();
	
	
	out.print("<select id='userid' onchange='getcredit()'>");
	out.print("<option value='0'>"+"select any option"+"</option>");
	for(int i=0; i<allList.size(); i++)
	{
		out.print("<option value="+allList.get(i).getId()+">"+allList.get(i).getEmail()+"</option>");
		
	}
	out.print("</select>");
	
	%>
	<input class="finp" id="credit" type="number">
	<button class="btn btn-success" onclick="changecredit()">Submit</button>
	<div id="res3"></div>
	
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>	
<script>
function showAlluser() {
	
	$.ajax({
		url: "getcompeteuserdata",
		method: "get",
		data: {},
		success: function(response)
		{			
			console.log(response);
			var jsonobj3 = JSON.parse(response);
			console.log(jsonobj3);
			var temp3="";
			temp3 = "<table>";
			temp3 = temp3+"<tr><th>NAME</th><th>EMAIL</th><th>ADDRESS</th><th>SUBSCRIPTION</th><th>SLOT</th></tr>";
	        for (i = 0; i < jsonobj3.length; i++){
	            temp3 = temp3 + "<tr>";
	            temp3 = temp3 + "<td>" + jsonobj3[i].name + "</td>";
	            temp3 = temp3 + "<td>" + jsonobj3[i].email + "</td>";
	            temp3 = temp3 + "<td>" + jsonobj3[i].address + "</td>";
	            temp3 = temp3 + "<td>" + jsonobj3[i].subsname + "</td>";
	            temp3 = temp3 + "<td>" + jsonobj3[i].slot + "</td>";
	            temp3 = temp3 + "</tr>";
	            } 
	            temp3 = temp3 + "</table>";
	            document.getElementById("res3").innerHTML = temp3;
		    }
		})
		
}
var credit;
var enteredcredit;
var userid;
function getcredit(){
userid =document.getElementById("userid").value; 
	$.ajax({
		url: "credit",
		method: "post",
		data: {"id":userid},
		success: function(response)
		{			
			console.log(response);
			credit = parseInt(response);
			
		}
		})



}
function changecredit(){
	enteredcredit=document.getElementById("credit").value;
	credit = parseInt(enteredcredit)+ parseInt(credit);
	console.log(userid);
	console.log(credit);
	
	$.ajax({
		url: "insert_credit",
		method: "post",
		data: {"id":userid, "credit": credit},
		success: function(response)
		{			
			console.log(response);
		
		}		
		})



}

</script>	
</body>
</html>