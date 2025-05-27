@import org.example.hexlet.dto.users.UserPage
@param UserPage page

<html>
<head>
    <title>User ${page.getUser().getFirstName()} ${page.getUser().getLastName()}</title>
</head>
<body>
<div><b>Name: </b> ${page.getUser().getFirstName()}</div>
<div><b>Last name: </b> ${page.getUser().getLastName()}</div>
<div><b>Email: </b> ${page.getUser().getEmail()}</div>
</body>
</html>
