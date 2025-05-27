package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.apache.commons.lang3.StringUtils;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;


import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class App {
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {
        var app = Javalin.create(
            config -> {
                config.bundledPlugins.enableDevLogging();
                config.fileRenderer(new JavalinJte());
            }
        );

        app.get("/", ctx -> ctx.render("index.jte"));
        app.get("/phones", ctx -> ctx.json(Data.getPhones()));
        app.get("/domains", ctx -> ctx.json(Data.getDomains()));

        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            var users = term == null ? USERS : USERS.stream()
                    .filter(u -> StringUtils.startsWithIgnoreCase(u.getFirstName(), term))
                    .toList();
            var page = new UsersPage(users, term);

            ctx.render("users/index.jte", model("page", page));
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var user = USERS.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);

            if (user == null) {
                throw new NotFoundResponse("User with id #" + id + " not found");
            }

            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        });

        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var company = Data.getCompanies().stream()
                .filter(c -> c.get("id").equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundResponse("Company with id #" + id + " not found"));

            ctx.json(company);
        });

        app.get("/companies", ctx -> ctx.json(Data.getCompanies()));

        return app;
    }

    public static void main(String[] args) {
        var app = getApp();
        app.start(7070);
    }
}
