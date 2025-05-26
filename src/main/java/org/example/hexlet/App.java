package org.example.hexlet;

import io.javalin.Javalin;

public class App {
    public static Javalin getApp() {
        var app = Javalin.create(
            config -> config.bundledPlugins.enableDevLogging()
        );

        app.get("/", ctx -> ctx.result("Welcome to Hexlet!"));
        app.get("/phones", ctx -> ctx.json(Data.getPhones()));
        app.get("/domains", ctx -> ctx.json(Data.getDomains()));

        app.get("/users", ctx -> {
           var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
           var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
           var offset = (page - 1) * per;
           ctx.json(Data.getUsers().subList(offset, offset + per));
        });

        return app;
    }

    public static void main(String[] args) {
        var app = getApp();
        app.start(7070);
    }
}
