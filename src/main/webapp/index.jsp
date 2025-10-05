<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>User Management</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<div class="container">
    <h1>Users</h1>

    <div class="table-container">
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th colspan="2">Actions</th>
            </tr>

            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td class="action-links">
                        <a href="userAdmin?action=display_user&amp;email=${user.email}">Update</a>
                    </td>
                    <td class="action-links">
                        <a href="userAdmin?action=delete_user&amp;email=${user.email}" style="color: var(--danger-color);">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="toolbar">
        <form action="userAdmin" method="get">
             <input type="hidden" name="action" value="display_users">
             <button type="submit" class="btn btn-secondary">Refresh List</button>
        </form>
        <form action="emailList" method="post">
            <input type="hidden" name="action" value="join">
            <button type="submit" class="btn btn-primary">Add New User</button>
        </form>
    </div>
</div>

</body>
</html>