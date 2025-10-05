<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Thanks for Joining!</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>

<body>

<div class="container">
    <img src="https://cdn-icons-png.flaticon.com/512/2972/2972933.png" alt="Tulip Icon">
    
    <h1>Thanks for Joining!</h1>

    <p>Here is the information that you entered:</p>
    
    <p><span class="info-label">Email:</span> <span class="info-data">${user.email}</span></p>
    <p><span class="info-label">First Name:</span> <span class="info-data">${user.firstName}</span></p>
    <p><span class="info-label">Last Name:</span> <span class="info-data">${user.lastName}</span></p>

    <p class="return-note">Want to enter another email? Click on the Return button below.</p>

    <form action="emailList" method="post" style="box-shadow: none; padding: 0; margin-top: 20px;">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>
</div>

</body>
</html>