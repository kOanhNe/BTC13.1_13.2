<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Update User</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<div class="container">
    <h1>Update User</h1>
    <p><i>NOTE: You can't update the email address.</i></p>

    <form action="userAdmin" method="post">
        <input type="hidden" name="action" value="update_user">
        
        <div class="form-group">
            <label>Email:</label>
            <input type="email" name="email" value="${user.email}" readonly style="background-color: #e9ecef;">
        </div>

        <div class="form-group">
            <label>First Name:</label>
            <input type="text" name="firstName" value="${user.firstName}" required>
        </div>

        <div class="form-group">
            <label>Last Name:</label>
            <input type="text" name="lastName" value="${user.lastName}" required>
        </div>
        
        <div class="form-actions">
             <button type="submit" class="btn btn-primary">Update User</button>
        </div>
    </form>
    
    <form action="userAdmin" method="post">
        <input type="hidden" name="action" value="display_users">
        <button type="submit" class="btn btn-secondary">Cancel and Return</button>
    </form>
</div>
</body>
</html>