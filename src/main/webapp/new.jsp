<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Join Our Email List</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<form action="emailList" method="post">
    <h1>Join our email list</h1>
    <p>To join our email list, enter your name and email address below.</p>
    
    <p class="error-message"><i>${message}</i></p>

    <input type="hidden" name="action" value="add">
    
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${user.email}" required>
    
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" value="${user.firstName}" required>
    
    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" value="${user.lastName}" required>
    
    <input type="submit" value="Join Now">
</form>

</body>
</html>