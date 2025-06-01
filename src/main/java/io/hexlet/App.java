package io.hexlet;

import io.javalin.Javalin;
import io.hexlet.controller.PostsController;
import io.hexlet.controller.RootController;
import io.hexlet.util.NamedRoutes;
import io.javalin.rendering.template.JavalinJte;
import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get(NamedRoutes.rootPath(), RootController::index);

        app.get(NamedRoutes.buildPostPath(), PostsController::build);
        app.post(NamedRoutes.postsPath(), PostsController::create);

        app.get(NamedRoutes.postsPath(), PostsController::index);
        app.get(NamedRoutes.postPath("{id}"), PostsController::show);

        app.get(NamedRoutes.editPath("{id}"), PostsController::edit);
        app.post(NamedRoutes.postPath("{id}"), PostsController::update);

        // BEGIN (write your solution here)
        app.after(ctx -> {
            var body = ctx.body();
            var hashData = DigestUtils.sha256Hex(body);
            ctx.header("X-Response_Digest", hashData);
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}



