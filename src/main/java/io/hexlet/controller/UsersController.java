package io.hexlet.controller;

import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import io.hexlet.util.Security;
import io.hexlet.model.User;
import io.hexlet.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.hexlet.repository.UserRepository;
import io.hexlet.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    public static void create(Context ctx) throws Exception {
        // BEGIN (write your solution here)
            var firstName = StringUtils.capitalize(ctx.formParam("firstName"));
            var lastName = StringUtils.capitalize(ctx.formParam("lastName"));
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var encryptedPassword = Security.encrypt(password);
            var token = Security.generateToken();
            var user = new User(firstName, lastName, email, encryptedPassword, token);
            UserRepository.save(user);
            ctx.cookie("token", token);
            ctx.redirect(NamedRoutes.userPath(user.getId()));
        // END
    }

    public static void show(Context ctx) throws Exception {
        // BEGIN (write your solution here)
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("User " + id + " not found"));

        var userToken = user.getToken();
        var cookieToken = ctx.cookie("token");

        if (userToken.equals(cookieToken)) {
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
        // END
    }
}
