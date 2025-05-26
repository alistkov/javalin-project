package org.example.hexlet;

import io.javalin.Javalin;

public class App {
    public static Javalin getApp() {
        var app = Javalin.create(
            config -> config.bundledPlugins.enableDevLogging()
        );

        app.get("/", ctx -> ctx.result("Welcome to Hexlet!"));
        return app;
    }
    public static void main(String[] args) {
        var app = getApp();
        app.start(7070);
    }
}
