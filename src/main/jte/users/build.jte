@template.layout.page(
content = @`
    <form action="/users" method="post">
        <input type="text" name="firstName" required />
        <input type="text" name="lastName" required />
        <input type="text" name="email" required />
        <input type="password" name="password" required />
        <input type="submit" value="Create" />
    </form>
`
)