package io.hexlet.dto.posts;

import io.hexlet.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PostsPage {
    private List<Post> posts;
    private int pageNumber;
    private int pageSize;
    private boolean hasNextPage;
}
