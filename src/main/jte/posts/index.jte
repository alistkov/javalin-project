@import io.hexlet.dto.posts.PostsPage
@import io.hexlet.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    @if(page.getPosts().isEmpty())
        <h4>There are no posts!</h4>
    @else
        <ul class="list-group mb-3">
            @for(var post : page.getPosts())
                <li class="list-group-item">
                    <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                </li>
            @endfor
        </ul>
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
    @endif
`
)