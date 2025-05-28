package io.hexlet.controller;

import io.hexlet.dto.posts.PostPage;
import io.hexlet.dto.posts.PostsPage;
import io.hexlet.repository.PostRepository;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import static io.javalin.rendering.template.TemplateUtil.model;

public class PostsController {
    public static void index(Context ctx) {
        var pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var pageSize = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);

        var posts = PostRepository.findAll(pageNumber, pageSize);
        var hasNextPage = posts.size() >= pageSize;
        var page = new PostsPage(posts, pageNumber, pageSize, hasNextPage);
        ctx.render("posts/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post with id #" + id + " not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
}
