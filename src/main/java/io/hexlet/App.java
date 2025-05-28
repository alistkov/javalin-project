package io.hexlet;

import io.hexlet.util.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

public class App {
    public static Javalin getApp() {
        var app = Javalin.create(
            config -> {
                config.bundledPlugins.enableDevLogging();
                config.fileRenderer(new JavalinJte());
            }
        );

        app.get(NamedRoutes.homePath(), ctx -> ctx.render("index.jte"));

        return app;
    }

    public static void main(String[] args) {
        var app = getApp();
        app.start(7070);
    }
}
