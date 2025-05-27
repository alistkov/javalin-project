package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.apache.commons.lang3.StringUtils;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.util.Security;


import java.util.List;
import java.util.Objects;

import static io.javalin.rendering.template.TemplateUtil.model;

public class App {
    public static Javalin getApp() {
        var app = Javalin.create(
            config -> {
                config.bundledPlugins.enableDevLogging();
                config.fileRenderer(new JavalinJte());
            }
        );

        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            var users = term == null ? UserRepository.getEntities() : UserRepository.getEntities().stream()
                .filter(u -> StringUtils.startsWithIgnoreCase(u.getFirstName(), term))
                .toList();

            var page = new UsersPage(users, term);
            ctx.render("users/index.jte", model("page", page));
        });

        app.post("/users", ctx -> {
            var name = StringUtils.capitalize(Objects.requireNonNull(ctx.formParam("firstName")).trim());
            var lastName = StringUtils.capitalize(Objects.requireNonNull(ctx.formParam("lastName")).trim());
            var email = Objects.requireNonNull(ctx.formParam("email")).trim().toLowerCase();
            var password = Security.encrypt(Objects.requireNonNull(ctx.formParam("password")));

            var user = new User(name, lastName, email, password);
            UserRepository.save(user);

            ctx.redirect("/users");
        });

        app.get("/users/build", ctx -> ctx.render("users/build.jte"));

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));

            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        });

        return app;
    }

    public static void main(String[] args) {
        var app = getApp();
        app.start(7070);
    }
}
