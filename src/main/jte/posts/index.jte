@import io.hexlet.dto.posts.PostsPage
@import io.hexlet.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>All posts</h1>

            <table class="table table-striped">
                @for(var post : page.getPosts())
                    <tr>
                        <td>
                            ${post.getId()}
                        </td>
                        <td>
                            <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                        </td>
                        <td>
                            ${post.getBody()}
                        </td>
                    </tr>
                @endfor
            </table>
            <nav>
                <ul class="pagination">
                    <li class="page-item${page.getPageNumber() == 1 ? " disabled" : null}">
                        <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPageNumber() - 1}">Previous</a>
                    </li>
                    <li class="page-item${!page.isHasNextPage() ? " disabled" : null}">
                        <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPageNumber() + 1}">Next</a>
                    </li>
                </ul>
            </nav>
        </main>
    </div>
`
)