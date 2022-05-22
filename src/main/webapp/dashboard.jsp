<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CLEANVERSE|Dashboard</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Da+2&family=Montserrat:wght@100&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
  
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  <script defer src="https://use.fontawesome.com/releases/v6.1.1/js/all.js"></script>
  <link rel="stylesheet" href="styles.css">
  <script type="text/javascript">
  window.history.forward();
  function noBack() {
      window.history.forward();
  }
    </script>
</head>
<body onload="userDetails()">

	
	
	<% 
	
	int userid=0;
	HttpSession session1=request.getSession(false);
	
	if(session1.getAttribute("name")!=null){  
        String name=(String)session1.getAttribute("name");  
          
        out.print("Hello, "+name+" Welcome to Profile");  
     System.out.println("Hello, "+name+" Welcome to Profile");
      userid=(int)session1.getAttribute("id");
        }  
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").forward(request, response);  
        } 
	%>
<a href="logout"class="btn btn-outline-success" type="submit" >Log out</a>
<input type="hidden" value="<% out.print(userid);%>" id="userid">
<div id="res3"></div>
    <section id="Plans">
        <h1 class="plan-heading">OUR PLANS</h1>
        <div class="row">
            <div class="col-lg-3">
                <div class="card">
                    <h5 class="card-header">E-Waste Pickup</h5>
                    <div class="card-body">
                      <h5 class="card-title">CREDITS:800/kg</h5>
                      <p class="card-text">Collection of electronic and electrical waste right from your doorstep</p>
                      <a href="E_waste.jsp" class="btn btn-success btn-lg">Book Now!</a>
                    </div>
                  </div>
            </div>
            <div class="col-lg-3">
                <div class="card">
                    <h5 class="card-header">Recyclable Waste Collection</h5>
                    <div class="card-body">
                      <h5 class="card-title">CREDITS: 100/kg</h5>
                      <p class="card-text">Collection of recyclables from your home for efficient reuse. </p>
                      <a href="Recyclable.jsp" class="btn btn-success btn-lg">Book Now!</a>
                    </div>
                  </div>
            </div>
            <div class="col-lg-3">
                <div class="card">
                    <h5 class="card-header">Non-Recyclable Waste Collection</h5>
                    <div class="card-body">
                      <h5 class="card-title">CREDITS: 15/kg</h5>
                      <p class="card-text">Collection of Non-recyclable-inorganic waste right from your doorstep</p>
                      <a href="Nonrecyclable.jsp" class="btn btn-success btn-lg">Book Now!</a>
                    </div>
                  </div>
            </div>
            <div class="col-lg-3">
                <div class="card">
                    <h5 class="card-header">Organic Waste Collection</h5>
                    <div class="card-body">
                      <h5 class="card-title">CREDITS: 30/kg</h5>
                      <p class="card-text">Collection of organic ie. perishable waste.</p>
                      <a href="Organic.jsp" class="btn btn-success btn-lg">Book Now!</a>
                    </div>
                  </div>
            </div>
        </div>
    </section>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>

function userDetails() {
	var userid = document.getElementById("userid").value;
	$.ajax({
		url: "getoneuserdata",
		method: "get",
		data: {"id":userid},
		success: function(response)
		{			
			console.log(response);
			var jsonobj3 = JSON.parse(response);
			console.log(jsonobj3);
			var temp3="";
			temp3 = "<table>";
			temp3 = temp3+"<tr><th>SUBSCRIPTION</th><th>SLOT</th></tr>";
	        for (i = 0; i < jsonobj3.length; i++){
	            temp3 = temp3 + "<tr>";
	            temp3 = temp3 + "<td>" + jsonobj3[i].subsname + "</td>";
	            temp3 = temp3 + "<td>" + jsonobj3[i].slot + "</td>";
	            temp3 = temp3 + "</tr>";
	            } 
	            temp3 = temp3 + "</table>";
	            document.getElementById("res3").innerHTML = temp3;
		    }
		})
}
function Organic(){
	window.location.href="Organic.jsp";
}
function Recyclable(){
	window.location.href="Recyclable.jsp";
}

function Non_recylable(){
	window.location.href="Nonrecyclable.jsp";
}
function E_waste(){
	window.location.href="E_waste.jsp";
}

</script>
</body>
</html>