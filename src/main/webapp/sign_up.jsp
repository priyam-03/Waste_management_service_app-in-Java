<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="ISO-8859-1"><title>Sign-in|CLEANVERSE</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Baloo+Da+2&family=Montserrat:wght@100&family=Ubuntu:wght@300&display=swap"
        rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v6.1.1/js/all.js"></script>
    <link rel="stylesheet" href="LOGINstyles.css">
</head>

<body>
    <section id="CompanyName">
        <div>
            <a class="company-name" href="index.html">
                <h1>CLEANVERSE</h1>
            </a>
        </div>
    </section>
    <section id="Form">

        <div class="login-box">
            <form class="form-class" action="insert_data" method="post">
                <p>
                <h3>Register Yourself</h3>
                </p>
                <p style="text-align:left; margin-left: 30px;">Enter your Name:</p>
                <p><input class="finp" id="name" name="name" type="text" placeholder="Enter here"></p>
                <p style="text-align:left; margin-left: 30px;">Enter your address:</p>
                <p><input class="finp" id="address" name="address" type="text" placeholder="Enter here"></p>
                <p style="text-align:left; margin-left: 30px;">Enter your Email-id:</p>
                <p><input class="finp" id="email" name="email" type="email" placeholder="Enter here"></p>
                <p style="text-align:left; margin-left: 30px;">Create Password</p>
                <p><input class="finp" id="password" name="password" type="password" placeholder="Enter here"></p>

                <button type="submit" class="btn btn-success">Sign-up</button>

            </form>
        </div>
    </section>
    <footer id="footer">
        <h3><i class="footer-icon fa-brands fa-twitter"></i><i class="footer-icon fa-brands fa-facebook-f"></i><i
                class="footer-icon fa-brands fa-instagram"></i><i class="footer-icon fa-solid fa-envelope"></i></h3>
        <p>© Copyright CLEANVERSE</p>

    </footer>
</body>

</html>
