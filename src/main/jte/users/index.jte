@import org.example.hexlet.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Search" />
    </form>
    @if(page.getUsers().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
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
    <button>
        <a href="/users/build">Add user</a>
    </button>
`
)