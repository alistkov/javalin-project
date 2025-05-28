@import gg.jte.Content
@import io.hexlet.util.NamedRoutes
@param Content content


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>JTE course</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="${NamedRoutes.homePath()}">Navbar</a>
        <div class="d-flex collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${NamedRoutes.homePath()}">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${NamedRoutes.postsPath()}">Posts</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<main class="container p-5">
    ${content}
</main>
</body>
</html>
