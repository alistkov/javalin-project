@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users page</h1>
@if(page.getUsers().isEmpty())
    <p>Пока не добавлено ни одного курса</p>
@else
    <table>
        <tr>
            <th>Name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Link</th>
        </tr>
        @for(var user : page.getUsers())
            <tr>
                <td>${user.getFirstName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getEmail()}</td>
                <td><a href="/users/${user.getId()}">Details</a></td>
            </tr>
        @endfor
    </table>
@endif
</body>
</html>