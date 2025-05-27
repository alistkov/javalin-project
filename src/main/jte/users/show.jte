@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
    <div><b>Name: </b> ${page.getUser().getFirstName()}</div>
    <div><b>Last name: </b> ${page.getUser().getLastName()}</div>
    <div><b>Email: </b> ${page.getUser().getEmail()}</div>
`
)
