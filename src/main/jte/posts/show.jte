@import io.hexlet.dto.posts.PostPage
@import io.hexlet.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <main>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${page.getPost().getName()}</h5>
                <p class="card-text">${page.getPost().getBody()}</p>
                <a href="${NamedRoutes.postsPath()}" class="btn btn-primary">Go back</a>
            </div>
        </div>
    </main>
`
)